package com.example.todolist_ramkumartextiles.models

data class EmployeeStatus(
    var employee: String="",
    var count: Int = 0
) {
    constructor():this("",0)
}
