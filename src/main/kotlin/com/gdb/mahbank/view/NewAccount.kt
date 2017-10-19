package com.gdb.mahbank.view

import com.gdb.mahbank.controller.AccountController
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
                            val newAccount = accountController.saveAccount(name.value, number.value)
                        } ui {
                            replaceWith(AccountListView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.RIGHT))

                        }
                    }
                }
                button("Cancel") {
                    action {
                        replaceWith(AccountListView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.RIGHT))
                    }
                }
            }
        }
    }
}