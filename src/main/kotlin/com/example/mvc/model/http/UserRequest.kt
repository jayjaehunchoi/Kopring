package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

// 전체가 snake case로 이름 변경됨
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest (
    var name:String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,

    //@JsonProperty("phone_number") 개별 변수만 json 이름 변경시켜줄때
    var phoneNumber:String?=null
)

/*
{
    "result" : {
        "result_code" : "OK",
        "result_message" : "성공"
    },
    "description" : "~",
    "user" : [
        {
            "name": "wogns",
            "age": "12",
            "email": "wogns0108@naver.com",
            "address": "address",
            "phoneNumber": "01011112222"
        },
        {
            "name": "rlagns",
            "age": "15",
            "email": "rlagns0108@naver.com",
            "address": "address",
            "phoneNumber": "01021112222"
        }
    ]
}
 */

