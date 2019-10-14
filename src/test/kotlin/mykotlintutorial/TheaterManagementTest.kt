package mykotlintutorial

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class TheaterManagementTest {
    @Test
    fun testCheapSeats() {
        val classUnderTest = TheaterManagement()
        assertNotNull(classUnderTest, "theater management should be built")
        classUnderTest.listCheapSeats().forEach {
            assertTrue(it.row == 14 || it.row == 15)
            assertTrue(it.column in 1..36)
            assertEquals(it.price, TheaterManagement.CHEAPEST_PRICE)
            assertTrue(it.description == TheaterManagement.CHEAP_ROW ||
                    it.description == TheaterManagement.BACK_ROW)
        }
    }

}