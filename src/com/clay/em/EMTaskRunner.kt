package com.clay.em

import com.clay.em.exception.EmployeeNotFoundException
import com.clay.em.model.Employee
import com.clay.em.oprations.EMOperationsImpl
import java.util.*
import kotlin.system.exitProcess

class EMTaskRunner {

    val reader = Scanner(System.`in`)
    val operations = EMOperationsImpl()

    fun doOperations(cmd: Int) {

        when (cmd) {
            1 -> {
                operations.viewAllEmployee()
            }
            2 -> {
                println("Enter the employee id")
                val employeeId = reader.nextLine();
                operations.viewEmployeeById(UUID.fromString(employeeId))
            }
            3 -> {
                val employee: Employee = inputEmployee()
                operations.createEmployee(employee)
            }
            4 -> {
                val employee: Employee = inputEmployeeForUpdate()
                operations.updateEmployee(employee)
            }
            5 -> {
                println("Enter an employee id to delete")
                val id = reader.nextLine()
                operations.deleteEmployee(UUID.fromString(id))
                println("Employee with id $id successfully deleted")
            }

            6 -> exitProcess(0)
        }
    }

    private fun inputEmployeeForUpdate(): Employee {

        println("Enter Employee id to update")
        val employeeId = reader.nextLine();
        if (!operations.isValidEmployee(UUID.fromString(employeeId))) {
            throw EmployeeNotFoundException();
        }
        val employee: Employee = operations.getEmployeeById(UUID.fromString(employeeId))
        loop@ do {
            println("Choose option to update")
            println("\n1> Name\n2> Age\n3> Address\n4> Go back")
            when (reader.nextInt()) {
                1 -> {
                    println("Enter name")
                    val newName = reader.nextLine()
                    employee.name = newName
                }
                2 -> {
                    println("Enter age")
                    val newAge = reader.nextLine()
                    employee.age = newAge.toInt()
                }
                3 -> {
                    println("Enter address")
                    val newAddress = reader.nextLine()
                    employee.address = newAddress
                }
                4 -> {
                    break@loop
                }
            }
        } while (true)

        return employee
    }

    private fun inputEmployee(): Employee {
        println("Enter employee details")
        println("Enter Name")
        val employee = Employee(reader.nextLine())
        employee.id = UUID.randomUUID()
        println("Enter Age")
        employee.age = reader.nextLine().toInt()
        println("Enter Address")
        employee.address = reader.nextLine()

        return employee
    }
}