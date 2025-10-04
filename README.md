# App-TODO
CPSC 411A Project-1

This is a simple **To-Do List App** built using **Kotlin** and **Jetpack Compose**.  
It lets users add, complete, and delete tasks with an easy-to-use interface.  
The app uses modern Compose concepts like **state management**, **data classes**, and **state hoisting**.

---- App Overview ----

- ➕ Add new tasks  
- ✅ Check tasks to mark them as complete (checkbox turns green)  
- 🔄 Move tasks between **Active** and **Completed** sections  
- ❌ Delete tasks from either list  
- 💾 Keeps data during screen rotation using `rememberSaveable`

---- Features ----

- **Add Item** – Type a task and press “Add”
- **Validation** – Empty input shows a Toast message
- **Active Section** – Displays uncompleted tasks
- **Completed Section** – Displays completed tasks
- **Check/Uncheck** – Automatically moves between Active and Completed
- **Delete Task** – Removes the task permanently
- **Rotation Safe** – Uses `rememberSaveable` to preserve data during rotation

---- Key Concepts Used ----

1. Data Class  
Represents a single to-do item.

2. State & MutableState

All task and text input data are managed using Compose’s reactive state system.

3. remember & rememberSaveable

Used to keep data consistent across recompositions and configuration changes.

4. State Hoisting

Child composables (TodoItemRow) only show UI —
actual state (list of tasks) is managed in the parent (TodoListScreen).

---- File Descriptions ----

•	Mainactivity.kt

Entry point of the app.

Sets up the Compose theme and loads the main screen (TodoListScreen).

•	TodoListScreen.kt

Main UI screen.

Handles adding, displaying, and managing the list of active and completed tasks.

Uses remember and rememberSaveable to preserve state.

•	TodoItemRow.kt

UI component for displaying each task.

Contains a checkbox (to mark complete/incomplete) and delete button.

Uses color change when a task is completed.

•	TodoItem.kt

Simple data class that defines what a task looks like (id, title, completion state).

•	ui/theme folder

Handles app colors, shapes, and typography.
Ensures a consistent visual style across the app.

----Screenshots ----

<img width="432" height="826" alt="Screenshot 2025-10-04 at 3 53 00 PM" src="https://github.com/user-attachments/assets/087c53b0-80b8-457c-b162-9bc503082e27" />

Author:
Janya Jaiswal

