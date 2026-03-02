package com.joyner.googlesignincomposelibrary.properties

import com.joyner.googlesignincomposelibrary.models.properties.CommonButtonProperties
import com.joyner.googlesignincomposelibrary.models.properties.FabExtendedButtonProperties
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ButtonPropertiesDefaultsTest {

    // region CommonButtonProperties

    @Test
    fun commonButtonProperties_defaultIconSize_is18() {
        assertEquals(18, CommonButtonProperties().googleIconSize)
    }

    @Test
    fun commonButtonProperties_defaultTextSize_is14() {
        assertEquals(14, CommonButtonProperties().googleButtonTextSize)
    }

    @Test
    fun commonButtonProperties_defaultSpacing_is8() {
        assertEquals(8, CommonButtonProperties().spaceBetweenIconAndText)
    }

    @Test
    fun commonButtonProperties_twoDefaultInstances_areEqual() {
        assertEquals(CommonButtonProperties(), CommonButtonProperties())
    }

    @Test
    fun commonButtonProperties_copy_updatesOnlySpecifiedField() {
        val original = CommonButtonProperties()
        val modified = original.copy(googleIconSize = 24)

        assertEquals(24, modified.googleIconSize)
        assertEquals(original.googleButtonTextSize, modified.googleButtonTextSize)
        assertEquals(original.spaceBetweenIconAndText, modified.spaceBetweenIconAndText)
    }

    @Test
    fun commonButtonProperties_differentIconSize_areNotEqual() {
        val a = CommonButtonProperties(googleIconSize = 18)
        val b = CommonButtonProperties(googleIconSize = 24)

        assertNotEquals(a, b)
    }

    // endregion

    // region FabExtendedButtonProperties

    @Test
    fun fabExtendedButtonProperties_defaultTextSize_is14() {
        assertEquals(14, FabExtendedButtonProperties().googleButtonTextSize)
    }

    @Test
    fun fabExtendedButtonProperties_twoDefaultInstances_areEqual() {
        assertEquals(FabExtendedButtonProperties(), FabExtendedButtonProperties())
    }

    @Test
    fun fabExtendedButtonProperties_copy_updatesOnlySpecifiedField() {
        val original = FabExtendedButtonProperties()
        val modified = original.copy(googleButtonTextSize = 16)

        assertEquals(16, modified.googleButtonTextSize)
        assertEquals(original.googleIconColor, modified.googleIconColor)
    }

    // endregion
}
