package com.gdb.mahbank.service

import org.springframework.stereotype.Service

@Service("someService")
class SomeService {
    fun sayHello() = println("Hello")
}