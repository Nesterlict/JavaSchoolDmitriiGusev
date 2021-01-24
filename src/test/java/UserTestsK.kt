import ecare.config.PersistenceJPAConfig
import ecare.services.api.UserService
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [PersistenceJPAConfig::class])
open class UserTestsK {

    @Autowired
    private val userService: UserService? = null

    @Test
    @Transactional
    open fun getUserByEmailTest() {
        Assert.assertEquals(userService!!.getUserByEMAil("NAsales@tesla.com").userId, 1)
    }

    @Test
    @Transactional
    open fun getUserByNumberTest() {
        Assert.assertEquals(userService!!.getUserByNumber("6761230323").userId,1)
    }

}