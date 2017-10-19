package com.gdb.mahbank

import com.gdb.mahbank.view.AccountListView
import javafx.application.Application
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import tornadofx.Stylesheet
import kotlin.reflect.KClass

@SpringBootApplication
open class MahBankApp : App(AccountListView::class, Styles::class) {

    private lateinit var context : ConfigurableApplicationContext

    override fun init() {
        super.init()
        context = SpringApplication.run(this.javaClass)
        context.autowireCapableBeanFactory.autowireBean(this)
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T = context.getBean(type.java)
        }

    }

    override fun stop() {
        super.stop()
        context.close()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(MahBankApp::class.java, *args)
        }
    }

    class Styles : Stylesheet()
}