package com.example.students_app_androaid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.example.students_app_androaid.ui.theme.StudentsAppAndroaidTheme
import com.example.students_app_androaid.activity.StudentsListScreen
import com.example.students_app_androaid.repository.StudentsRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentsAppAndroaidTheme {
                StudentsListScreen(students = StudentsRepository.getAllStudents())
            }
        }
    }
}
