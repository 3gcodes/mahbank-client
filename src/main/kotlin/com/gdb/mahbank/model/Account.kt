package com.gdb.mahbank.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Account(
        @Id @GeneratedValue val id : Long = -1,
        val name : String = "",
        val accountNumber : String = ""
)