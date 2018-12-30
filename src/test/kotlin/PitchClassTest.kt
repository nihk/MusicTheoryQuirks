import org.junit.Assert
import org.junit.Test

class PitchClassTest {

    @Test
    fun `transpose c up to c sharp`() {
        val cSharp = c().transpose(Interval(0, 1))

        Assert.assertEquals(PitchClass(PitchLetter.C, Accidental(1)), cSharp)
    }

    @Test
    fun `transpose c up to d flat`() {
        val dFlat = c().transpose(Interval(1, 1))

        Assert.assertEquals(PitchClass(PitchLetter.D, Accidental(-1)), dFlat)
    }

    @Test
    fun `transpose c to d natural`() {
        val d = c().transpose(Interval(1, 2))

        Assert.assertEquals(PitchClass(PitchLetter.D), d)
    }

    @Test
    fun `transpose c up to e flat`() {
        val eFlat = c().transpose(Interval(2, 3))

        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental(-1)), eFlat)
    }

    @Test
    fun `transpose c up to b`() {
        val b = c().transpose(Interval(6, 11))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(0)), b)
    }

    @Test
    fun `transpose c down to b flat`() {
        val bFlat = c().transpose(Interval(-1, -2))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(-1)), bFlat)
    }

    @Test
    fun `transpose c up to b flat`() {
        val bFlat = c().transpose(Interval(6, 10))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(-1)), bFlat)
    }

    @Test
    fun `transpose c down to b`() {
        val b = c().transpose(Interval(-1, -1))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(0)), b)
    }

    @Test
    fun `transpose b up to c`() {
        val c = PitchClass(PitchLetter.B).transpose(Interval(1, 1))

        Assert.assertEquals(c(), c)
    }

    @Test
    fun `transpose c up to c#######`() {
        val result = c().transpose(Interval(0, 7))

        val expected = PitchClass(PitchLetter.C, Accidental(7))
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d up to f#######`() {
        val d = PitchClass(PitchLetter.D)

        val result = d.transpose(Interval(2, 10))

        val expected = PitchClass(PitchLetter.F, Accidental(7))
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d up to f########`() {
        val d = PitchClass(PitchLetter.D)

        val result = d.transpose(Interval(2, 11))

        val expected = PitchClass(PitchLetter.F, Accidental(8))
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose c down to Bbbbbbbb`() {
        val b7Flats = c().transpose(Interval(-1, -8))

        val expected = PitchClass(PitchLetter.B, Accidental(-7))

        Assert.assertEquals(expected, b7Flats)
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
    fun `transpose c down to b#`() {
        val bSharp = c().transpose(Interval(-1, 0))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(1)), bSharp)
    }

    @Test
    fun `transpose cb down to b#`() {
        val cFlat = PitchClass(PitchLetter.C, Accidental(-1))

        val result = cFlat.transpose(Interval(-1, 1))

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental(1)), result)
    }

    @Test
    fun `transpose fb down to e#`() {
        val fFlat = PitchClass(PitchLetter.F, Accidental(-1))

        val result = fFlat.transpose(Interval(-1, 1))

        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental(1)), result)
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
    fun `transpose b# up to cbbb positive letterDistance`() {
        val bSharp = PitchClass(PitchLetter.B, Accidental(1))

        val result = bSharp.transpose(Interval(1, -3))

        val expected = PitchClass(PitchLetter.C, Accidental(-3))
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose f# down to f#`() {
        val fSharp = PitchClass(PitchLetter.F, Accidental(1))

        val result = fSharp.transpose(Interval(0, -12))

        val expected = fSharp
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose f# to f##`() {
        val fSharp = PitchClass(PitchLetter.F, Accidental(1))

        val result = fSharp.transpose(Interval(0, 1))

        val expected = PitchClass(PitchLetter.F, Accidental(2))
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose f# down to f`() {
        val fSharp = PitchClass(PitchLetter.F, Accidental(1))

        val result = fSharp.transpose(Interval(0, -1))

        val expected = PitchClass(PitchLetter.F)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose b up to dbbbb`() {
        val b = PitchClass(PitchLetter.B)

        val result = b.transpose(Interval(2, -1))

        val expected = PitchClass(PitchLetter.D, Accidental(-4))
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose c# to b### positive letterDistance`() {
        val cSharp = PitchClass(PitchLetter.C, Accidental(1))

        val result = cSharp.transpose(Interval(-1, 1))

        val expected = PitchClass(PitchLetter.B, Accidental(3))
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose c# to b### negative letterDistance`() {
        val cSharp = PitchClass(PitchLetter.C, Accidental(1))

        val result = cSharp.transpose(Interval(-1, 1))

        val expected = PitchClass(PitchLetter.B, Accidental(3))
        Assert.assertEquals(expected, result)
    }

    private fun c() = PitchClass(PitchLetter.C)
    private fun cSharp() = PitchClass(PitchLetter.C, Accidental(1))
}