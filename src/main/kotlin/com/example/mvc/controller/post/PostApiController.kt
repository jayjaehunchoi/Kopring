package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import com.example.mvc.repository.MemoryRepository
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController(private val repository: MemoryRepository) {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest) : UserRequest {
        println(userRequest)
        return userRequest
    }

    @PostMapping("/users")
    fun save(@RequestBody userRequest: UserRequest) : Long {
        println(userRequest)
        return repository.save(userRequest)
    }

}