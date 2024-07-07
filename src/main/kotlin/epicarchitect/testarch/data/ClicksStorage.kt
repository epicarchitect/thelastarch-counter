package epicarchitect.testarch.data

import android.content.Context
import androidx.core.content.edit

class ClicksStorage(context: Context) {
    private val preferences = context.getSharedPreferences(
        "ClicksStorage",
        Context.MODE_PRIVATE
    )

    var clickCount
        set(value) = preferences.edit { putInt("clickCount", value) }
        get() = preferences.getInt("clickCount", 0)

    var clickIncreaseValue
        set(value) = preferences.edit { putInt("clickIncreaseValue", value) }
        get() = preferences.getInt("clickIncreaseValue", 1)

}