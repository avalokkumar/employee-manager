package com.clay.em.exception

import java.lang.Exception

class EmployeeAlreadyExistException : Exception() {

    override val message: String?
        get() = super.message
}