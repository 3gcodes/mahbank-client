package com.gdb.mahbank.controller

import tornadofx.Controller
import tornadofx.Rest

open class ControllerBase : Controller() {

    val api: Rest by inject()

    init {
        api.baseURI = "http://localhost:8080/"
    }
}