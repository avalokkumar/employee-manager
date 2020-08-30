package com.clay.em

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val  emTaskRunner = EMTaskRunner()

    do {
        println("\nEnter the command to run:\n")
        println("Press\n1> to view all employees\n2> to view employee by id\n" +
                "3> to create employee\n4> to update employee\n" +
                "5> to remove employee\n6> to exit from the menu")

        val cmd: Int = reader.nextInt()
        emTaskRunner.doOperations(cmd)

    } while (true)
}