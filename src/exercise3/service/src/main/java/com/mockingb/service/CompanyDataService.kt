package com.mockingb.service

import com.mockingb.data.CompanyRepository
import com.mockingb.model.Company
import com.mockingb.model.Vacancy

class CompanyDataService(private val repository: CompanyRepository) {
    fun getAllCompanies(): List<Company> {
        return repository.getAllCompanies()
    }

    fun getCompanyById(id: Int): Company? {
        return repository.getCompanyById(id)
    }

    fun getAllVacancies(): List<Pair<Vacancy, String>> {
        return repository.getAllCompanies().flatMap { company ->
            company.vacancies.map { vacancy -> vacancy to company.name }
        }
    }
}