package hu.netcode.springcloudstreamkotlindemo.messaging

import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component

@Component
@EnableBinding(value = [Source::class])
class Producer(
    private val source: Source
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @SendTo(value = [Source.REVERSED])
    fun sendToReversed(msg: Message<String>) {
        logger.info("""Sending reversed message "{}"""", msg)
        source.reversed().send(msg)
    }
}
