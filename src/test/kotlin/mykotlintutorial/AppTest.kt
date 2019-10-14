package mykotlintutorial

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

// Requires localstack to be running.
@RunWith(SpringRunner::class)
@SpringBootTest
class AppTest {
    @Test
    fun contextLoads() {
    }
}

