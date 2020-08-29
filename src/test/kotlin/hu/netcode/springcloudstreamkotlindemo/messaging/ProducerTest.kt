package hu.netcode.springcloudstreamkotlindemo.messaging

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat
import org.springframework.messaging.support.MessageBuilder

@SpringBootTest
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class ProducerTest {
    private companion object {
        const val PAYLOAD = "payload"

        val msg = MessageBuilder.withPayload(PAYLOAD)
            .build()
    }

    @Autowired
    private lateinit var messageCollector: MessageCollector
    @Autowired
    private lateinit var producer: Producer
    @Autowired
    private lateinit var source: Source

    @DisplayName(value = "Tests for function sendToReversed")
    @Nested
    @TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
    inner class SendToReversed {
        @Test
        fun `successfully send message to reversed channel`() {
            val messages = messageCollector.forChannel(source.reversed())
            producer.sendToReversed(msg)
            assertThat(messages, receivesPayloadThat(`is`(PAYLOAD)))
        }
    }
}
