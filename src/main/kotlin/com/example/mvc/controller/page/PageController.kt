package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody


// html을 내리는 controller 정의
@Controller
class PageController {

    // http://localhost:8080/main
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    // controller에서 json body로 내리고 싶을때 ResponseBody 사용
    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "rimi"
        }
        //return "main.html"
    }
}