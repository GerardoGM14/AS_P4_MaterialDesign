package com.example.rockneco2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rockneco2.adapter.CourseAdapter
import com.example.rockneco2.databinding.ActivityCoursesBinding
import com.example.rockneco2.model.Course

class CoursesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoursesBinding
    private lateinit var adapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CourseAdapter(getDummyCourses())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getDummyCourses(): List<Course> {
        return listOf(
            Course("1", "Curso de Kotlin", "Aprende las bases de Kotlin"),
            Course("2", "Curso de Android", "Construye aplicaciones móviles"),
            Course("3", "Curso de Retrofit", "Conéctate a APIs en Android")
        )
    }
}
