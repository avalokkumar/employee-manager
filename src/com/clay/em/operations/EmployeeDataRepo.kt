package com.clay.em.operations;

import com.clay.em.model.Employee
import java.util.*

class EmployeeDataRepo {

    private var employeeDirectory = mutableListOf<Employee>()

    init {
        val employee = Employee("Clayman")
        employee.id = UUID.randomUUID()
        employee.age = 22
        employee.address = "Church Street1"

        val employee2 = Employee(name = "Venom")
        employee2.id = UUID.randomUUID()
        employee2.age = 21
        employee2.address = "Church Street2"

        val employee3 = Employee(name = "Fury")
        employee3.id = UUID.randomUUID()
        employee3.age = 23
        employee3.address = "Church Street3"

        employeeDirectory.add(employee)
        employeeDirectory.add(employee2)
        employeeDirectory.add(employee3)
    }

    fun set(employeeDir: MutableList<Employee>) {
        employeeDirectory = employeeDir
    }

    fun addEmployee(employee: Employee) : Boolean{
       return this.employeeDirectory.add(employee)
    }

    fun removeEmployee(employee: Optional<Employee>) {
        this.employeeDirectory.remove(employee.get())
    }

    fun getEmployeeById(id: UUID): Optional<Employee> {
        return this.employeeDirectory.parallelStream().filter { employee -> employee.id == id }.findAny()
    }

    fun getAllEmployee(): MutableList<Employee> {
        return this.employeeDirectory
    }

    fun isEmployeeAlreadyExist(id: UUID): Boolean {
        return this.employeeDirectory.parallelStream().anyMatch { employee -> employee.id == id }
    }
}
