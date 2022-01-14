package com.example.mvc.repository

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Repository

@Repository
class MemoryRepository {
    var store = HashMap<Long, UserRequest>()
    var id: Long = 0

    fun save(userRequest: UserRequest): Long {
        store.put(++id, userRequest)
        return id
    }

    fun delete(id: Long) {
        store.remove(id)
    }

}