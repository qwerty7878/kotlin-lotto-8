package lotto.view

import lotto.model.Lotto
import lotto.util.LottoConstants.BUYING_TICKET_MESSAGE

class LottoOutputView {
    fun printTicket(ticket: Int) {
        println("${ticket}" + BUYING_TICKET_MESSAGE)
    }

    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }
}