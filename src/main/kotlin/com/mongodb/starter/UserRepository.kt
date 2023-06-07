package com.mongodb.starter

import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {

    fun findByUserId(userId: String): User?
}