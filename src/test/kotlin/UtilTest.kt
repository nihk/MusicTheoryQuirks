import org.junit.Assert
import org.junit.Test

class UtilTest {

    @Test
    fun `shortest distance counter-clockwise around pc universe`() {
        val result = shortestDistance(4, 11, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(5, result)
    }

    @Test
    fun `shortest distance counter-clockwise around pc universe from zero`() {
        val result = shortestDistance(0, 11, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(1, result)
    }

    @Test
    fun `shortest distance clockwise around pc universe`() {
        val result = shortestDistance(4, 7, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(3, result)
    }

    @Test
    fun `shortest distance clockwise around pc universe to zero`() {
        val result = shortestDistance(7, 0, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(5, result)
    }

    @Test
    fun `shortest distance directional clockwise`() {
        val result = shortestDistanceDirectional(4, 7, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(3, result)
    }

    @Test
    fun `shortest distance directional counter-clockwise`() {
        val result = shortestDistanceDirectional(4, 0, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(-4, result)
    }

    @Test
    fun `shortest distance directional clockwise wrap-around universe`() {
        val result = shortestDistanceDirectional(9, 1, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(4, result)
    }

    @Test
    fun `shortest distance directional counter-clockwise wrap-around universe`() {
        val result = shortestDistanceDirectional(0, 11, PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(-1, result)
    }

    @Test
    fun `invert direction neg to pos`() {
        val n = -5

        val result = n.invertDirectionModulo(PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(7, result)
    }

    @Test
    fun `invert direction big neg to pos`() {
        val n = -17

        val result = n.invertDirectionModulo(PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(7, result)
    }

    @Test
    fun `invert direction pos to neg`() {
        val n = 5

        val result = n.invertDirectionModulo(PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(-7, result)
    }

    @Test
    fun `invert direction big pos to neg`() {
        val n = 17

        val result = n.invertDirectionModulo(PITCH_CLASS_UNIVERSE_SIZE)

        Assert.assertEquals(-7, result)
    }
}