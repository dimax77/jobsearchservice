package com.mockingb.model

enum class VacancyProfession {
    DEVELOPER, QA, PROJECT_MANAGER, ANALYST, DESIGNER;

    override fun toString(): String {
        return when (this) {
            DEVELOPER -> "Developer"
            QA -> "QA"
            PROJECT_MANAGER -> "Project Manager"
            ANALYST -> "Analyst"
            DESIGNER -> "Designer"
        }
    }
}

enum class VacancyLevel {
    JUNIOR, SENIOR, MIDDLE;

    override fun toString(): String {
        return when (this) {
            JUNIOR -> "junior"
            SENIOR -> "senior"
            MIDDLE -> "middle"
        }
    }
}

data class Vacancy(
    val profession: VacancyProfession,
    val level: VacancyLevel,
    val salary: String,
    val description: String
)