package lotto.view

import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.RankResult
import lotto.util.LottoConstants.BUYING_TICKET_MESSAGE
import lotto.util.LottoConstants.DIVIDE_BAR
import lotto.util.LottoConstants.WINNING_STATISTICS

class LottoOutputView {
    fun printTicket(ticket: Int) {
        println("${ticket}" + BUYING_TICKET_MESSAGE)
    }

    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }

    fun printResult() {
        println(WINNING_STATISTICS)
        println(DIVIDE_BAR)
    }

    fun printStatic(result: RankResult) {
        printRankResult(result, Rank.FIRST)
        printRankResult(result, Rank.SECOND)
        printRankResult(result, Rank.THIRD)
        printRankResult(result, Rank.FOURTH)
        printRankResult(result, Rank.FIFTH)
        printRankResult(result, Rank.NONE)
    }

    private fun printRankResult(result: RankResult, rank: Rank) {
        val matchCount = result.getRankCount(rank)
        val prizeFormatted = "%,d".format(rank.prize)
        println("${rank.message}}개 일치 (${prizeFormatted}) - ${matchCount}개")
    }
}