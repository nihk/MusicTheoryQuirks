import org.junit.Assert
import org.junit.Test

class PitchClassTest {

    @Test
    fun `transpose c to d natural`() {
        val d = c().transpose(Interval(1, 2))

        Assert.assertEquals(PitchClass(PitchLetter.D), d)
    }

    @Test
    fun `transpose c to e flat`() {
        val eFlat = c().transpose(Interval(2, 3))

        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental(-1)), eFlat)
    }

    @Test
    fun `transpose c down to b`() {
        val b = c().transpose(Interval(-1, -1))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(0)), b)
    }

    @Test
    fun `transpose c# down to g`() {
        val g = cSharp().transpose(Interval(-3, -6))

        Assert.assertEquals(PitchClass(PitchLetter.G, Accidental(0)), g)
    }

    @Test
    fun `transpose c# down to f#`() {
        val fSharp = cSharp().transpose(Interval(-4, -7))

        Assert.assertEquals(PitchClass(PitchLetter.F, Accidental(1)), fSharp)
    }

    @Test
    fun `transpose c# down to gb`() {
        val gFlat = cSharp().transpose(Interval(-3, -7))

        Assert.assertEquals(PitchClass(PitchLetter.G, Accidental(-1)), gFlat)
    }

    @Test
    fun `transpose c# down to eb`() {
        val eFlat = cSharp().transpose(Interval(-5, -10))

        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental(-1)), eFlat)
    }

    @Test
    fun `transpose c# to fb`() {
        val result = cSharp().transpose(Interval(3, 3))

        Assert.assertEquals(PitchClass(PitchLetter.F, Accidental(-1)), result)
    }

    @Test
    fun `transpose eb down (yes, down) to f#`() {
        val eFlat = PitchClass(PitchLetter.E, Accidental(-1))

        val result = eFlat.transpose(Interval(-6, -9))

        Assert.assertEquals(PitchClass(PitchLetter.F, Accidental(1)), result)
    }

    @Test
    fun `transpose c down to b##`() {
        val bDoubleSharp = c().transpose(Interval(-1, 1))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(2)), bDoubleSharp)
    }

    @Test
    fun `transpose b## up to c`() {
        val bDoubleSharp = PitchClass(PitchLetter.B, Accidental(2))

        val result = bDoubleSharp.transpose(Interval(1, -1))

        Assert.assertEquals(c(), result)
    }

    @Test
    fun `transpose gb down to eb`() {
        val gb = PitchClass(PitchLetter.G, Accidental(-1))

        val result = gb.transpose(Interval(-2, -3))

        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental(-1)), result)
    }

    @Test
    fun `integerValue c#`() {
        val cSharp = PitchClass(PitchLetter.C, Accidental(1))

        Assert.assertEquals(1, cSharp.integerValue())
    }

    @Test
    fun `integerValue dbb`() {
        val dDoubleFlat = PitchClass(PitchLetter.D, Accidental(-2))

        Assert.assertEquals(0, dDoubleFlat.integerValue())
    }

    @Test
    fun `integerValue f##`() {
        val fDoubleSharp = PitchClass(PitchLetter.F, Accidental(2))

        Assert.assertEquals(7, fDoubleSharp.integerValue())
    }

    @Test
    fun `integerValue b##`() {
        val bDoubleSharp = PitchClass(PitchLetter.B, Accidental(2))

        Assert.assertEquals(1, bDoubleSharp.integerValue())
    }

    private fun c() = PitchClass(PitchLetter.C)
    private fun cSharp() = PitchClass(PitchLetter.C, Accidental(1))
}