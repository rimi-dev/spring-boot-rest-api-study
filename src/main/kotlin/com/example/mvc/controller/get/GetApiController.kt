package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*


@RestController             // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"]) // GET, http://localhost:8080/api/hello, GET http://localhost:8080/api/abcd
    fun hello(): String {
        return "hello korlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")    // GET http://localhost:8080/api/get-mapping/path-variable/rimi/27
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, ${age}")
        return "$name $age"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")    // GET http://localhost:8080/api/get-mapping/path-variable2/rimi/27
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): String {
        val name = "kotlin"
        println("${_name} , ${age}")
        return "$_name $age"
    }

    // https://localhost:8080/api/page?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param") // ?name=rimi&age=27
    fun queryParam(
            @RequestParam(name = "name") name: String,
            @RequestParam(value = "age") age: Int
    ): String{
        println("${name} , ${age}")
        return "$name $age"
    }

    // name, age, address, email
    // object로 넘길때는 변수명에 하이픈(-)이 들어갈수없음. 하이픈(-)이 들어가는 경우 RequestParam을 이용해서 해야함
    // phoneNumber -> phonenumber, phone-number
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }


    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map["phone-number"]   // or map.get("phone-number")
        return map
    }
}