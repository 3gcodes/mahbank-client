package com.gdb.mahbank.model

import javafx.beans.property.LongProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import tornadofx.ItemViewModel

class AccountViewModel : ItemViewModel<Account>() {
    val id : LongProperty = bind { SimpleLongProperty(item?.id ?: -1) }
    val name : StringProperty = bind { SimpleStringProperty( item?.name ?: "") }
    val accountNumber: StringProperty = bind { SimpleStringProperty(item?.accountNumber ?: "")}
}