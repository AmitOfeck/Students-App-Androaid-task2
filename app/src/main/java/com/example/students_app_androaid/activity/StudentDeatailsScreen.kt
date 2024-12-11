package com.example.students_app_androaid.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.students_app_androaid.ui.theme.StudentsAppAndroaidTheme

class StudentDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val studentId = intent.getStringExtra("studentId")

        setContent {
            StudentsAppAndroaidTheme {
                Text("Details for Student ID: $studentId")//
            }
        }
    }
}
