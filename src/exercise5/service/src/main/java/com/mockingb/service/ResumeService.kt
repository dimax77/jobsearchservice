package com.mockingb.service

import com.mockingb.data.ResumeRepository
import com.mockingb.model.Resume

class ResumeService(val resumeRepository: ResumeRepository) {
    fun getResume(): String {
        return resumeRepository.getResume()
    }

    fun saveResume(resume: Resume): Int {

//        val resumeRepository
        println(resume.toString())
        return resumeRepository.saveResume(resume)
    }
}