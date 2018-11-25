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
}