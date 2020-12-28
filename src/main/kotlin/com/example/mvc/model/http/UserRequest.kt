package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest(
        var name: String? = null,
        var age: Int? = null,
        var email: String? = null,
        var address: String? = null,
        var phoneNumber: String? = null,   // phone_number
)

/*
{
    "result": {
        "result_code": "OK",
        "result_message": "성공",
    },
    "description": "~~~~~~",
    "user": [
        {
            "name": "rimi",
            "age": "18",
            "email": "",
            "phoneNumber": ""
        },
        {
            "name": "dd",
            "age": "11",
            "email": "",
            "phoneNumber": ""
        },
        {
            "name": "aa",
            "age": "23",
            "email": "",
            "phoneNumber": ""
        },
    ]
}
*/