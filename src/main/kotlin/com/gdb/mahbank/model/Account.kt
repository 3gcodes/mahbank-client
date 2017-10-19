package com.gdb.mahbank.model

import tornadofx.*
import javax.json.JsonObject

class Account: JsonModel {
    var id by property<Long>()
    fun idProperty() = getProperty(Account::id)

    var name by property<String>()
    fun nameProperty() = getProperty(Account::name)

    var accountNumber by property<String>()
    fun accountNumberProperty() = getProperty(Account::accountNumber)

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = long("id")
            name = string("name")
            accountNumber = string("accountNumber")
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("name", name)
            add("accountNumber", accountNumber)
        }
    }
}