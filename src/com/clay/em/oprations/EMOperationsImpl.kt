package com.clay.em.oprations

import com.clay.em.exception.EmployeeNotFoundException
import com.clay.em.model.Employee
import java.util.*
import java.util.concurrent.atomic.AtomicInteger


class EMOperationsImpl : EMOperations {

    private var employeeDataRepo = EmployeeDataRepo()

    override fun getAllEmployee() : List<Employee> {
        return employeeDataRepo.getAllEmployee()
    }

    override fun getEmployeeById(empId: UUID) : Employee {
        val employee: Optional<Employee> = employeeDataRepo.getEmployeeById(empId)
        if (!employee.isPresent) {
            throw EmployeeNotFoundException()
        }

        return employee.get()
    }

    override fun createEmployee(employee: Employee): Employee? {
        return  if (employeeDataRepo.addEmployee(employee)) employee else null
    }

    override fun updateEmployee(employee: Employee) :Employee {
        val employeeFromOperator: Optional<Employee> = employeeDataRepo.getEmployeeById(employee.id)

        if (employeeFromOperator.isPresent) {
            val employeeValue = employeeFromOperator.get()
            employeeValue.name = employee.name
            employeeValue.age = employee.age
            employeeValue.address = employee.address
        }

        return employee
    }

    override fun deleteEmployee(empId: UUID) {
        val employee: Optional<Employee> = employeeDataRepo.getEmployeeById(empId)
        if (!employee.isPresent) {
            throw EmployeeNotFoundException()
        }
        employeeDataRepo.removeEmployee(employee)
    }

    override fun isValidEmployee(employeeId: UUID): Boolean {
        return employeeDataRepo.isEmployeeAlreadyExist(employeeId)
    }

    override fun viewAllEmployee() {
        print("Employees:\n")
        val counter =  AtomicInteger()
        for (emp in employeeDataRepo.getAllEmployee())
            println("Employee ${counter.incrementAndGet()} [ Id - ${emp.id}] | Name - ${emp.name} | Age - ${emp.age} | Address - ${emp.address}]")
    }

    override fun viewEmployeeById(id: UUID) {
        val employee = getEmployeeById(id)
        println("Employee [ Id - ${employee.id}] | Name - ${employee.name} | Age - ${employee.age} | Address - ${employee.address}]")
    }
}