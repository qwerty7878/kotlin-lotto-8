package lotto.model

import lotto.util.LottoConstants.TICKET_PRICE
import lotto.util.LottoValidator.parseToInt
import lotto.util.LottoValidator.validateEmpty
import lotto.util.LottoValidator.validatePositive
import lotto.util.LottoValidator.validatePriceRange


class Ticket {
    fun purchaseTicket(input: String): Int {
        validateEmpty(input)
        val price = parseToInt(input)
        validatePositive(price)
        validatePriceRange(price)
        return convertTicket(price)
    }

    private fun convertTicket(price: Int): Int {
        return price / TICKET_PRICE
    }
}