package com.gdb.mahbank.controller

import com.gdb.mahbank.model.Account
import tornadofx.toModel

class AccountController : ControllerBase() {

    fun getAccounts()  = api.get("account").list().toModel<Account>()
}