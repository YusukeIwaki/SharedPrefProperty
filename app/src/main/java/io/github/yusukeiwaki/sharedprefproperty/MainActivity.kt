package io.github.yusukeiwaki.sharedprefproperty

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import io.github.yusukeiwaki.sharedpref_property.IntPref
import io.github.yusukeiwaki.sharedpref_property.LongPref
import io.github.yusukeiwaki.sharedpref_property.StringPref

class MainActivity : Activity() {
    private val editorInt by lazy<TextView> { findViewById(R.id.editor_int_field) }
    private val editorLong by lazy<TextView> { findViewById(R.id.editor_long_field) }
    private val editorString by lazy<TextView> { findViewById(R.id.editor_string_field) }
    private val buttonLoad by lazy<View> { findViewById(R.id.btn_load) }
    private val buttonSave by lazy<View> { findViewById(R.id.btn_save) }

    /**
     * A helper class for accessing SharedPreferences.
     */
    inner class Cache(val context: Context) {
        val sharedPreferences = context.getSharedPreferences("cache", Context.MODE_PRIVATE)

        var intField by IntPref(sharedPreferences)
        var longField by LongPref(sharedPreferences, defaultValue = 123)
        var stringField by StringPref(sharedPreferences, defaultValue = "hoge")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLoad.setOnClickListener { _ ->
            load()
        }
        buttonSave.setOnClickListener { _ ->
            save()
        }
    }

    private fun load() {
        val cache = Cache(this)
        editorInt.text = cache.intField.toString()
        editorLong.text = cache.longField.toString()
        editorString.text = cache.stringField
    }

    private fun save() {
        val cache = Cache(this)
        cache.intField = editorInt.text.toString().toInt()
        cache.longField = editorLong.text.toString().toLong()
        cache.stringField = editorString.text.toString()
    }
}
