import org.junit.Assert
import org.junit.Test

class AccidentalSignTest {

    @Test
    fun `flat minus 1 yields flat`() {
        val result = AccidentalSign.FLAT - 1

        Assert.assertEquals(AccidentalSign.FLAT, result)
    }

    @Test
    fun `flat plus 0 yields flat`() {
        val result = AccidentalSign.FLAT + 0

        Assert.assertEquals(AccidentalSign.FLAT, result)
    }

    @Test
    fun `flat plus 1 yields natural`() {
        val result = AccidentalSign.FLAT + 1

        Assert.assertEquals(AccidentalSign.NATURAL, result)
    }

    @Test
    fun `flat plus 2 yields sharp`() {
        val result = AccidentalSign.FLAT + 2

        Assert.assertEquals(AccidentalSign.SHARP, result)
    }

    @Test
    fun `natural minus 1 yields flat`() {
        val result = AccidentalSign.NATURAL - 1

        Assert.assertEquals(AccidentalSign.FLAT, result)
    }

    @Test
    fun `natural plus 0 yields natural`() {
        val result = AccidentalSign.NATURAL + 0

        Assert.assertEquals(AccidentalSign.NATURAL, result)
    }

    @Test
    fun `natural plus 1 yields sharp`() {
        val result = AccidentalSign.NATURAL + 1

        Assert.assertEquals(AccidentalSign.SHARP, result)
    }

    @Test
    fun `sharp minus 2 yields flat`() {
        val result = AccidentalSign.SHARP - 2

        Assert.assertEquals(AccidentalSign.FLAT, result)
    }

    @Test
    fun `sharp minus 1 yields natural`() {
        val result = AccidentalSign.SHARP - 1

        Assert.assertEquals(AccidentalSign.NATURAL, result)
    }

    @Test
    fun `sharp plus 0 yields sharp`() {
        val result = AccidentalSign.SHARP + 0

        Assert.assertEquals(AccidentalSign.SHARP, result)
    }

    @Test
    fun `sharp plus 1 yields sharp`() {
        val result = AccidentalSign.SHARP + 1

        Assert.assertEquals(AccidentalSign.SHARP, result)
    }
}