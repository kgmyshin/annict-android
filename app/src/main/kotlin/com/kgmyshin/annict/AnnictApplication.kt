package com.kgmyshin.annict

import com.kgmyshin.auth.AuthComponent
import com.kgmyshin.auth.AuthModule
import com.kgmyshin.auth.DaggerAuthComponent
import com.kgmyshin.common.di.Component
import com.kgmyshin.common.di.ContainerApplication
import java.util.*
import kotlin.reflect.KClass

class AnnictApplication : ContainerApplication() {

    private val componentMap = HashMap<KClass<*>, Component>()

    override fun onCreate() {
        super.onCreate()
        componentMap.put(
                AuthComponent::class,
                DaggerAuthComponent.builder()
                        .authModule(AuthModule(this))
                        .build()
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Component> getComponent(componentClass: KClass<T>): T = componentMap[componentClass] as T
}