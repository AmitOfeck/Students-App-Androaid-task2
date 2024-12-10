package com.example.students_app_androaid.repository

import com.example.students_app_androaid.model.Student

object StudentsRepository {

    private val studentsList = mutableListOf<Student>(
        Student(id = 1, name = "eran levi", isChecked = false),
        Student(id = 2, name = "dana levi", isChecked = true),
        Student(id = 3, name = "dani dean", isChecked = false),
        Student(id = 4, name = "adi barak", isChecked = false),
        Student(id = 5, name = "shai shai", isChecked = false)
    )

    fun getAllStudents(): List<Student> = studentsList

    fun addStudent(student: Student) {
        studentsList.add(student)
    }

    fun updateStudent(updatedStudent: Student) {
        val index = studentsList.indexOfFirst { it.id == updatedStudent.id }
        if (index != -1) {
            studentsList[index] = updatedStudent
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
