package com.eduramza.meep.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_products")
class Product(
        val name: String,
        val description: String,
        val active: Boolean,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val product_id: Long = -1
): Serializable {

    private constructor(): this(name = "", description = "", active = false)

    companion object{
        private const val serialVersionUID = 1L
    }
}