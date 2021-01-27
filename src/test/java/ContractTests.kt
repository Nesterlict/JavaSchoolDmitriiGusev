import ecare.MVC.entities.Contract
import ecare.MVC.entities.Tariff
import ecare.MVC.entities.User
import ecare.config.PersistenceJPAConfig
import ecare.services.api.ContractService
import ecare.services.api.TariffService
import ecare.services.api.UserService
import org.junit.Assert
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.Transactional

@WebAppConfiguration
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [PersistenceJPAConfig::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ContractTests {

    @Autowired
    private val contractService: ContractService? = null
    @Autowired
    private val userService: UserService? = null
    @Autowired
    private val tariffService: TariffService? = null

    var userId:Int?=null
    var contractId:Int?=null
    var tariffId:Int?=null

    @BeforeAll
    fun init() {
        var user1 = User("Maria","Dmitrieva",null,"1221 100001","ulitsa","MDmitrieva@mail.com",1000.toBigDecimal(),"password","userA")
        userService!!.createEntity(user1)
        userId = userService.getUserByEMAil("MDmitrieva@mail.com").userId

        var tariff1 = Tariff("name", 1000.toBigDecimal(), "description")
        tariffService!!.createEntity(tariff1)
        tariffId = tariffService.getTariffByName("name").tariffId
    }

    @Test
    @Transactional
    open fun getEntityByIdTest(){
        Assert.assertEquals(contractService!!.getEntityById(1).phoneNumber,"6761230323")

    }

    @Test
    @Transactional
    open fun getContractByNumberTest(){
        Assert.assertEquals(contractService!!.getContractByNumber("6761230323").contractID,1)
        contractService!!.getContractByNumber("6761230323")
    }


}