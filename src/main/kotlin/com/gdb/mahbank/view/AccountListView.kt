package com.gdb.mahbank.view

import com.gdb.mahbank.controller.AccountController
import com.gdb.mahbank.event.AccountAddRequest
import com.gdb.mahbank.model.Account
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Orientation
import tornadofx.*

class AccountListView : View("Hello") {

    private val accountController: AccountController by inject()
    private var accounts : ObservableList<Account>
    private val newAccountView : NewAccount by inject()

    init {

        accounts = FXCollections.observableArrayList(
                accountController.findAll()
        )

        subscribe<AccountAddRequest> { event ->
            accounts.add(event.account)
        }
    }

    override val root = form {
        fieldset(labelPosition = Orientation.VERTICAL) {
            tableview(accounts) {
                column("ID", Account::id)
                column("Name", Account::name)
                column("Account #", Account::accountNumber)
            }
            button("New Account") {
                action {
                    newAccountView.openModal()
                }
            }
        }
    }
}
