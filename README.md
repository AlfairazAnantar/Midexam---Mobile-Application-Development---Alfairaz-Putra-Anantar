# Midexam---Mobile-Application-Development---Alfairaz-Putra-Anantar
An Android Student Management application built with Java and SQLite database, featuring CRUD operations, custom RecyclerView adapter, and interactive UI controls like SeekBar

# Student Management System (Android SQLite App)

A mobile application developed for an Informatics Mobile Programming assignment. This app demonstrates local data persistence using Android's native **SQLite Database** (`SQLiteOpenHelper`), multi-activity navigation, and dynamic list rendering with **RecyclerView**.

## 🚀 Features

* **Add Student (Create):** Insert new student records including Student Name, Student ID, and Age.
* **Interactive Inputs:** Uses a `SeekBar` widget to constrain age selection dynamically between 17 and 50 years old.
* **View Students (Read):** Displays the full list of enrolled students using a performance-optimized `RecyclerView`.
* **Update Records (Update):** Modify student information directly within the item list view.
* **Delete Records (Delete):** Remove existing student entries from the SQLite database.

## 🛠️ Tech Stack & Components

* **Language:** Java
* **UI Layouts:** XML (ConstraintLayout, LinearLayout, ScrollView)
* **Database:** SQLite Database (`SQLiteOpenHelper`)
* **List Component:** `RecyclerView` & Custom `RecyclerView.Adapter`
* **UI Controls:** `EditText`, `SeekBar`, `Button`, `TextView`
* **Architecture:** Multi-Activity (`MainActivity`, `ViewStudent`)

## 📁 Project Structure

```text
app/src/main/java/com/example/studentapp/
├── MainActivity.java     # Form Activity for adding new records
├── ViewStudent.java      # Activity displaying RecyclerView list
├── StudentModel.java     # Data model class for Student entity
├── StudentAdapter.java   # Custom adapter for handling list updates & deletions
└── DBHelper.java         # SQLite database management helper
