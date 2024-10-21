package com.mockingb.server

//import com.mockingb.companydataservice.CompanyDataService
import com.mockingb.data.CompanyRepository
import com.mockingb.service.CompanyDataService
import com.mockingb.testdatasource.TestDataSource
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val repository = CompanyRepository(TestDataSource())
    val service = CompanyDataService(repository)

    routing {
        get("/") {
            call.respondText("Ktor running")
        }
        get("/companies") {
//            call.respondText("under construction")
            val companies = service.getAllCompanies()
            val responseText = companies.joinToString("\n")
            call.respondText { responseText }
        }
    }
}