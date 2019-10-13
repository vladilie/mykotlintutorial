package mykotlintutorial

import java.util.*

data class Person(val id: Long,
                  val title: String,
                  val firstName: String,
                  val surname:String,
                  val dateOfBirth: Calendar? = null) {
    var age: Int = -1
    get(){
       return getAge(dateOfBirth)
    }

    companion object Static {
        fun getAge(dateOfBirth: Calendar?):Int {
            if (null == dateOfBirth) return -1

            val today = GregorianCalendar()
            var years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
            if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.DAY_OF_YEAR)) {
                years -= 1;
            }

            return years;
        }
    }
}