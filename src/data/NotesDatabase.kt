package com.nongmah.data

import com.nongmah.data.collections.Note
import com.nongmah.data.collections.User
import com.nongmah.security.isPasswordCorrect
import org.litote.kmongo.contains
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.setValue

private val client = KMongo.createClient().coroutine
private val database = client.getDatabase("NotesDatabase")
private val users = database.getCollection<User>()
private val notes = database.getCollection<Note>()

suspend fun registerUser(user: User): Boolean {
    return users.insertOne(user).wasAcknowledged()
}

suspend fun checkIfUserExists(email: String): Boolean {
    return users.findOne(User::email eq email) != null
}

suspend fun checkPasswordForEmail(email: String, passwordToCheck: String): Boolean {
    val passwordHash = users.findOne(User::email eq email)?.password ?: return false
    return isPasswordCorrect(passwordToCheck, passwordHash)
}

suspend fun getNotesForUser(email: String): List<Note> {
    return notes.find(Note::owners contains email).toList()
}

suspend fun saveNote(note: Note): Boolean {
    val noteExists = notes.findOneById(note.id) != null
    return if (noteExists) {
        notes.updateOneById(note.id, note).wasAcknowledged()
    } else {
        notes.insertOne(note).wasAcknowledged()
    }
}

suspend fun isOwnerOfNote(noteID: String, owner: String): Boolean {
    val note =  notes.findOneById(noteID) ?: return false
    return owner in note.owners
}

suspend fun addOwnerToNote(noteID: String, owner: String): Boolean {
    val owners = notes.findOneById(noteID)?.owners ?: return false
    return notes.updateOneById(noteID, setValue(Note::owners, owners + owner)).wasAcknowledged()
}

suspend fun deleteNoteForUser(email: String, noteID: String): Boolean {
    val note = notes.findOne(Note::id eq noteID, Note::owners contains email)
    note?.let {
        if (note.owners.size > 1) {
            // the note has multiple owners, so we just delete the email from the owners list
            val newOwner = note.owners - email
            val updateResult = notes.updateOne(Note::id eq note.id, setValue(Note::owners, newOwner))
            return updateResult.wasAcknowledged()
        }
        return notes.deleteOneById(note.id).wasAcknowledged()
    } ?: return false
}