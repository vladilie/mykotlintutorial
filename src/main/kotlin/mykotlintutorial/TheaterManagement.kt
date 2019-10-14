package mykotlintutorial

import java.math.BigDecimal

data class Seat(val row: Int,
                val column: Int,
                val price: BigDecimal,
                val description: String) {
    override fun toString(): String {
        return "Row $row-$column : $price"
    }
}

class TheaterManagement {
    private val seats: List<Seat> = prepareSeats()

    fun listCheapSeats(): List<Seat> {
        return seats.filter { it.price == CHEAPEST_PRICE }
    }

    companion object {
        @JvmField
        val CHEAPEST_PRICE = BigDecimal(14.50)
        private const val STANDARD_VIEW = "standard view"
        const val CHEAP_ROW = "cheap row"
        const val BACK_ROW = "back row"
        private const val RESTRICTED_VIEW = "restricted view"
        private const val BEST_VIEW = "best view"

        private fun getPrice( row: Int, column: Int): BigDecimal {
            return when {
                row == 14 || row == 15 -> CHEAPEST_PRICE
                column <=3 || column >= 34 -> BigDecimal(16.5)
                row == 1 -> BigDecimal(21)
                else -> BigDecimal(18)
            }
        }

        private fun getDescription( row: Int, column: Int): String {
            return when {
                row == 14 -> CHEAP_ROW
                row == 15 -> BACK_ROW
                column <=3 || column >= 34 -> RESTRICTED_VIEW
                row <= 2 -> BEST_VIEW
                else -> STANDARD_VIEW
            }
        }

        private fun prepareSeats(): List<Seat> {
            val theSeats = mutableListOf<Seat>()
            for (row in 1..15)
                for (column in 1..36)
                    theSeats.add(Seat(row, column, getPrice(row, column), getDescription(row, column)))
            return theSeats.toList()
        }
    }
}


fun main() {
    for (seat in TheaterManagement().listCheapSeats())
        println(seat)
}