package com.toolslab.assertlibscompare

class UnderTest {

    fun anInteger() = 5

    fun aString() = "a string"

    fun aDataClass() = DataClass("a string")

    fun aClass() = Class("a string")

    fun aList(): List<DataClass> {
        return listOf(
            DataClass("a first string"),
            DataClass("a second string")
        )
    }

    fun aNullableObject(): Class? = null

}
