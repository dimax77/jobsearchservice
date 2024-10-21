package com.mockingb.testdatasource

import com.mockingb.data.ResumeDataSource
import com.mockingb.model.CandidateInfo
import com.mockingb.model.Contacts
import com.mockingb.model.Education
import com.mockingb.model.JobExperience
import com.mockingb.model.Resume
import java.time.LocalDate

class TestResumeDataSource : ResumeDataSource {
    //    private var nextId: Int = 1
    private val resumeList = mutableListOf(
        Resume(
            0,
            candidateInfo = CandidateInfo(
                name = "Vasiliev Sergei Petrovich",
                profession = "QA", "male", LocalDate.of(1998, 9, 30), contacts = Contacts(
                    "72938572843",
                    "vspetrovich@pochta.ru"
                ), relocation = "Possible"
            ), education = listOf(
                Education(
                    type = "higher",
                    yearStart = 2017,
                    yearEnd = 2021,
                    description = "Mathematics in state university"
                ),
                Education(
                    type = "secondary special",
                    yearStart = 2013,
                    yearEnd = 2017,
                    description = "College of informatics"
                ),
                Education(
                    type = "secondary",
                    yearStart = 2005,
                    yearEnd = 2013,
                    description = "Lyceum 156"
                )
            ), jobExperience = listOf(
                JobExperience(
                    dateStart = "08.2021",
                    dateEnd = "04.2022",
                    companyName = "FinTech",
                    description = "Some fintech company creating a business platform"
                ),
                JobExperience(
                    dateStart = "05.2022",
                    dateEnd = "01.2023",
                    "SoftProm",
                    description = "Typical galley"
                )
            ), freeForm = "I'm a QA specialist from head to heels. ..."
        )
    )

    override fun getAllResume(): List<Resume> {
        TODO("Not yet implemented")
    }

    override fun getResume(): String {
        return testResume
    }

    override fun getResumeById(id: Int): Resume? {
        return resumeList.find { it.id == id }
    }

    override fun saveResume(resume: Resume): Int {
        val resId: Int
        val existingResumeIndex = resumeList.indexOfFirst { it.id == resume.id }
        if (existingResumeIndex != -1) {
            resumeList[existingResumeIndex] = resume
            resId = existingResumeIndex
        } else {
            resumeList.add(resume)
            resId = resume.id
        }
        return resId
    }
}

const val testResume = """{"id":"0",
  "candidate_info": {
    "name": "Vasiliev Sergei Petrovich",
    "profession": "QA",
    "sex": "male",
    "birth_date": "30.09.1998",
    "contacts": {
      "phone": "72938572843",
      "email": "vspetrovich@pochta.ru"
    },
    "relocation": "possible"
  },
  "education": [
    {
      "type": "higher",
      "year_start": "2017",
      "year_end": "2021",
      "description": "Mathematics in state university"
    },
    {
      "type": "secondary special",
      "year_start": "2013",
      "year_end": "2017",
      "description": "College of informatics"
    },
    {
      "type": "secondary",
      "year_start": "2005",
      "year_end": "2013",
      "description": "Lyceum 156"
    }
  ],
  "job_experience": [
    {
      "date_start": "08.2021",
      "date_end": "04.2022",
      "company_name": "FinTech",
      "description": "Some fintech company creating a business platform"
    },
    {
      "date_start": "05.2022",
      "date_end": "01.2023",
      "company_name": "SoftProm",
      "description": "Typical galley"
    }
  ],
  "free_form": "I'm a QA specialist from head to heels. ..."
}
"""