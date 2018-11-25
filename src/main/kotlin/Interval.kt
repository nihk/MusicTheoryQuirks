data class Interval(
    val letterDistance: Int,
    val integerDistance: Int
) {

    operator fun unaryMinus() = copy(-letterDistance, -integerDistance)

    companion object {
        val unison = Interval(0, 0)
        val semitone = Interval(0, 1)
        val minor2nd = Interval(1, 1)
        val major2nd = Interval(1, 2)
        val minor3rd = Interval(2, 3)
        val major3rd = Interval(2, 4)
        val perfect4th = Interval(3, 5)
        val augmented4th = Interval(3, 6)
        val diminished5th = Interval(4, 6)
        val perfect5th = Interval(4, 7)
        val minor6th = Interval(5, 8)
        val major6th = Interval(5, 9)
        val minor7th = Interval(6, 10)
        val major7th = Interval(6, 11)
        val octave = Interval(0, 12)

        val majorScale = listOf(major2nd, major2nd, minor2nd, major2nd, major2nd, major2nd, minor2nd)
        val minorScale = listOf(major2nd, minor2nd, major2nd, major2nd, minor2nd, major2nd, major2nd)
        val majorPentatonicScale = listOf(major2nd, major2nd, minor3rd, major2nd)
        val minorPentatonicScale = listOf(minor3rd, major2nd, major2nd, minor3rd)
        val wholeToneScale = listOf(major2nd, major2nd, major2nd, major2nd, major2nd)
        val chromaticScale = listOf(minor2nd, semitone, minor2nd, semitone, minor2nd, semitone, minor2nd,
            semitone, minor2nd, minor2nd, semitone)
        val majorOctatonicScale = listOf(major2nd, minor2nd, major2nd, minor2nd, major2nd, semitone, major2nd)
        val minorOctatonicScale = listOf(minor2nd, major2nd, semitone, major2nd, minor2nd, major2nd, minor2nd)
        val circleOfFifths = listOf(perfect5th, -perfect4th, perfect5th, -perfect4th, perfect5th, -perfect4th,
            perfect5th, -perfect4th, perfect5th, -perfect4th, perfect5th)

        val diminishedTriad = listOf(minor3rd, minor3rd)
        val minorTriad = listOf(minor3rd, major3rd)
        val majorTriad = listOf(major3rd, minor3rd)
        val augmentedTriad = listOf(major3rd, major3rd)
    }
}