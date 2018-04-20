package com.gmg.sk.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController{
    @RequestMapping("add")
   fun  add():String{
       return "hello kotlin";
   }

    fun sum(a: Int,b: Int):Int{
       return a+b;
    }



}
