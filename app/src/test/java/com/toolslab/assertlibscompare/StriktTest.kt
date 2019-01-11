package com.toolslab.assertlibscompare

import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNotNull
import strikt.assertions.isSameInstanceAs

class StriktTest {

    private val underTest = UnderTest()

    @Test
    fun equalIntegers() {
        val expected = 5

        val actual = underTest.anInteger()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun equalStrings() {
        val expected = "a string"

        val actual = underTest.aString()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun equalDataClasses() {
        val expected = DataClass("a string")

        val actual = underTest.aDataClass()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun equalClasses() {
        val actual = underTest.aClass()

        expectThat(actual).isSameInstanceAs(actual)
    }

    @Test
    fun equalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("a second string")
        )

        val actual = underTest.aList()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun nullObject() {
        val actual = underTest.aNullableObject()

        expectThat(actual).isEqualTo(null)
    }

    @Test
    fun unequalIntegers() {
        val expected = 99

        val actual = underTest.anInteger()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun unequalStrings() {
        val expected = "another string"

        val actual = underTest.aString()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun unequalDataClasses() {
        val expected = DataClass("another string")

        val actual = underTest.aDataClass()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun unequalClasses() {
        val expected = Class("another string")

        val actual = underTest.aClass()

        expectThat(actual.value).isEqualTo(expected.value)
        expectThat(actual).isSameInstanceAs(actual)
    }

    @Test
    fun unequalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("something different")
        )

        val actual = underTest.aList()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun differentSizeLists() {
        val expected = listOf(DataClass("a first string"))

        val actual = underTest.aList()

        expectThat(actual).isEqualTo(expected)
    }

    @Test
    fun notNullObject() {
        val actual = underTest.aNullableObject()

        expectThat(actual).isNotNull()
    }

}
