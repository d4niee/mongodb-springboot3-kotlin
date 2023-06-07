package com.mongodb.starter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(@Autowired val userRepository: UserRepository) {


    @GetMapping
    fun getCount(): Int {
        return userRepository.findAll().count()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: String): ResponseEntity<User> {
        val user = userRepository.findByUserId(id)
        return if (user != null) ResponseEntity.ok(user) else ResponseEntity
            .notFound().build()
    }

    @PostMapping
    fun postUser(): User {
        val user = User().copy(name = "max", userId = UUID.randomUUID().toString())
        return userRepository.insert(user)
    }
}
