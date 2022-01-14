package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.*

// 전체가 snake case로 이름 변경됨
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest (
    @field:Size(min = 2, max = 8)
    @field:NotEmpty
    var name:String?=null,

    @field:PositiveOrZero
    var age:Int?=null,

    @field:Email
    var email:String?=null,

    @field:NotBlank
    var address:String?=null,

    //@JsonProperty("phone_number") 개별 변수만 json 이름 변경시켜줄때
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
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

