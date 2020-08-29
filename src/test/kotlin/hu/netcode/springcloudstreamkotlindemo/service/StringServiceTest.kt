package hu.netcode.springcloudstreamkotlindemo.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [
    StringService::class
])
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class StringServiceTest {
    private companion object {
        const val STRING = "STRING"
        const val REVERSED_STRING = "GNIRTS"
    }

    @Autowired
    private lateinit var stringService: StringService

    @DisplayName(value = "Test for function reversed")
    @Nested
    @TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
    inner class Reversed {
        @Test
        fun `successfully reverse string`() {
            val result = stringService.reversed(STRING)
            assertEquals(REVERSED_STRING, result)
        }
    }
}
