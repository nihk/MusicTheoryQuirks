import org.junit.Assert
import org.junit.Test

class PitchTest {

    @Test
    fun `transpose d4 up to f#4`() {
        val d4 = Pitch(PitchClass(PitchLetter.D), 4)

        val result = d4.transpose(Interval(2, 4))

        val expected = Pitch(PitchClass(PitchLetter.F, Accidental(1)), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose gb5 down to eb5`() {
        val g5 = Pitch(PitchClass(PitchLetter.G, Accidental(-1)), 5)

        val result = g5.transpose(Interval(-2, -3))

        val expected = Pitch(PitchClass(PitchLetter.E, Accidental(-1)), 5)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d#3 down to bb2`() {
        val dSharp3 = Pitch(PitchClass(PitchLetter.D, Accidental(1)), 3)

        val result = dSharp3.transpose(Interval(-2, -5))

        val expected = Pitch(PitchClass(PitchLetter.B, Accidental(-1)), 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose c5 up to c#6`() {
        val c5 = Pitch(PitchClass(PitchLetter.C), 5)

        val result = c5.transpose(Interval(0, 13))

        val expected = Pitch(PitchClass(PitchLetter.C, Accidental(1)), 6)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d4 to identity`() {
        val d4 = Pitch(PitchClass(PitchLetter.D), 4)

        val result = d4.transpose(Interval(0, 0))

        Assert.assertEquals(d4, result)
    }

    @Test
    fun `transpose c#4 down to b###3`() {
        val cSharp4 = Pitch(PitchClass(PitchLetter.C, Accidental(1)), 4)

        val result = cSharp4.transpose(Interval(-1, 1))

        val expected = Pitch(PitchClass(PitchLetter.B, Accidental(3)), 3)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose f#5 down to f#2`() {
        val fSharp5 = Pitch(PitchClass(PitchLetter.F, Accidental(1)), 5)

        val result = fSharp5.transpose(Interval(0, -36))

        val expected = Pitch(PitchClass(PitchLetter.F, Accidental(1)), 2)
        Assert.assertEquals(expected, result)
    }
}