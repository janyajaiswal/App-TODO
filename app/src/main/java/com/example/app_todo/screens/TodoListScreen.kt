package com.example.app_todo.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.app_todo.TodoItem
import com.example.app_todo.components.TodoItemRow

@Composable
fun TodoListScreen() {
    val context = LocalContext.current

    // ✅ Avoid crash – use String instead of TextFieldValue
    var textState by rememberSaveable { mutableStateOf("") }

    // ✅ In-memory state that survives recomposition
    val todoItems = remember { mutableStateListOf<TodoItem>() }

    // ✅ Derived lists
    val activeItems = todoItems.filter { !it.isCompleted }
    val completedItems = todoItems.filter { it.isCompleted }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 🔹 App Title
        Text(
            text = "TODO List",
            color = Color(0xFF9F2B68),
                    style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🔹 Input Row
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Enter the task name") },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF2C2C2C),
                    unfocusedContainerColor = Color(0xFF2C2C2C),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.Cyan,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    val trimmed = textState.trim()
                    if (trimmed.isEmpty()) {
                        Toast.makeText(context, "Enter a valid task!", Toast.LENGTH_SHORT).show()
                    } else {
                        todoItems.add(TodoItem(todoItems.size, trimmed))
                        textState = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9FA8DA))
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 ACTIVE ITEMS SECTION
        if (activeItems.isNotEmpty()) {
            Text(
                text = "Active Items",
                color = Color(0xFF80CBC4), // teal-like color
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))

            LazyColumn {
                items(activeItems) { item ->
                    TodoItemRow(
                        item = item,
                        onCheckedChange = { checked ->
                            val idx = todoItems.indexOf(item)
                            if (idx != -1) todoItems[idx] = item.copy(isCompleted = checked)
                        },
                        onDelete = { todoItems.remove(item) }
                    )
                }
            }
        } else {
            Text("No active items yet", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 COMPLETED ITEMS SECTION
        if (completedItems.isNotEmpty()) {
            Text(
                text = "Completed Items",
                color = Color(0xFF81D4FA), // light blue
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))

            LazyColumn {
                items(completedItems) { item ->
                    TodoItemRow(
                        item = item,
                        onCheckedChange = { checked ->
                            val idx = todoItems.indexOf(item)
                            if (idx != -1) todoItems[idx] = item.copy(isCompleted = checked)
                        },
                        onDelete = { todoItems.remove(item) }
                    )
                }
            }
        } else {
            Text("No completed items yet", color = Color.Gray)
        }
    }
}
