package com.eduramza.meep

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MeepApplication

fun main(args: Array<String>) {
	runApplication<MeepApplication>(*args)
}
