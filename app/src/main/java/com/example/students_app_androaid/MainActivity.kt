package com.example.students_app_androaid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.students_app_androaid.ui.theme.StudentsAppAndroaidTheme
import androidx.compose.material3.*
import com.example.students_app_androaid.activity.StudentsListScreen
import com.example.students_app_androaid.activity.getSampleStudents


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lightColorScheme = lightColorScheme(
                primary = MaterialTheme.colorScheme.primary,
                secondary = MaterialTheme.colorScheme.secondary
            )
            MaterialTheme(
                colorScheme = lightColorScheme,
                content = {
                    val studentsList = getSampleStudents()
                    StudentsListScreen(students = studentsList)
                }
            )
        }
    }
}
