package com.clay.em.oprations

import com.clay.em.model.Employee
import java.util.*

interface EMOperations {

    fun getAllEmployee() : List<Employee>

    fun getEmployeeById(employeeId: UUID) : Employee

    fun createEmployee(employee: Employee) : Employee?

    fun updateEmployee(employee: Employee) : Employee

    fun deleteEmployee(employeeId: UUID)

    fun isValidEmployee(employeeId: UUID): Boolean

    fun viewAllEmployee()

    fun viewEmployeeById(id: UUID)
}