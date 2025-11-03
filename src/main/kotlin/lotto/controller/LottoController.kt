package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.model.LottoNumberParser
import lotto.model.RankResult
import lotto.model.Ticket
import lotto.util.LottoConstants.TICKET_PRICE
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

class LottoController {
    private val inputView = LottoInputView()
    private val outputView = LottoOutputView()
    private val ticket = Ticket()
    private val LottoMachine = LottoMachine()
    private val parser = LottoNumberParser()

    fun run() {
        val ticketCount = getPurchaseAmount()
        val lottos = generateAndPrintLottos(ticketCount)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = gerBonusNumber(winningNumbers)
        printResult(lottos, winningNumbers, bonusNumber, ticketCount)
    }

    private fun printResult(
        lottos: List<Lotto>,
        winningNumbers: Set<Int>,
        bonusNumber: Int,
        ticketCount: Int
    ) {
        val result = RankResult(lottos)
        result.calculateRank(winningNumbers, bonusNumber)

        outputView.printResult()
        outputView.printStatic(result)
        outputView.printLottoProfitRate(result, ticketCount * TICKET_PRICE)
    }

    private fun gerBonusNumber(winningNumbers: Set<Int>): Int {
        while (true) try {
            val input = inputView.inputBonusNumber()
            return parser.parseBonusNumber(input, winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun getWinningNumbers(): Set<Int> {
        while (true) try {
            val input = inputView.inputWinningNumbers()
            return parser.parseWinningNumbers(input).toSet()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun generateAndPrintLottos(ticketCount: Int): List<Lotto> {
        val lottos = LottoMachine.generateLottos(ticketCount)
        outputView.printTicket(ticketCount)
        outputView.printLottos(lottos)
        return lottos
    }

    private fun getPurchaseAmount(): Int {
        while (true) try {
            val input = inputView.inputPurchaseAmount()
            return ticket.purchaseTicket(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}