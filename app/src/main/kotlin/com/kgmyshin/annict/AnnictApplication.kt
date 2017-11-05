package com.kgmyshin.annict

import com.kgmyshin.auth.AuthComponent
import com.kgmyshin.auth.AuthModule
import com.kgmyshin.auth.DaggerAuthComponent
import com.kgmyshin.auth.hostService.AuthHostServiceModule
import com.kgmyshin.common.di.Component
import com.kgmyshin.common.di.ContainerApplication
import com.kgmyshin.workDictionary.DaggerWorkDictionaryComponent
import com.kgmyshin.workDictionary.WorkDictionaryComponent
import com.kgmyshin.workDictionary.WorkDictionaryModule
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
        componentMap.put(
                WorkDictionaryComponent::class,
                DaggerWorkDictionaryComponent.builder()
                        .authHostServiceModule(AuthHostServiceModule(this))
                        .workDictionaryModule(WorkDictionaryModule(this))
                        .build()
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Component> getComponent(componentClass: KClass<T>): T = componentMap[componentClass] as T
}