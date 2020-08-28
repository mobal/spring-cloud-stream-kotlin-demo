package hu.netcode.springcloudstreamkotlindemo.messaging

import hu.netcode.springcloudstreamkotlindemo.service.MessagingService
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
@EnableBinding(value = [Sink::class])
class Consumer(
    private val messagingService: MessagingService
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @StreamListener(Sink.REVERSE)
    fun receive(msg: Message<String>) {
        logger.info("""Message "{}" received for reverse""", msg)
        messagingService.reverseAndReturn(msg)
    }
}
