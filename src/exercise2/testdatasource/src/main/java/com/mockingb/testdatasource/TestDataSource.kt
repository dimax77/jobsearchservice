package com.mockingb.testdatasource

import com.mockingb.data.CompanyDataSource
import com.mockingb.model.Company
import com.mockingb.model.CompanyActivity


class TestDataSource : CompanyDataSource {
    private val companies = listOf(
        Company(
            1,
            "Company 1",
            CompanyActivity.BANKING,
            listOf("Vacancy 1", "Vacancy 2"),
            listOf("telephone 1")
        ), Company(
            2,
            "Company 2",
            CompanyActivity.IT,
            listOf("Vacancy 1", "Vacancy 2"),
            listOf("telephone 1", "telephone 2")
        ), Company(
            3,
            "Company 3",
            CompanyActivity.PUBLIC_SERVICES,
            emptyList(),
            listOf("telephone 1", "telephone 2", "telephone 3")
        )
    )

    override fun getAllCompanies(): List<Company> {
        return companies
    }

    override fun getCompanyById(id: Int): Company? {
        return companies.find { it.id == id }
    }

}