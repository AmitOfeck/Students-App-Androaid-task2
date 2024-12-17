package com.example.students_app_androaid.repository

import com.example.students_app_androaid.model.Student

object StudentsRepository {

    private val studentsList = mutableListOf<Student>(
        Student(id = 1, name = "eran levi", isChecked = false, phone = "050-1234567", address = "Tel Aviv"),
        Student(id = 2, name = "dana levi", isChecked = true, phone = "052-2345678", address = "Haifa"),
        Student(id = 3, name = "dani dean", isChecked = false, phone = "053-3456789", address = "Jerusalem"),
        Student(id = 4, name = "adi barak", isChecked = false, phone = "054-4567890", address = "Eilat"),
        Student(id = 5, name = "shai shai", isChecked = false, phone = "055-5678901", address = "Beer Sheva")
    )

    fun getAllStudents(): List<Student> = studentsList

    fun addStudent(student: Student) {
        studentsList.add(student)
    }

    fun updateStudent(updatedStudent: Student) {
        val existingIndex = studentsList.indexOfFirst { it.id == updatedStudent.id }

        if (existingIndex != -1) {
            studentsList[existingIndex] = updatedStudent
        } else {
            val oldIndex = studentsList.indexOfFirst { it.name == updatedStudent.name && it.id != updatedStudent.id }
            if (oldIndex != -1) {
                studentsList.removeAt(oldIndex)
            }
            studentsList.add(updatedStudent)
        }
    }

    fun deleteStudent(studentId: Int) {
        studentsList.removeIf { it.id == studentId }
    }

    fun getStudentById(studentId: Int): Student? {
        return studentsList.find { it.id == studentId }
    }

    fun updateStudentCheckedStatus(studentId: Int, isChecked: Boolean) {
        val student = getStudentById(studentId)
        if (student != null) {
            student.isChecked = isChecked
        }
    }
}
