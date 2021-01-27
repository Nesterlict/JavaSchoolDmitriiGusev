import ecare.MVC.entities.Tariff
import ecare.config.PersistenceJPAConfig
import ecare.services.api.TariffService
import ecare.services.api.UserService
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@WebAppConfiguration
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [PersistenceJPAConfig::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class TariffTests {

    @Autowired
    private val tariffService: TariffService? = null

    var id:Int?=null

    @BeforeAll
    fun init() {
        tariffService!!.createEntity(Tariff("name", 1000.toBigDecimal(), "description"))
        id = tariffService.getTariffByName("name").tariffId
    }

    @Test
    @Transactional
    open fun getTariffByNameTest() {
        Assert.assertEquals(tariffService!!.getTariffByName("name").name,"name")
    }

    @Test
    @Transactional
    open fun getTariffByIdTest() {
        Assert.assertEquals(tariffService!!.getEntityById(id).tariffId,id)
    }

    @Test
    @Transactional
    open fun isTariffExistedTest() {
        tariffService!!.isTariffExists(tariffService.getTariffByName("name"))
    }

}