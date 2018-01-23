package io.github.yusukeiwaki.sharedpref_property

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class IntPref(private val sharedPreferences: SharedPreferences, private val defaultValue: Int = 0) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return sharedPreferences.getInt(property.name, defaultValue)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        sharedPreferences.edit()
                .putInt(property.name, value)
                .apply()
    }
}

