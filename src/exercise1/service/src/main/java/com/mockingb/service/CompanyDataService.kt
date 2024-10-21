package com.mockingb.service

import com.mockingb.data.CompanyRepository
import com.mockingb.model.Company

class CompanyDataService (private val repository: CompanyRepository){
    fun getAllCompanies(): List<Company> {
        return repository.getAllCompanies()
    }

    fun getCompanyById(id: Int): Company? {
        return repository.getCompanyById(id)
    }
}