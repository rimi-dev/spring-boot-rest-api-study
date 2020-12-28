package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    // GET localhost:8080/api/response?age=10
    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let {
            // age not null
            if(age < 20){
                return ResponseEntity.status(400).body("age 값은 20보다 커야합니다.")
            }

            ResponseEntity.ok("OK")
        }?: kotlin.run {
            // age is null
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        /*
        // 0. age == null -> 400 error
        if(age == null) {
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        // 1. age < 20 -> 400 error
        if(age < 20){
            return ResponseEntity.status(400).body("age 값은 20보다 커야합니다.")
        }
        println(age)
        return ResponseEntity.ok("OK")
        */
    }

    // 2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest)
    }

    // 3. put 201

    // 4. delete 500
}