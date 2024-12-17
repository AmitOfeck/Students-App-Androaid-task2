package com.example.students_app_androaid.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.students_app_androaid.StudentAdapter
import com.example.students_app_androaid.model.Student
import com.example.students_app_androaid.repository.StudentsRepository
import com.example.students_app_androaid.databinding.ActivityStudentsListBinding

class StudentsListActivity : ComponentActivity() {

    private lateinit var binding: ActivityStudentsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val students = StudentsRepository.getAllStudents()

        val adapter = StudentAdapter(students, { student ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("studentId", student.id)
            startActivity(intent)
        }) { student, isChecked ->
            StudentsRepository.updateStudentCheckedStatus(student.id, isChecked)
        }

        val recyclerView: RecyclerView = binding.recyclerViewStudents
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        binding.buttonAddStudent.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }
}
