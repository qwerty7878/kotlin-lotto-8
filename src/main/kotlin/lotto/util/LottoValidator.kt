package lotto.util

import lotto.util.LottoConstants.DEFAULT_ERROR_MESSAGE
import lotto.util.LottoConstants.EMPTY_ERROR_MESSAGE
import lotto.util.LottoConstants.POSITIVE_ERROR_MESSAGE
import lotto.util.LottoConstants.PRICE_ERROR_MESSAGE
import lotto.util.LottoConstants.TICKET_PRICE
import lotto.util.LottoConstants.ZERO

object LottoValidator {
    fun validatePriceRange(price: Int) {
        require(price % TICKET_PRICE == ZERO) { PRICE_ERROR_MESSAGE }
    }

    fun validatePositive(price: Int) {
        require(price > ZERO) { POSITIVE_ERROR_MESSAGE }
    }

    fun validateEmpty(price: String) {
        require(price.isNotEmpty()) { EMPTY_ERROR_MESSAGE }
    }

    fun parseToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(DEFAULT_ERROR_MESSAGE)
    }
}