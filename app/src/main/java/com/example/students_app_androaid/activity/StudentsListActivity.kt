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
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.students_app_androaid.R



@Composable
fun StudentsListScreen(students: List<Student>) {
    // using state to save students
    val studentsState = remember { mutableStateOf(students.toMutableList()) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Students List",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(studentsState.value.size) { index ->
                    StudentItem(student = studentsState.value[index]) { checked ->
                        // update students after click
                        val updatedStudent = studentsState.value[index].copy(isChecked = checked)
                        StudentsRepository.updateStudent(updatedStudent)

                        // update students list after change
                        val updatedStudents = studentsState.value.toMutableList()
                        updatedStudents[index] = updatedStudent
                        studentsState.value = updatedStudents
                    }
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

        Image(
            painter = painterResource(id = R.drawable.ic_student_pic),
            contentDescription = "Student Pic",
            modifier = Modifier.size(50.dp)
        )

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
