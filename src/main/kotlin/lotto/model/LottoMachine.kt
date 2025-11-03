package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.LottoConstants.LOTTO_END_NUMBER
import lotto.util.LottoConstants.LOTTO_LENGTH
import lotto.util.LottoConstants.LOTTO_START_NUMBER

class LottoMachine {
    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_LENGTH)
        return Lotto(numbers)
    }

    fun generateLottos(ticket: Int): List<Lotto> {
        return List(ticket) { generateLotto() }
    }
}