package com.joyner.googlesignincomposelibrary.models.properties

import androidx.annotation.StringRes

sealed class GoogleText {
    data class Resource(@field:StringRes val id: Int) : GoogleText()
    data class Value(val text: String) : GoogleText()
}
