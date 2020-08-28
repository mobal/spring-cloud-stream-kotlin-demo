package hu.netcode.springcloudstreamkotlindemo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringCloudStreamKotlinDemoApplication {
    @Bean
    fun objetMapper(): ObjectMapper {
        return jacksonObjectMapper()
    }
}

fun main(args: Array<String>) {
    runApplication<SpringCloudStreamKotlinDemoApplication>(*args)
}
