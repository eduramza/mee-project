package com.eduramza.meep.controller

import com.eduramza.meep.model.Customer
import com.eduramza.meep.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1")
class WebController {
    @Autowired
    lateinit var repository: CustomerRepository

    @GetMapping("/customers")
    fun findAll() = repository.findAll()

    @GetMapping("/customers/{id}")
    fun findById(@PathVariable id : Long) = repository.findById(id)

    @PostMapping("/customers/save")
    fun saveCustomers(): String{
        repository.save(Customer("Jack", "Smith"))
        repository.save(Customer("Adam", "Johnson"))
        repository.save(Customer("Kim", "Smith"))
        repository.save(Customer("David", "Williams"))
        repository.save(Customer("Peter", "Davis"))

        return "Done"
    }
}