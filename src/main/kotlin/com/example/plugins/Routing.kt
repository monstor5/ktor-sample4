package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import java.lang.reflect.Array.get

fun Application.configureRouting() {

    routing {
        get("//") {
            var a = call.request.queryParameters["a"]?.toInt()
            var b = call.request.queryParameters["b"]?.toInt()
            var options = call.request.queryParameters["opt"]?.toInt() ?: 0

            if (a != null && b != null)
                if (options == 0) {
                    call.respondText((a + b).toString())
                }
            if (options == 1) {
                if (a != null) {
                    call.respondText((a - b!!).toString())
                }
            }
            if (options == 2) {
                if (a != null) {
                    call.respondText((a * b!!).toString())
                }
            }
            if (options == 3) {
                if (a != null) {
                    call.respondText((a / b!!).toString())
                }
            }

        }
      get("/") {
            var id = call.parameters["id"]?.toInt()
            var a = call.parameters["a"]?.toInt() ?: 0
            var b = call.parameters["b"]?.toInt() ?: 0
            var tпа = (a..b).random()
            var lol = listOf("матвей", "алексей", "жора")
            var k = 0
            if (id != null && id < 3) {

                call.respondText((tпа.toString() + lol?.shuffled().take(1).toString()))

            } else {
                id = 1
                call.respondText(lol.get(id))
            }
        }


    }
}


