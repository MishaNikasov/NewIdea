package com.nikasov.common.extensions

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

const val JSON_EXTENSIONS_TAG = "JsonExtensions"

inline fun <reified T> parseJson(json: String): T? {
    return try {
        val type = object : TypeToken<T?>() {}.type
        val gson = GsonBuilder().create()
        gson.fromJson(json, type)
    } catch (e: Exception) {
        Log.e(JSON_EXTENSIONS_TAG, e.message.orEmpty())
        null
    }
}

fun Any?.toJson(): String? {
    this ?: return null
    return try {
        Gson().toJson(this)
    } catch (e: Exception) {
        Log.e(JSON_EXTENSIONS_TAG, e.message.orEmpty())
        null
    }
}

fun String?.toJsonObject(): JSONObject? {
    this ?: return null
    return try {
        JSONObject(this.toString())
    } catch (e: Exception) {
        Log.e(JSON_EXTENSIONS_TAG, e.message.orEmpty())
        null
    }
}
