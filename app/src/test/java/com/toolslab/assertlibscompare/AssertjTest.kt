package com.toolslab.assertlibscompare

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AssertjTest {

    private val underTest = UnderTest()

    @Test
    fun equalIntegers() {
        val expected = 5

        val actual = underTest.anInteger()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun integerComparison() {
        val actual = underTest.anInteger()

        assertThat(actual).isGreaterThan(0)
    }

    @Test
    fun equalStrings() {
        val expected = "a string"

        val actual = underTest.aString()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun equalDataClasses() {
        val expected = DataClass("a string")

        val actual = underTest.aDataClass()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun equalClasses() {
        val actual = underTest.aClass()

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(actual)
    }

    @Test
    fun equalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("a second string")
        )

        val actual = underTest.aList()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun nullObject() {
        val actual = underTest.aNullableObject()

        assertThat(actual).isNull()
    }

    @Test
    fun unequalIntegers() {
        val expected = 99

        val actual = underTest.anInteger()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun failingIntegerComparison() {
        val actual = underTest.anInteger()

        assertThat(actual).isLessThan(0)
    }

    @Test
    fun unequalStrings() {
        val expected = "another string"

        val actual = underTest.aString()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun unequalDataClasses() {
        val expected = DataClass("another string")

        val actual = underTest.aDataClass()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun unequalClasses() {
        val expected = Class("another string")

        val actual = underTest.aClass()

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected)
    }

    @Test
    fun unequalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("something different")
        )

        val actual = underTest.aList()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun differentSizeLists() {
        val expected = listOf(DataClass("a first string"))

        val actual = underTest.aList()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun notNullObject() {
        val actual = underTest.aNullableObject()

        assertThat(actual).isNotNull
    }

}
