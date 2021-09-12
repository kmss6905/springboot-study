package com.example.toy.dto.request

import org.hibernate.type.IntegerType
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class MemberCreateRqDto(

    @field:NotEmpty(message = "이름은 비어있으면 안됩니다.")
    var name: String? = null,


    var age: Int? = null
)