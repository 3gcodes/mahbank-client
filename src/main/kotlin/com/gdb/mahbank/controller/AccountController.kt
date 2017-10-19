package com.gdb.mahbank.controller

import com.gdb.mahbank.model.Account
import tornadofx.toModel

class AccountController : ControllerBase() {

    fun getAccounts()  = api.get("account").list().toModel<Account>()

    fun saveAccount(name: String, number: String) : Account {
        var account = Account()
        account.name = name
        account.accountNumber = number

        return api.post("account", account).one().toModel<Account>()
    }
}