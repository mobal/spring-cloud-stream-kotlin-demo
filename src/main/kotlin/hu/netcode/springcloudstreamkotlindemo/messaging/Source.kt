package hu.netcode.springcloudstreamkotlindemo.messaging

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface Source {
    companion object {
        const val REVERSED = "reversed"
    }

    @Output(value = REVERSED)
    fun reversed(): MessageChannel
}
