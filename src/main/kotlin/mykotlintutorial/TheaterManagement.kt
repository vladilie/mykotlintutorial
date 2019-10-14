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

        private fun prepareSeats(): List<Seat> {
            val theSeats = mutableListOf<Seat>()
            for (row in 1..15)
                for (column in 1..36) {
                    var price = BigDecimal(18)
                    var description = STANDARD_VIEW
                    if (row == 14 || row == 15) {
                        price = CHEAPEST_PRICE
                        description = if (row == 14) CHEAP_ROW else BACK_ROW
                    } else if ((row in 1..13) &&
                            ((column in 1..3) || column in 34..36)) {
                        price = BigDecimal(16.5)
                        description = RESTRICTED_VIEW
                    } else if (row == 1 || row == 2) {
                        price = BigDecimal(21)
                        description = BEST_VIEW
                    }

                    theSeats.add(Seat(row, column, price, description))

                }

            return theSeats.toList()
        }
    }
}


fun main() {
    for (seat in TheaterManagement().listCheapSeats())
        println(seat)
}