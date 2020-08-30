package com.clay.em.exception

import java.lang.Exception

class EmployeeNotFoundException : Exception() {

    override val message: String?
        get() = super.message
}
