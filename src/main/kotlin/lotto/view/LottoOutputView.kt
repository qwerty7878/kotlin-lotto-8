package lotto.view

import lotto.util.LottoConstants.BUYING_TICKET_MESSAGE

class LottoOutputView {
    fun printTicket(ticket: Int) {
        println("${ticket}" + BUYING_TICKET_MESSAGE)
    }
}