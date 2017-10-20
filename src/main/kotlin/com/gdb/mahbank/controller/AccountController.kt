package com.gdb.mahbank.controller

import com.gdb.mahbank.model.Account
import com.gdb.mahbank.repository.AccountRepository

class AccountController : ControllerBase() {

    val accountRepository : AccountRepository by di()

    fun save(account : Account) : Account {
        return accountRepository.save(account)
    }

    fun findAll() : List<Account> {
        val accounts = accountRepository.findAll().toList()
        return accounts
    }
}