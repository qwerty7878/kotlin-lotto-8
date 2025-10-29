package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.LottoConstants.PURCHASE_LOTTO_MESSAGE

class LottoInputView {

    fun purchaseInput(): String {
        printMessage(PURCHASE_LOTTO_MESSAGE)
        return Console.readLine()
    }

    private fun printMessage(message: String) {
        println(message)
    }
}