package com.example.toy.controller

import com.example.toy.dto.request.MemberCreateRqDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Size

@RestController
@RequestMapping("/member")
class MemberController {

    @GetMapping("/{id}")
    fun getMember(
        @PathVariable
        @Size(min = 1, max= 99, message = "1과 99사이의 갑이 들어와야함")
        id: Int): ResponseEntity<String>{
        return ResponseEntity("id : $id", HttpStatus.OK)
    }


    @PostMapping
    fun createMember(@Valid @RequestBody memberReqest: MemberCreateRqDto, bindingResult: BindingResult): ResponseEntity<String>{

        val msg = StringBuilder()
        if(bindingResult.hasErrors()){
            // 500 error
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append("${field.field} : ${message}\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity("name: ${memberReqest.name}, age: ${memberReqest.age}", HttpStatus.OK)
    }
}