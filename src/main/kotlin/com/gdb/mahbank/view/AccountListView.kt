package com.gdb.mahbank.view

import com.gdb.mahbank.controller.AccountController
import com.gdb.mahbank.service.SomeService
import javafx.geometry.Orientation
import tornadofx.*

class AccountListView : View("Hello") {

    val helloController: AccountController by inject()
    val someService : SomeService by di()

    //private val accounts = helloController.getAccounts()

    override val root = form {
        fieldset(labelPosition = Orientation.VERTICAL) {
            button("Hello") {
                action {
                    someService.sayHello()
                }
            }
        }
    }
}
