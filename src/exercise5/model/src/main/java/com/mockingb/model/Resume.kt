package com.mockingb.model

//import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class Contacts(val phone: String, val email: String)

@Serializable
data class CandidateInfo(
    val name: String,
    val profession: String,
    val sex: String,
    val birthDate: LocalDate,
    val contacts: Contacts,
    val relocation: String
)


@Serializable
data class Education(
    val type: String, val yearStart: Int, val yearEnd: Int, val description: String
)

@Serializable
data class JobExperience(
    val dateStart: String, val dateEnd: String, val companyName: String, val description: String
)

@Serializable
data class Resume(
    val id: Int = 0,
    val candidateInfo: CandidateInfo? = null,
    val education: List<Education>? = null,
    val jobExperience: List<JobExperience>? = null,
    val freeForm: String? = null,
) {
    override fun toString(): String {
        return buildString {
            append("Block 1\n")
            append("$candidateInfo\n\n")
            append("Block 2\n")
            append("$education\n\n")
            append("Block 3\n")
            append("$jobExperience\n\n")
            append("Block 4\n")
            append("$freeForm\n\n")
        }
    }
}

fun resumeJsonParse(jsonData: String): Resume {


    val startContacts = jsonData.indexOf("{", jsonData.indexOf("\"contacts\":"))
    val endContacts = jsonData.indexOf("}", startContacts)
    val contacts = jsonData.substring(startContacts, endContacts + 1)
    var tmpJsonString = jsonData.replace(contacts, "TMP_CONTACTS")

    val education =
        tmpJsonString.substring(tmpJsonString.indexOf("["), tmpJsonString.indexOf("]") + 1)
    tmpJsonString = tmpJsonString.replace(education, "TMP_EDU")

    val jobExperience =
        tmpJsonString.substring(tmpJsonString.indexOf("["), tmpJsonString.indexOf("]") + 1)
    tmpJsonString = tmpJsonString.replace(jobExperience, "TMP_JOB")

    val freeForm =
        getMappedString(
            tmpJsonString.substring(
                tmpJsonString.indexOf("free_form") - 1,
                tmpJsonString.length - 2
            )
        )
    val id: Int = if (tmpJsonString.indexOf("id") != -1) {
        val t = getMappedString(
            tmpJsonString.substring(
                tmpJsonString.indexOf("id") - 1,
                tmpJsonString.length - 2
            )
        )
        t["id"]!!.toInt()
    } else {
        -1
    }
    println(id)

    val contactsMap = getMappedString(simpleJsonParse("{$contacts").first())

    val educationList = simpleJsonParse("{$education").map { getMappedString(it) }.map {
        Education(
            it["type"] as String,
            (it["year_start"] as String).toInt(),
            (it["year_end"] as String).toInt(),
            it["description"] as String
        )
    }

    val jobList = simpleJsonParse("{$jobExperience").map { getMappedString(it) }.map {
        JobExperience(
            it["date_start"] as String,
            it["date_end"] as String,
            it["company_name"] as String,
            it["description"] as String
        )
    }

    val candidateInfoMap = getMappedString(simpleJsonParse(tmpJsonString).first())
    val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val candidateInfo = CandidateInfo(
        name = candidateInfoMap["name"] ?: "",
        profession = candidateInfoMap["profession"] ?: "",
        sex = candidateInfoMap["sex"] ?: "",
        birthDate = LocalDate.parse(candidateInfoMap["birth_date"] ?: "", dateFormatter),
        contacts = Contacts(
            phone = contactsMap["phone"] ?: "",
            email = contactsMap["email"] ?: ""
        ),
        relocation = candidateInfoMap["relocation"] ?: ""
    )

    return Resume(
        id = id,
        candidateInfo,
        educationList,
        jobList,
        freeForm["free_form"]
    )
}

fun simpleJsonParse(jsonString: String): List<String> {
    val objects = mutableListOf<String>()
    var count = 0
    var tmpString = ""

    jsonString.filter { it != '\n' }.removePrefix("{").forEach { char ->
        when (char) {
            '{' -> {
                count++
                if (count > 1) tmpString += char
            }

            '}' -> {
                count--
                if (count == 0) {
                    objects.add(tmpString)
                    tmpString = ""
                } else {
                    tmpString += char
                }
            }

            else -> {
                if (count != 0) tmpString += char
            }
        }
    }
    return objects
}

fun getMappedString(string: String): MutableMap<String, String> {
    val result = mutableMapOf<String, String>()
    val objects = string.filter { it != '\"' }
    val t = objects.substring(0, objects.length).split(",").map { it.trim() }
    for (o in t) {
        val pair = o.split(":")
        val key = pair[0]
        val value = pair[1].trim()
        result[key] = value
    }
    return result
}
