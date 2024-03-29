/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package mykotlintutorial

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import java.util.*
import org.junit.Test

class PersonTest {
    @Test
    fun testPersonCanBeBuilt() {
        val classUnderTest = Person(1L, "", "", "")
        assertNotNull("person should be built", classUnderTest)
        assertEquals(
                "Person(id=1, title=, firstName=, surname=, dateOfBirth=null)",
                classUnderTest.toString()
        )
    }

    @Test
    fun testPersonWithNoDateOfBirth() {
        val classUnderTest = Person(1L, "", "", "")
        assertEquals(classUnderTest.age, -1)
    }

    @Test
    fun testPersonBornThisYear() {
        val year = GregorianCalendar().get(Calendar.YEAR);
        val classUnderTest = Person(1L, "", "", "",
                GregorianCalendar(year, 1, 1))
        assertEquals(classUnderTest.age, 0)
    }

    @Test
    fun testPersonBornLastYear() {
        val year = GregorianCalendar().get(Calendar.YEAR) - 1;
        val classUnderTest = Person(1L, "", "", "",
                GregorianCalendar(year, 1, 1))
        assertEquals(classUnderTest.age, 1)
    }


    @Test
    fun testPersonBorn2YearsAgo() {
        val year = GregorianCalendar().get(Calendar.YEAR) - 2;
        val classUnderTest = Person(1L, "", "", "",
                GregorianCalendar(year, 1, 1))
        assertEquals(classUnderTest.age, 2)
    }

    @Test
    fun testPersonBornAfterToday2YearsAgo() {
        val todayDate = GregorianCalendar()
        val twoYearsAgo = todayDate.get(Calendar.YEAR) - 2;
        val day = todayDate.get(Calendar.DAY_OF_YEAR);
        val classUnderTest = Person(1L, "", "", "",
                GregorianCalendar(twoYearsAgo, 1, day + 3))
        assertEquals(classUnderTest.age, 1)
    }

    @Test
    fun testLastLetterFromColorWhenThereIsNone() {
        val classUnderTest = Person(1L, "", "", "")
        assertEquals(classUnderTest.getLastLetter(), "")
    }

    @Test
    fun testLastLetterFromColor() {
        val classUnderTest = Person(1L, "", "", "")
        classUnderTest.color = "green"
        assertEquals(classUnderTest.getLastLetter(), "n")
    }


}
