package com.nongmah.security

import org.mindrot.jbcrypt.BCrypt

fun getHashWithSalt(stringToHash: String): String {
    return BCrypt.hashpw(stringToHash, BCrypt.gensalt())
}

fun isPasswordCorrect(password: String, passwordHash:String): Boolean {
    return BCrypt.checkpw(password, passwordHash)
}