package com.kgmyshin.common.di

import android.app.Application
import kotlin.reflect.KClass

abstract class ContainerApplication : Application() {
    abstract fun <T : Component> getComponent(componentClass: KClass<T>): T
}