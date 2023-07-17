package com.pancake.tictactoe.data.remote.utill


fun <T : Any> T.toMap(): Map<String, Any?> {
    return javaClass.declaredFields.associate { field ->
        field.isAccessible = true
        field.name to field.get(this)
    }
}