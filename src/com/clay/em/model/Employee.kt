package com.clay.em.model

import java.util.*

open class Employee(var name: String) {

    lateinit var id : UUID
    var age: Int = 0
    lateinit var address: String
}