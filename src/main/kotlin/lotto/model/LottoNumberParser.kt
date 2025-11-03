package lotto.model

import lotto.util.LottoConstants.SEPARATOR_NUMBERS
import lotto.util.LottoValidator.parseToInt
import lotto.util.LottoValidator.validateDuplicate
import lotto.util.LottoValidator.validateEmpty
import lotto.util.LottoValidator.validateLength
import lotto.util.LottoValidator.validateNumberRange
import lotto.util.LottoValidator.validateNumbersRange

class LottoNumberParser {
    fun parseWinningNumbers(input: String): List<Int> {
        validateEmpty(input)
        val splitNumbers = splitNumber(input)
        val numbers = parseToIntList(splitNumbers)
        validateLength(numbers.toSet())
        validateNumbersRange(numbers)
        return numbers
    }

    fun parseBonusNumber(input: String, winningNumbers: Set<Int>): Int {
        validateEmpty(input)
        val number = parseToInt(input)
        validateNumberRange(number)
        validateDuplicate(number, winningNumbers)
        return number
    }

    private fun parseToIntList(numbers: List<String>): List<Int> {
        return numbers.map { parseToInt(it) }
    }

    private fun splitNumber(input: String): List<String> {
        return input.split(SEPARATOR_NUMBERS)
            .map { it.trim() }
    }
}