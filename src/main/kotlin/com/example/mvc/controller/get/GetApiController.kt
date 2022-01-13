package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import com.example.mvc.repository.MemoryRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController(private val repository: MemoryRepository) {

    @GetMapping("/hello")
    fun hello() : String {
        return "hello kotlin"
    }

    @GetMapping("/get-mapping/path-variable/{name}")
    fun pathVariable(@PathVariable name: String) : String {
        println(name)
        return name
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable2(@PathVariable name: String, @PathVariable age: Int) : String {
        println("$name, $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(@RequestParam name: String,
                   @RequestParam age: Int
    ) : String{
        return "$name, $age"
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest) : UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>) : Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number");
        println(phoneNumber)
        return map
    }

    @GetMapping("/users")
    fun getAll() {
        println(repository.store)
    }
}