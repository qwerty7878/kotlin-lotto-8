package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TicketTest {
    private val ticket = Ticket()

    @Test
    fun `널 값 예외 테스트`() {
        var input = ""
        assertThrows<IllegalArgumentException> {
            ticket.purchaseTicket(input)
        }
    }

    @Test
    fun `문자열 예외 테스트`() {
        var input = "test"
        assertThrows<IllegalArgumentException> {
            ticket.purchaseTicket(input)
        }
    }

    @Test
    fun `음수 예외 테스트`() {
        var input = "-10000"
        assertThrows<IllegalArgumentException> {
            ticket.purchaseTicket(input)
        }
    }

    @Test
    fun `나머지 예외 테스트`() {
        var input = "11200"
        assertThrows<IllegalArgumentException> {
            ticket.purchaseTicket(input)
        }
    }

    @Test
    fun `정상 테스트`() {
        var input = "10000"
        assertEquals(10, ticket.purchaseTicket(input))
    }
}