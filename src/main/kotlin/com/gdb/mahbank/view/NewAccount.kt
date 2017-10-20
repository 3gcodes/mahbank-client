package com.gdb.mahbank.view

import com.gdb.mahbank.controller.AccountController
import com.gdb.mahbank.event.AccountAddRequest
import com.gdb.mahbank.model.Account
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import tornadofx.*

class NewAccount : View("New Account") {
    val model = ViewModel()
    val name = model.bind { SimpleStringProperty() }
    val number = model.bind { SimpleStringProperty() }
    val accountController: AccountController by inject()

    override val root = form {
        fieldset(labelPosition = Orientation.VERTICAL) {
            fieldset("Name") {
                textfield(name).required()
            }
            fieldset("Number") {
                textfield(number).required()
            }
            fieldset(labelPosition = Orientation.HORIZONTAL) {
                button("Create") {
                    enableWhen(model.valid)
                    isDefaultButton = true
                    action {
                        runAsyncWithProgress {
                            val newAccount = accountController.save(Account(-1, name.value, number.value))
                            fire(AccountAddRequest(newAccount))
                        } ui {
                            name.value = ""
                            number.value = ""
                            close()
                        }
                    }
                }
                button("Close") {
                    action {
                        close()
                    }
                }
            }
        }
    }
}