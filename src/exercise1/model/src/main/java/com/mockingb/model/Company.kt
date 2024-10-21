package com.mockingb.model

enum class CompanyActivity {
    IT, BANKING,PUBLIC_SERVICES;

    override fun toString(): String {
        return when(this)
        {
            IT -> "Information technology"
            BANKING -> "Banking"
            PUBLIC_SERVICES -> "Public Services"
        }

    }
}
data class Company(
    val id: Int = 0,
    val name: String,
    val activity: CompanyActivity,
    val vacancies: List<String>,
    val contacts: List<String>
){
    override fun toString(): String {
        return "Company(name=$name, activity=$activity)"
    }
}