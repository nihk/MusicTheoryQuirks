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
    fun `transpose c# to fb`() {
        val cSharp = PitchClass(PitchLetter.C, Accidental(1))

        val result = cSharp.transpose(Interval(3, 3))

        Assert.assertEquals(PitchClass(PitchLetter.F, Accidental(-1)), result)
    }

    @Test
    fun `transpose eb down to f#`() {
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
    fun `value c#`() {
        val cSharp = PitchClass(PitchLetter.C, Accidental(1))

        Assert.assertEquals(1, cSharp.value())
    }

    @Test
    fun `value dbb`() {
        val dDoubleFlat = PitchClass(PitchLetter.D, Accidental(-2))

        Assert.assertEquals(0, dDoubleFlat.value())
    }

    @Test
    fun `value f##`() {
        val fDoubleSharp = PitchClass(PitchLetter.F, Accidental(2))

        Assert.assertEquals(7, fDoubleSharp.value())
    }

    private fun c() = PitchClass(PitchLetter.C)
}