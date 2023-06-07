package com.mongodb.starter

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document("restaurants")
data class Restaurant(
    @Id
    val id: ObjectId = ObjectId(),
    val name: String = "",
    @Field("restaurant_id")
    val restaurantId: String = ""
)

