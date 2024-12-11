package com.example.students_app_androaid.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.students_app_androaid.model.Student
import com.example.students_app_androaid.repository.StudentsRepository
import com.example.students_app_androaid.ui.theme.StudentsAppAndroaidTheme


class StudentDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val studentId = intent.getIntExtra("studentId", -1)
        val student = StudentsRepository.getStudentById(studentId)

        setContent {
            StudentsAppAndroaidTheme {
                if (student != null) {
                    StudentDetailsScreen(student = student)
                } else {
                    Text(text = "Student not found", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

@Composable
fun StudentDetailsScreen(student: Student) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Student Details", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = com.example.students_app_androaid.R.drawable.ic_student_pic),
                contentDescription = "Student Image",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Name: ${student.name}")
            Text(text = "Phone: ${student.phone}")
            Text(text = "Address: ${student.address}")
            Text(text = "ID: ${student.id}")

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Arrived: ")
                Checkbox(
                    checked = student.isChecked,
                    onCheckedChange = { /* אפשר להוסיף פעולה לשינוי ה-Checkbox אם צריך */ }
                )
            }
        }
    }
}
