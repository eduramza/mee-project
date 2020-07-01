package com.eduramza.meep.utilities

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(message: String?) : Exception(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}