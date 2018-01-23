# sharedpreferences-property

うっっっっすーーーーーーいSharedPreferencesのラッパー

## Example

### definition

```kotlin
class HogeCache(private val context: Context) {
  private val sharedPreferences
    get() = context.getSharedPreferences("hoge", Context.MODE_PRIVATE)

  var token by StringPref(sharedPreferences)
  var displayName by StringPref(sharedPreferences, defaultValue = "John Doe")
  var lastUpdatedAt by LongPref(sharedPreferences)
}
```

### usage

```kotlin
fun updateDisplayName(name: String) {
  val cache = HogeCache(context)
  cache.displayName = name
}

fun load() {
  val cache = HogeCache(context)
  showInfo(cache.token, cache.displayName, cache.lastUpdatedAt)
}
```

## Setup

```groovy
repositories {
  maven { url "https://dl.bintray.com/yusukeiwaki/maven" }
}

dependencies {
  implementation 'io.github.yusukeiwaki.utility.sharedpreferences-property:0.0.1'
}
```
