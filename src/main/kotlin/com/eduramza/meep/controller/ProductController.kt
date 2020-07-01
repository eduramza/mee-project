package com.eduramza.meep.controller

import com.eduramza.meep.model.Product
import com.eduramza.meep.repository.ProductRepository
import com.eduramza.meep.utilities.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

const val PRODUCT_ROUTE = "/products"
const val BRAND_ROUTE = "/brands"

@RestController
@RequestMapping("/api/v1")
class ProductController {

    @Autowired
    lateinit var repository: ProductRepository

    @GetMapping(PRODUCT_ROUTE)
    @ResponseBody
    fun listAllProducts() = repository.findAll()

    @GetMapping("$PRODUCT_ROUTE/{id}")
    fun getItemById(@PathVariable id: Long) =
            repository.findById(id)
                .orElseThrow { ResourceNotFoundException("Product not found for this id = $id") }

    @PostMapping(PRODUCT_ROUTE)
    @ResponseStatus(HttpStatus.CREATED)
    fun createAnItem(@RequestBody(required = true) product: Product) = repository.save(product)

    @DeleteMapping(PRODUCT_ROUTE)
    fun deleteProduct(@RequestBody(required = true) product: Product) = repository.delete(product)

    @PutMapping(PRODUCT_ROUTE)
    fun updateProduct(@RequestBody(required = true) product: Product) = repository.save(product)

}