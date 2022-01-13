package com.example.mvc.controller.delete

import com.example.mvc.repository.MemoryRepository
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DeleteApiController(private val repository: MemoryRepository) {

    @DeleteMapping("/users/{id}")
    fun delete(@PathVariable id: Long) {
        repository.delete(id)
        println("delete success")
    }
}