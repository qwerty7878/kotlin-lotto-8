package lotto.model

import lotto.util.LottoConstants.SEPARATOR_NUMBERS
import lotto.util.LottoValidator.parseToInt
import lotto.util.LottoValidator.validateEmpty
import lotto.util.LottoValidator.validateLength
import lotto.util.LottoValidator.validateNumberRange

class LottoNumberParser {
    fun parseWinningNumbers(input: String): List<Int> {
        validateEmpty(input)
        val splitNumbers = splitNumber(input)
        val numbers = parseToIntList(splitNumbers)
        validateLength(numbers.toSet())
        validateNumberRange(numbers)
        return numbers
    }

    private fun parseToIntList(numbers: List<String>): List<Int> {
        return numbers.map { parseToInt(it) }
    }

    private fun splitNumber(input: String): List<String> {
        return input.split(SEPARATOR_NUMBERS)
    }
}