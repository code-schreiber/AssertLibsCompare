package com.toolslab.assertlibscompare

import org.amshove.kluent.shouldBeGreaterThan
import org.amshove.kluent.shouldBeLessThan
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotEqual
import org.junit.Test

class KluentTest {

    private val underTest = UnderTest()

    @Test
    fun equalIntegers() {
        val expected = 5

        val actual = underTest.anInteger()

        actual shouldEqual expected
    }

    @Test
    fun integerComparison() {
        val actual = underTest.anInteger()

        actual shouldBeGreaterThan 0
    }

    @Test
    fun equalStrings() {
        val expected = "a string"

        val actual = underTest.aString()

        actual shouldEqual expected
    }

    @Test
    fun equalDataClasses() {
        val expected = DataClass("a string")

        val actual = underTest.aDataClass()

        actual shouldEqual expected
    }

    @Test
    fun equalClasses() {
        val expected = Class("a string")

        val actual = underTest.aClass()

        actual.value shouldEqual expected.value
    }

    @Test
    fun equalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("a second string")
        )

        val actual = underTest.aList()

        actual shouldEqual expected
    }

    @Test
    fun nullObject() {
        val actual = underTest.aNullableObject()

        actual shouldEqual null
    }

    @Test
    fun unequalIntegers() {
        val expected = 99

        val actual = underTest.anInteger()

        actual shouldEqual expected
    }

    @Test
    fun failingIntegerComparison() {
        val actual = underTest.anInteger()

        actual shouldBeLessThan 0
    }

    @Test
    fun unequalStrings() {
        val expected = "another string"

        val actual = underTest.aString()

        actual shouldEqual expected
    }

    @Test
    fun unequalDataClasses() {
        val expected = DataClass("another string")

        val actual = underTest.aDataClass()

        actual shouldEqual expected
    }

    @Test
    fun unequalClasses() {
        val expected = Class("another string")

        val actual = underTest.aClass()

        actual.value shouldEqual expected.value
    }

    @Test
    fun unequalLists() {
        val expected = listOf(
            DataClass("a first string"),
            DataClass("something different")
        )

        val actual = underTest.aList()

        actual shouldEqual expected
    }

    @Test
    fun differentSizeLists() {
        val expected = listOf(DataClass("a first string"))

        val actual = underTest.aList()

        actual shouldEqual expected
    }

    @Test
    fun notNullObject() {
        val actual = underTest.aNullableObject()

        actual shouldNotEqual null
    }

}
