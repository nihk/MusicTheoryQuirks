import org.junit.Assert
import org.junit.Test

class PitchTest {

    @Test
    fun `transpose b3 up to c4 positive letterDistance`() {
        val b3 = Pitch(PitchClass(PitchLetter.B), 3)

        val result = b3.transpose(Interval(1, 1))

        val expected = Pitch(PitchClass(PitchLetter.C), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose b3 up to c4 negative letterDistance`() {
        val b3 = Pitch(PitchClass(PitchLetter.B), 3)

        val result = b3.transpose(Interval(-6, 1))

        val expected = Pitch(PitchClass(PitchLetter.C), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d4 up to f#4 positive letterDistance`() {
        val d4 = Pitch(PitchClass(PitchLetter.D), 4)

        val result = d4.transpose(Interval(2, 4))

        val expected = Pitch(PitchClass(PitchLetter.F, Accidental(1)), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d4 up to f#4 negative letterDistance`() {
        val d4 = Pitch(PitchClass(PitchLetter.D), 4)

        val result = d4.transpose(Interval(-5, 4))

        val expected = Pitch(PitchClass(PitchLetter.F, Accidental(1)), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose gb5 down to eb5 positive letterDistance`() {
        val g5 = Pitch(PitchClass(PitchLetter.G, Accidental(-1)), 5)

        val result = g5.transpose(Interval(5, -3))

        val expected = Pitch(PitchClass(PitchLetter.E, Accidental(-1)), 5)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose gb5 down to eb5 negative letterDistance`() {
        val g5 = Pitch(PitchClass(PitchLetter.G, Accidental(-1)), 5)

        val result = g5.transpose(Interval(-2, -3))

        val expected = Pitch(PitchClass(PitchLetter.E, Accidental(-1)), 5)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d#3 down to bb2 negative letterDistance`() {
        val dSharp3 = Pitch(PitchClass(PitchLetter.D, Accidental(1)), 3)

        val result = dSharp3.transpose(Interval(-2, -5))

        val expected = Pitch(PitchClass(PitchLetter.B, Accidental(-1)), 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose d#3 down to bb2 positive letterDistance`() {
        val dSharp3 = Pitch(PitchClass(PitchLetter.D, Accidental(1)), 3)

        val result = dSharp3.transpose(Interval(5, -5))

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
    fun `transpose c#4 down to b###3 negative letterDistance`() {
        val cSharp4 = Pitch(PitchClass(PitchLetter.C, Accidental(1)), 4)

        val result = cSharp4.transpose(Interval(-1, 1))

        val expected = Pitch(PitchClass(PitchLetter.B, Accidental(3)), 3)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose c#4 down to b###3 positive letterDistance`() {
        val cSharp4 = Pitch(PitchClass(PitchLetter.C, Accidental(1)), 4)

        val result = cSharp4.transpose(Interval(6, 1))

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

    @Test
    fun `transpose c4 down to c2`() {
        val c4 = Pitch(PitchClass(PitchLetter.C), 4)

        val result = c4.transpose(Interval(0, -24))

        val expected = Pitch(PitchClass(PitchLetter.C), 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose fb4 down to g2 negative letterDistance`() {
        val fFlat4 = Pitch(PitchClass(PitchLetter.F, Accidental(-1)), 4)

        val result = fFlat4.transpose(Interval(-6, -21))

        val expected = Pitch(PitchClass(PitchLetter.G), 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose fb4 down to g2 positive letterDistance`() {
        val fFlat4 = Pitch(PitchClass(PitchLetter.F, Accidental(-1)), 4)

        val result = fFlat4.transpose(Interval(1, -21))

        val expected = Pitch(PitchClass(PitchLetter.G), 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose b#3 up to cbbb4 positive letterDistance`() {
        val bSharp3 = Pitch(PitchClass(PitchLetter.B, Accidental(1)), 3)

        val result = bSharp3.transpose(Interval(1, -3))

        val expected = Pitch(PitchClass(PitchLetter.C, Accidental(-3)), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose b#3 up to cbbb4 negative letterDistance`() {
        val bSharp3 = Pitch(PitchClass(PitchLetter.B, Accidental(1)), 3)

        val result = bSharp3.transpose(Interval(-6, -3))

        val expected = Pitch(PitchClass(PitchLetter.C, Accidental(-3)), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose b3 up to dbbbb4 positive letterDistance`() {
        val b3 = Pitch(PitchClass(PitchLetter.B), 3)

        val result = b3.transpose(Interval(2, -1))

        val expected = Pitch(PitchClass(PitchLetter.D, Accidental(-4)), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose dbbbb4 down to b3 negative letterDistance`() {
        val dQuadrupleFlat4 = Pitch(PitchClass(PitchLetter.D, Accidental(-4)), 4)

        val result = dQuadrupleFlat4.transpose(Interval(-2, 1))

        val expected = Pitch(PitchClass(PitchLetter.B), 3)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose b3 up to dbbbb4 negative letterDistance`() {
        val b3 = Pitch(PitchClass(PitchLetter.B), 3)

        val result = b3.transpose(Interval(-5, -1))

        val expected = Pitch(PitchClass(PitchLetter.D, Accidental(-4)), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose g5 up to a5`() {
        val g5 = Pitch(PitchClass(PitchLetter.G), 5)

        val result = g5.transpose(Interval(1, 2))

        val expected = Pitch(PitchClass(PitchLetter.A), 5)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose bb4 up to b4`() {
        val bFlat4 = Pitch(PitchClass(PitchLetter.B, Accidental(-1)), 4)

        val result = bFlat4.transpose(Interval(0, 1))

        val expected = Pitch(PitchClass(PitchLetter.B), 4)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `transpose c4 up to c5`() {
        val c4 = Pitch(PitchClass(PitchLetter.C), 4)

        val result = c4.transpose(Interval(0, 12))

        val expected = Pitch(PitchClass(PitchLetter.C), 5)
        Assert.assertEquals(expected, result)
    }
}