package lotto.util

import lotto.util.LottoConstants.DEFAULT_ERROR_MESSAGE
import lotto.util.LottoConstants.DUPLICATE_ERROR_MESSAGE
import lotto.util.LottoConstants.EMPTY_ERROR_MESSAGE
import lotto.util.LottoConstants.LENGTH_ERROR_MESSAGE
import lotto.util.LottoConstants.LOTTO_END_NUMBER
import lotto.util.LottoConstants.LOTTO_LENGTH
import lotto.util.LottoConstants.LOTTO_START_NUMBER
import lotto.util.LottoConstants.NUMBER_RANGE_ERROR_MESSAGE
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

    fun validateLength(numbers: Set<Int>) {
        require(numbers.size == LOTTO_LENGTH) { LENGTH_ERROR_MESSAGE }
    }

    fun validateNumbersRange(numbers: List<Int>) {
        require(numbers.all { it in LOTTO_START_NUMBER..LOTTO_END_NUMBER }) { NUMBER_RANGE_ERROR_MESSAGE }
    }

    fun validateNumberRange(numbers: Int) {
        require(numbers in LOTTO_START_NUMBER..LOTTO_END_NUMBER) { NUMBER_RANGE_ERROR_MESSAGE }
    }

    fun validateDuplicate(number: Int, winningNumbers: Set<Int>) {
        require(number !in winningNumbers) { DUPLICATE_ERROR_MESSAGE }
    }

}