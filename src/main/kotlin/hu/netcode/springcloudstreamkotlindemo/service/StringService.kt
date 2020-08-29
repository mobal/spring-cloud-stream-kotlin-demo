package hu.netcode.springcloudstreamkotlindemo.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class StringService {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun reversed(s: String): String {
        return s.reversed()
    }
}
