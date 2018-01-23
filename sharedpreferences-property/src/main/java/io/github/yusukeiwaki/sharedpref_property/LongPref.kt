package io.github.yusukeiwaki.sharedpref_property

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class LongPref(private val sharedPreferences: SharedPreferences, private val defaultValue: Long = 0) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return sharedPreferences.getLong(property.name, defaultValue)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        sharedPreferences.edit()
                .putLong(property.name, value)
                .apply()
    }
}

