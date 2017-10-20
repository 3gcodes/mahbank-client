package com.gdb.mahbank.event

import com.gdb.mahbank.model.Account
import tornadofx.FXEvent

class AccountAddRequest(val account : Account) : FXEvent()