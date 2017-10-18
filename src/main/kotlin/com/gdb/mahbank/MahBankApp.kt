package com.gdb.mahbank

import com.gdb.mahbank.view.AccountListView
import tornadofx.App
import tornadofx.Stylesheet

class MahBankApp : App(AccountListView::class, Styles::class) {
    class Styles : Stylesheet()
}