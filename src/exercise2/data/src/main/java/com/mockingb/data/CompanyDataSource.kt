package com.mockingb.data

import com.mockingb.model.Company

interface CompanyDataSource {
    fun getAllCompanies(): List<Company>
    fun getCompanyById(id: Int): Company?
}