package hu.netcode.springcloudstreamkotlindemo.service

import hu.netcode.springcloudstreamkotlindemo.messaging.Producer
import org.slf4j.LoggerFactory
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class MessagingService(
    private val producer: Producer,
    private val stringService: StringService
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun reverseAndReturn(msg: Message<String>) {
        producer.sendToReversed(
            MessageBuilder.withPayload(stringService.reversed(msg.payload))
                .build()
        )
    }
}
