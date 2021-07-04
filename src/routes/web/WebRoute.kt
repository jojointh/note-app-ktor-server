package com.nongmah.routes.web

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.webRoute() {
    get("/") {
        call.respond(FreeMarkerContent("home.ftl", null))
    }
    get("/privacy") {
        val params = mutableMapOf<String, Any>()
        params["page_title"] = "Privacy Policy"
        params["policies"] = listOf("a", "b", "c")
        call.respond(FreeMarkerContent("privacy.ftl", params))
    }
}