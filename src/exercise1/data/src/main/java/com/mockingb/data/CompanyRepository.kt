package com.mockingb.data

import com.mockingb.model.Company

class CompanyRepository(private val dataSource: CompanyDataSource) {
    fun getAllCompanies(): List<Company> {
        return dataSource.getAllCompanies()
    }

    fun getCompanyById(id: Int): Company? {
        return dataSource.getCompanyById(id)
    }
}