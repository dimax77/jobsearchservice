package com.mockingb.data

import com.mockingb.model.Resume

interface ResumeDataSource {
    fun getAllResume(): List<Resume>
    fun getResumeById(id: Int): Resume?

    fun getResume(): String
    fun saveResume(resume: Resume): Int
}