package hu.netcode.springcloudstreamkotlindemo.service

import com.ninjasquad.springmockk.MockkBean
import hu.netcode.springcloudstreamkotlindemo.messaging.Producer
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
import org.springframework.messaging.support.GenericMessage

@SpringBootTest(classes = [
    MessagingService::class
])
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class MessagingServiceTest {
    private companion object {
        const val PAYLOAD = "PAYLOAD"
        const val STRING = "STRING"
    }

    @Autowired
    private lateinit var messagingService: MessagingService

    @MockkBean(relaxed = true)
    private lateinit var producer: Producer
    @MockkBean(relaxed = true)
    private lateinit var stringService: StringService

    @DisplayName(value = "Tests for function reverseAndReturn")
    @Nested
    @TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
    inner class ReverseAndReturn {
        @Test
        fun `successfully reverse and return string`() {
            val msg = mockk<GenericMessage<String>>(relaxed = true)
            every { msg.payload } returns PAYLOAD
            every { producer.sendToReversed(any()) } just Runs
            every { stringService.reversed(any()) } returns STRING
            messagingService.reverseAndReturn(msg)
            verify { producer.sendToReversed(any()) }
        }
    }
}
