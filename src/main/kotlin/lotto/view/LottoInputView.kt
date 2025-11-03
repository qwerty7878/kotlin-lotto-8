package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.LottoConstants.BONUS_NUMBER_MESSAGE
import lotto.util.LottoConstants.PURCHASE_LOTTO_MESSAGE
import lotto.util.LottoConstants.WINNING_NUMBER_MESSAGE

class LottoInputView {

    private fun printMessage(message: String): String {
        println(message)
        return Console.readLine()
    }

    fun inputWinningNumbers(): String {
        println()
        return printMessage(WINNING_NUMBER_MESSAGE)
    }

    fun inputPurchaseAmount(): String {
        return printMessage(PURCHASE_LOTTO_MESSAGE)
    }

    fun inputBonusNumber(): String {
        println()
        return printMessage(BONUS_NUMBER_MESSAGE)
    }
}