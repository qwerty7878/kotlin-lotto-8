package lotto.model

import lotto.util.LottoValidator.validateLength
import lotto.util.LottoValidator.validateNumbersRange

class Lotto(private val numbers: List<Int>) {
    init {
        validateLength(numbers.toSet())
        validateNumbersRange(numbers)
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}