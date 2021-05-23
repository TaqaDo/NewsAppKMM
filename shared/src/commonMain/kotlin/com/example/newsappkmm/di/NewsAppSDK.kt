package com.example.newsappkmm.di

import org.kodein.di.*
import kotlin.native.concurrent.ThreadLocal


@ThreadLocal
object NewsAppSDK {

    internal val di: DirectDI
        get() = requireNotNull(_di)
    private var _di: DirectDI? = null


    fun init(configuration: Configuration) {
        val configurationModule = DI.Module(
            name = "configurationModule",
            init = {
                bind<Configuration>() with singleton { configuration }
            }
        )

        if (_di != null) {
            _di = null
        }

        val direct = DI {
            importAll(
                configurationModule
            )
        }.direct

        _di = direct
    }
}