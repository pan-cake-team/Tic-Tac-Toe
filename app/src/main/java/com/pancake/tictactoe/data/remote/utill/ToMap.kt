package com.pancake.tictactoe.data.remote.utill

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

fun <T : Any> toMap(obj: T): Map<String, Any?> {
    return (obj::class as KClass<T>).memberProperties.associate { prop ->
        prop.name to prop.get(obj)?.let { value ->
            if (value::class.isData) {
                toMap(value)
            } else {
                value
            }
        }
    }
}

fun <T : Any> T.toMap(): Map<String, Any?> {
    return javaClass.declaredFields.associate { field ->
        field.isAccessible = true
        field.name to field.get(this)
    }
}