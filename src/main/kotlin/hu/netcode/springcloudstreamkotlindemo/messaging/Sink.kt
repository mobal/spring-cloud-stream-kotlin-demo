package hu.netcode.springcloudstreamkotlindemo.messaging

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface Sink {
    companion object {
        const val REVERSE = "reverse"
    }

    @Input(value = REVERSE)
    fun reverse(): SubscribableChannel
}
