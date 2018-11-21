import org.junit.Assert.*
import org.junit.Test

class PitchLetterTest {

    @Test
    fun `simple transposition`() {
        assertEquals(PitchLetter.C, PitchLetter.A.transpose(2))
    }

    @Test
    fun `transpose beyond the length of the last pitch letter enum`() {
        assertEquals(PitchLetter.B, PitchLetter.E.transpose(4))
    }

    @Test
    fun `transpose with negative value`() {
        assertEquals(PitchLetter.B, PitchLetter.C.transpose(-1))
    }
}