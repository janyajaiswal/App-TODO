package com.example.app_todo

data class TodoItem(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)
