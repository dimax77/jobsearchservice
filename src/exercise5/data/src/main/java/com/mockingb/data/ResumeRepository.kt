package com.mockingb.data

import com.mockingb.model.Resume

class ResumeRepository(val resumeDataSource: ResumeDataSource) {
    fun getResume(id: Int = 0): String {
        return resumeDataSource.getResume()

    }

    fun saveResume(resume: Resume): Int {
        return resumeDataSource.saveResume(resume)
    }
}