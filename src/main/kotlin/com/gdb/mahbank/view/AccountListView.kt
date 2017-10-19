package com.gdb.mahbank.view

import com.gdb.mahbank.controller.AccountController
import com.gdb.mahbank.model.Account
import com.gdb.mahbank.service.SomeService
import javafx.geometry.Orientation
import tornadofx.*

class AccountListView : View("Hello") {

    val accountController: AccountController by inject()
    val someService : SomeService by di()

    private var accounts = accountController.getAccounts()

    override val root = form {
        fieldset(labelPosition = Orientation.VERTICAL) {
            tableview(accounts) {
                column("ID", Account::id)
                column("Name", Account::name)
                column("Account #", Account::accountNumber)
            }
            button("New Account") {
                action {
                    replaceWith(NewAccount::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
                }
            }
            button("Refresh") {
                action {
                    runAsyncWithProgress {
                        accounts.asyncItems { accountController.getAccounts() }
                    }
                }
            }
        }
    }
}
