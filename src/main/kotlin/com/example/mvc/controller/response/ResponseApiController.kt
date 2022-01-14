package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    @GetMapping
    fun getMapping(@RequestParam age : Int?) : ResponseEntity<String>{

        return age?.let {
            if(it < 20) {
                return ResponseEntity.badRequest().body("age must over 20")
            }
            ResponseEntity.ok("ok $age")
        }?: kotlin.run {
            return ResponseEntity.badRequest().body("no age")
        }

        /*
        if (age == null) {
            return ResponseEntity.badRequest().body("no age")
        }
        if (age < 20) {
            return ResponseEntity.badRequest().body("age must over 20")
        }
        */
        //return ResponseEntity.ok("ok $age")

    }

    // 2. post 200
    @PostMapping
    fun postMapping(@RequestBody userRequest: UserRequest?) : ResponseEntity<Any> {
        return ResponseEntity.ok(userRequest)
    }

    // 3. put 201
    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id : Int): ResponseEntity<Any> {
        return ResponseEntity.status(500).body(null)
    }
}