package com.toolslab.assertlibscompare

import assertk.assert
import assertk.assertions.*
import org.junit.Test

class AssertkTest {

    private val underTest = UnderTest()

    @Test
    fun equalIntegers() {
        val expected = 5

        val actual = underTest.anInteger()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun integerComparison() {
        val actual = underTest.anInteger()

        assert(actual).isGreaterThan(0)
    }

    @Test
    fun equalStrings() {
        val expected = "a string"

        val actual = underTest.aString()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun equalDataClasses() {
        val expected = DataClass("a string")

        val actual = underTest.aDataClass()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun equalClasses() {
        val expected = Class("a string")

        val actual = underTest.aClass()

        assert(actual.value).isEqualTo(expected.value)
    }

    @Test
    fun equalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("a second string")
        )

        val actual = underTest.aList()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun nullObject() {
        val actual = underTest.aNullableObject()

        assert(actual).isNull()
    }

    @Test
    fun unequalIntegers() {
        val expected = 99

        val actual = underTest.anInteger()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun failingIntegerComparison() {
        val actual = underTest.anInteger()

        assert(actual).isLessThan(0)
    }

    @Test
    fun unequalStrings() {
        val expected = "another string"

        val actual = underTest.aString()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun unequalDataClasses() {
        val expected = DataClass("another string")

        val actual = underTest.aDataClass()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun unequalClasses() {
        val expected = Class("another string")

        val actual = underTest.aClass()

        assert(actual.value).isEqualTo(expected.value)
    }

    @Test
    fun unequalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("something different")
        )

        val actual = underTest.aList()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun differentSizeLists() {
        val expected = listOf(DataClass("a first string"))

        val actual = underTest.aList()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun equalListsWithDifferentOrder() {
        val expected = listOf(
            DataClass("a second string"),
            DataClass("a first string")
        )

        val actual = underTest.aList()

        assert(actual).isEqualTo(expected)
    }

    @Test
    fun notNullObject() {
        val actual = underTest.aNullableObject()

        assert(actual).isNotNull()
    }

}
