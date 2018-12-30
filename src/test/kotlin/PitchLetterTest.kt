import org.junit.Assert.*
import org.junit.Test

class PitchLetterTest {

    @Test
    fun `simple transposition`() {
        assertEquals(PitchLetter.C, PitchLetter.A.transpose(Interval(2, 0)))
    }

    @Test
    fun `transpose beyond the length of the last pitch letter enum`() {
        assertEquals(PitchLetter.B, PitchLetter.E.transpose(Interval(4, 0)))
    }

    @Test
    fun `transpose with negative value`() {
        assertEquals(PitchLetter.B, PitchLetter.C.transpose(Interval(-1, 0)))
    }

    @Test
    fun `distance G to F descending`() {
        assertEquals(-2, PitchLetter.G.integerDistance(PitchLetter.F, Direction.Descending))
    }

    @Test
    fun `distance G to F ascending`() {
        assertEquals(10, PitchLetter.G.integerDistance(PitchLetter.F, Direction.Ascending))
    }

    @Test
    fun `distance B to C descending`() {
        assertEquals(-11, PitchLetter.B.integerDistance(PitchLetter.C, Direction.Descending))
    }

    @Test
    fun `distance B to C ascending`() {
        assertEquals(1, PitchLetter.B.integerDistance(PitchLetter.C, Direction.Ascending))
    }

    @Test
    fun `distance C to B descending`() {
        assertEquals(-1, PitchLetter.C.integerDistance(PitchLetter.B, Direction.Descending))
    }

    @Test
    fun `distance C to B ascending`() {
        assertEquals(11, PitchLetter.C.integerDistance(PitchLetter.B, Direction.Ascending))
    }
}