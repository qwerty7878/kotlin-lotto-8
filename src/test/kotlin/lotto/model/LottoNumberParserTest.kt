package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberParserTest {
    private val lottoNumberParser = LottoNumberParser()

    @Test
    fun `정상 숫자 6자리`() {
        val list = listOf(1,2,3,4,5,6)
        assertEquals(list, lottoNumberParser.parseWinningNumbers("1,2,3,4,5,6"))
    }

    @Test
    fun `, 가 아닌경우 `() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseWinningNumbers("1:2,3,4,5,6") }
    }

    @Test
    fun `범위 초과 숫자 6 자리`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseWinningNumbers("111:2,3,4,5,6") }
    }

    @Test
    fun `범위 초과 숫자 음수`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseWinningNumbers("-1,2,3,4,5,6") }
    }

    @Test
    fun `중복 처리`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseWinningNumbers("1,1,3,4,5,6") }
    }

    @Test
    fun `빈 값 처리`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseWinningNumbers(" ") }
    }

    @Test
    fun `잘못된 입력 처리`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseWinningNumbers("@,1,2,3,4") }
    }

    @Test
    fun `보너스 번호가 널값인 경우`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseBonusNumber("", setOf(1,2,3,4,5,6)) }
    }

    @Test
    fun `보너스 번호가 음수인 경우`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseBonusNumber("-1", setOf(1,2,3,4,5,6)) }
    }

    @Test
    fun `보너스 번호가 범위를 초과 한 경우`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseBonusNumber("-46", setOf(1,2,3,4,5,6)) }
    }

    @Test
    fun `보너스 번호가 중복인 경우`() {
        assertThrows<IllegalArgumentException> { lottoNumberParser.parseBonusNumber("1", setOf(1,2,3,4,5,6)) }
    }

    @Test
    fun `보너스 번호가 정상인 경우`() {
        assertEquals(10, lottoNumberParser.parseBonusNumber("10", setOf(1,2,3,4,5,6)))
    }
}