package com.toolslab.assertlibscompare

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class JunitTest {

    private val underTest = UnderTest()

    @Test
    fun equalIntegers() {
        val expected = 5

        val actual = underTest.anInteger()

        assertEquals(expected, actual)
    }

    @Test
    fun equalStrings() {
        val expected = "a string"

        val actual = underTest.aString()

        assertEquals(expected, actual)
    }

    @Test
    fun equalDataClasses() {
        val expected = DataClass("a string")

        val actual = underTest.aDataClass()

        assertEquals(expected, actual)
    }

    @Test
    fun equalClasses() {
        val expected = Class("a string")

        val actual = underTest.aClass()

        assertEquals(expected.value, actual.value)
    }

    @Test
    fun equalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("a second string")
        )

        val actual = underTest.aList()

        assertEquals(expected, actual)
    }

    @Test
    fun nullObject() {
        val actual = underTest.aNullableObject()

        assertEquals(actual, null)
    }

    @Test
    fun unequalIntegers() {
        val expected = 99

        val actual = underTest.anInteger()

        assertEquals(expected, actual)
    }

    @Test
    fun unequalStrings() {
        val expected = "another string"

        val actual = underTest.aString()

        assertEquals(expected, actual)
    }

    @Test
    fun unequalDataClasses() {
        val expected = DataClass("another string")

        val actual = underTest.aDataClass()

        assertEquals(expected, actual)
    }

    @Test
    fun unequalClasses() {
        val expected = Class("another string")

        val actual = underTest.aClass()

        assertEquals(expected.value, actual.value)
    }

    @Test
    fun unequalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("something different")
        )

        val actual = underTest.aList()

        assertEquals(expected, actual)
    }

    @Test
    fun differentSizeLists() {
        val expected = listOf(DataClass("a first string"))

        val actual = underTest.aList()

        assertEquals(expected, actual)
    }

    @Test
    fun notNullObject() {
        val actual = underTest.aNullableObject()

        assertNotEquals(null, actual)
    }

}
