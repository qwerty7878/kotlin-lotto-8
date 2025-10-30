package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `1 ~ 45 이외의 수 인경우 예외처리 - 0인 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 0, 5))
        }
    }

    @Test
    fun `1 ~ 45 이외의 수 인경우 예외처리 - 음수인 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, -1, 5))
        }
    }

    @Test
    fun `1 ~ 45 이외의 수 인경우 예외처리 - 45를 초과한 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 50, 5))
        }
    }

    @Test
    fun `1 ~ 45 이외의 수 인경우 예외처리 - 비어있는 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(emptyList())
        }
    }


    @Test
    fun `로또 번호 오름차순 정렬`() {
        val lotto = Lotto(listOf(5, 1, 2, 3, 4, 6))
        val sorted = lotto.getNumbers()
        assertEquals(listOf(1,2,3,4,5,6), sorted)
    }

}
