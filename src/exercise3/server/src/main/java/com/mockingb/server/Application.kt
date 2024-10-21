package com.mockingb.server

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
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
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
            val responseText = companies.joinToString("\n") { company ->
                """<a href=companies/${company.id}>$company</a?><br>"""
            }
            call.respondText(
                responseText,
                contentType = io.ktor.http.ContentType.Text.Html,
                status = io.ktor.http.HttpStatusCode.OK
            )
        }
        get("/companies/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val company = id?.let { service.getCompanyById(it) }
            if (company != null) {
                call.respondText(
                    "Company Details: Name: ${company.name}, Activity: ${company.activity}, Contacts: ${company.contacts}",
                    status = io.ktor.http.HttpStatusCode.OK
                )
            } else {
                call.respondText("Company Not Found", status = io.ktor.http.HttpStatusCode.NotFound)
            }
        }
        get("/vacancies") {
            val vacancies = service.getAllVacancies()
            val responseText = vacancies.joinToString("<br><br>") { (vacancy, companyName) ->
                """Job Title: ${vacancy.profession}<br>Level: ${vacancy.level}<br>Salary: ${vacancy.salary}<br>Company: $companyName"""
            }
            call.respondText(
                responseText, contentType = io.ktor.http.ContentType.Text.Html,
                status = io.ktor.http.HttpStatusCode.OK
            )
        }
    }
}