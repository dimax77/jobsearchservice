package com.mockingb.testdatasource

import com.mockingb.data.CompanyDataSource
import com.mockingb.model.Company
import com.mockingb.model.CompanyActivity
import com.mockingb.model.Vacancy
import com.mockingb.model.VacancyLevel
import com.mockingb.model.VacancyProfession


class TestDataSource : CompanyDataSource {
    private val companies = listOf(
        Company(
            1,
            "Company 1",
            CompanyActivity.BANKING,
            listOf(
                Vacancy(
                    profession = VacancyProfession.QA,
                    level = VacancyLevel.MIDDLE,
                    salary = "$1000",
                    description = ""
                ), Vacancy(
                    profession = VacancyProfession.ANALYST,
                    level = VacancyLevel.SENIOR,
                    salary = "$1500",
                    description = ""
                )
            ),
            listOf("telephone 1")
        ), Company(
            2,
            "Company 2",
            CompanyActivity.IT,
            listOf(
                Vacancy(
                    profession = VacancyProfession.DESIGNER,
                    level = VacancyLevel.JUNIOR,
                    salary = "$300",
                    description = ""
                ), Vacancy(
                    profession = VacancyProfession.DEVELOPER,
                    level = VacancyLevel.SENIOR,
                    salary = "$3000",
                    description = ""
                )
            ),
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