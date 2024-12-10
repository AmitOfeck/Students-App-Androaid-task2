package com.example.students_app_androaid.activity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.students_app_androaid.model.Student
import com.example.students_app_androaid.repository.StudentsRepository
import com.example.students_app_androaid.ui.theme.StudentsAppAndroaidTheme
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun StudentsListScreen(students: List<Student>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Students List",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(students.size) { index ->
                StudentItem(student = students[index]) { checked ->
                    StudentsRepository.updateStudentCheckedStatus(students[index].id, checked)
                }
            }
        }
    }
}

@Composable
fun StudentItem(student: Student, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Name: ${student.name}")
            Text(text = "ID: ${student.id}")
        }

        Checkbox(
            checked = student.isChecked,
            onCheckedChange = { checked ->
                onCheckedChange(checked)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStudentsListScreen() {
    StudentsAppAndroaidTheme {
        StudentsListScreen(students = StudentsRepository.getAllStudents())
    }
}
