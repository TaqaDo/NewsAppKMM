package com.example.newsappkmm.core

import com.example.newsappkmm.core.ktor.ktorModule
import com.example.newsappkmm.core.serialization.serializationModule
import org.kodein.di.DI

val coreModule = DI.Module(
    name = "CoreModule",
    init = {
        importAll(
            serializationModule,
            ktorModule
        )
    }
)