import ecare.MVC.entities.Tariff
import ecare.MVC.entities.User
import ecare.config.PersistenceJPAConfig
import ecare.services.api.TariffService
import ecare.services.api.UserService
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import java.sql.Date

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [PersistenceJPAConfig::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class UserTests {

    @Autowired
    private val userService: UserService? = null

    var id:Int?=null

    @BeforeAll
    fun init() {
        userService!!.createEntity(User("Maria","Dmitrieva",null,"1221 100001","ulitsa","MDmitrieva@mail.com",1000.toBigDecimal(),"password","userA"))
        id = userService.getUserByEMAil("MDmitrieva@mail.com").userId}

    @Test
    @Transactional
    open fun getUserByEmailTest() {
        Assert.assertEquals(userService!!.getUserByEMAil("MDmitrieva@mail.com").email, "MDmitrieva@mail.com")
    }

    @Test
    @Transactional
    open fun getUserByNumberTest() {
        Assert.assertEquals(userService!!.getUserByNumber("6761230323").userId,1)
    }

    @Test
    @Transactional
    open fun get(){
        Assert.assertEquals(userService!!.getEntityById(id).userId,id)
    }

}