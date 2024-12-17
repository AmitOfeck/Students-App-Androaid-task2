package com.example.students_app_androaid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.students_app_androaid.activity.StudentsListActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, StudentsListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
