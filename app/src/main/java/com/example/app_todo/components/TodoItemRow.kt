package com.example.app_todo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.app_todo.TodoItem

@Composable
fun TodoItemRow(
    item: TodoItem,
    onCheckedChange: (Boolean) -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color(0xFF1E1E1E), shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFF00BCD4), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(item.title, color = Color.White, modifier = Modifier.weight(1f))

        Checkbox(
            checked = item.isCompleted,
            onCheckedChange = { onCheckedChange(it) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF4CAF50), // ✅ Green when checked
                uncheckedColor = Color.White
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        TextButton(onClick = onDelete) {
            Text("X", color = Color.White)
        }
    }
}
