package hu.netcode.springcloudstreamkotlindemo.messaging

import com.ninjasquad.springmockk.MockkBean
import hu.netcode.springcloudstreamkotlindemo.service.MessagingService
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [
    Consumer::class
])
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class ConsumerTest {
    @Autowired
    private lateinit var consumer: Consumer

    @MockkBean(relaxed = true)
    private lateinit var messagingService: MessagingService

    @DisplayName(value = "Tests for function receive")
    @Nested
    @TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
    inner class Receive {
        @Test
        fun `successfully receive message`() {
            every { messagingService.reverseAndReturn(any()) } just Runs
            consumer.receive(mockk(relaxed = true))
            verify { messagingService.reverseAndReturn(any()) }
        }
    }
}
