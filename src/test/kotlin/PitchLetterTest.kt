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
    fun `simple add value`() {
        val added = PitchLetter.C.addValue(2)

        assertEquals(2, added)
    }

    @Test
    fun `modulo add value`() {
        val added = PitchLetter.B.addValue(1)

        assertEquals(0, added)
    }
}