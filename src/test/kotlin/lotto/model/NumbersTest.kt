package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersTest {
    private val numbers = Numbers()

    @Test
    fun `정상 숫자 6자리`() {
        val list = listOf(1,2,3,4,5,6)
        assertEquals(list, numbers.inputWinningNumbers("1,2,3,4,5,6"))
    }

    @Test
    fun `, 가 아닌경우 `() {
        assertThrows<IllegalArgumentException> { numbers.inputWinningNumbers("1:2,3,4,5,6") }
    }

    @Test
    fun `범위 초과 숫자 6 자리`() {
        assertThrows<IllegalArgumentException> { numbers.inputWinningNumbers("111:2,3,4,5,6") }
    }

    @Test
    fun `범위 초과 숫자 음수`() {
        assertThrows<IllegalArgumentException> { numbers.inputWinningNumbers("-1,2,3,4,5,6") }
    }

    @Test
    fun `중복 처리`() {
        assertThrows<IllegalArgumentException> { numbers.inputWinningNumbers("1,1,3,4,5,6") }
    }

    @Test
    fun `빈 값 처리`() {
        assertThrows<IllegalArgumentException> { numbers.inputWinningNumbers(" ") }
    }

    @Test
    fun `잘못된 입력 처리`() {
        assertThrows<IllegalArgumentException> { numbers.inputWinningNumbers("@,1,2,3,4") }
    }

}