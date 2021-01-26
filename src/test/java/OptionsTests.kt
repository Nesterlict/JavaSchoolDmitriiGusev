import ecare.MVC.entities.Options
import ecare.config.PersistenceJPAConfig
import ecare.services.api.OptionsService
import org.junit.Assert
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [PersistenceJPAConfig::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class OptionsTests {

    @Autowired
    private val optionsService: OptionsService? = null

    var id: Int? = null

    @BeforeAll
    fun init() {
        var option1 = Options("name", 100.toBigDecimal(), 50.toBigDecimal(), "description")
        optionsService!!.createEntity(option1)
    }

    @Test
    @Transactional
    open fun getByIdTest() {
        var price = BigDecimal("50.00")
        Assert.assertEquals(optionsService!!.getEntityById(5).connectionPrice, price)
    }

    @Test
    @Transactional
    open fun getAllOptionsForContractTest(){
        val price1: BigDecimal = BigDecimal(100).setScale(2, BigDecimal.ROUND_HALF_UP)
        val connectionPrice1: BigDecimal = BigDecimal(10).setScale(2, BigDecimal.ROUND_HALF_UP)

        var option1 = Options("gb1",price1,connectionPrice1,"1gb internet")
        var option2 = Options("100min",price1,connectionPrice1,"100 minutes calls")
        var optionList = listOf<Options>(option1,option2)
        Assert.assertEquals(optionsService!!.getAllOptionsForContract(2),optionList)
    }

}
