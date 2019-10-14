package mykotlintutorial

import java.math.BigDecimal

data class Seat(val row: Int,
                val column: Int,
                val price: BigDecimal,
                val description: String) {
    override fun toString(): String = "Row $row-$column : $price"
}

class TheaterManagement {
    private val seats: List<Seat> = prepareSeats()

    fun listCheapSeats(): List<Seat> = seats.filter { it.price == CHEAPEST_PRICE }

    companion object {
        @JvmField
        val CHEAPEST_PRICE = BigDecimal(14.50)
        private const val STANDARD_VIEW = "standard view"
        const val CHEAP_ROW = "cheap row"
        const val BACK_ROW = "back row"
        private const val RESTRICTED_VIEW = "restricted view"
        private const val BEST_VIEW = "best view"

        private fun getPrice(row: Int, column: Int): BigDecimal = when {
            row == 14 || row == 15 -> CHEAPEST_PRICE
            column <= 3 || column >= 34 -> BigDecimal(16.5)
            row == 1 -> BigDecimal(21)
            else -> BigDecimal(18)
        }

        private fun getDescription(row: Int, column: Int): String = when {
            row == 14 -> CHEAP_ROW
            row == 15 -> BACK_ROW
            column <= 3 || column >= 34 -> RESTRICTED_VIEW
            row <= 2 -> BEST_VIEW
            else -> STANDARD_VIEW
        }

        private fun prepareSeats(): List<Seat> = (1..15).map { row ->
            (1..36).map { column ->
                Seat(row, column, getPrice(row, column), getDescription(row, column))
            }
        }.flatMap { it.asIterable() }
    }
}


fun main() {
    for (seat in TheaterManagement().listCheapSeats())
        println(seat)
}