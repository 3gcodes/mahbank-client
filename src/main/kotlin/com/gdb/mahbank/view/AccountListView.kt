package com.gdb.mahbank.view

import com.gdb.mahbank.controller.AccountController
import com.gdb.mahbank.model.Account
import javafx.geometry.Orientation
import tornadofx.*

class AccountListView : View("Hello") {

    val helloController: AccountController by inject()

    private val accounts = helloController.getAccounts()

    override val root = form {
        fieldset(labelPosition = Orientation.VERTICAL) {
            tableview(accounts) {
                column("ID", Account::id)
                column("Name", Account::name)
                column("Account #", Account::accountNumber)
            }
        }
    }
}
