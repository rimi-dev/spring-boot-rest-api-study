package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming


data class UserResponse(
        var result: Result? = null,
        var description: String? = null,

        // @JsonProperty("user")
        var user: MutableList<UserRequest>? = null
)


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result(
        var resultCode: String? = null,
        var resultMessage: String? = null
)


/* 원하는 응답값이 아래와 같을때의 api 응답 설계
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