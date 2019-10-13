package mykotlintutorial

import java.util.*

data class Person(val id: Long,
                  val title: String,
                  val firstName: String,
                  val surname: String,
                  val dateOfBirth: Calendar? = null) {

    val age: Int
        get() = getAge(dateOfBirth)

    var color: String? = null

    fun getLastLetter(): String = color?.let{ it.last().toString()} ?: ""

    companion object {
        fun getAge(dateOfBirth: Calendar?): Int =
                getAge(getDayOfBirth(dateOfBirth), getYearOfBirth(dateOfBirth))

        fun getAge(dayOfBirth: Int, yearOfBirth: Int): Int {
            if (yearOfBirth == 0) return -1
            val today = GregorianCalendar()
            var years = today.get(Calendar.YEAR) - yearOfBirth
            return if (dayOfBirth >= today.get(Calendar.DAY_OF_YEAR)) years - 1 else years
        }

        fun getDayOfBirth(dateOfBirth: Calendar?): Int = dateOfBirth?.get(Calendar.DAY_OF_YEAR) ?: 0
        fun getYearOfBirth(dateOfBirth: Calendar?): Int = dateOfBirth?.get(Calendar.YEAR) ?: 0

    }
}