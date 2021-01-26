import org.apache.logging.log4j.LogManager
import org.junit.jupiter.api.Test

class LoggerTests {
    @Test
    @Throws(Exception::class)
    fun defaultLoggerTest() {
        val logger = LogManager.getLogger(javaClass)
        val e: Exception = RuntimeException("This is only a test!")
        logger.info("This is a simple message at INFO level. " +
                "It will be hidden.")
        logger.error("This is a simple message at ERROR level. " +
                "This is the minimum visible level.", e)
    }
}