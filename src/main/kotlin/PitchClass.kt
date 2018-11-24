data class PitchClass(
    val pitchLetter: PitchLetter,
    val accidental: Accidental = Accidental(0)
) {

    fun integerValue() =
        (pitchLetter.integerValue + accidental.modifier).mod12()

    fun transpose(interval: Interval): PitchClass {
        val newPitchLetter = pitchLetter.transpose(interval.letterDistance)
        val newAccidental = shortestDistanceDirectional(newPitchLetter.integerValue,
            (integerValue() + interval.integerDistance).mod12(), PITCH_CLASS_UNIVERSE_SIZE)

        return PitchClass(newPitchLetter, Accidental(newAccidental))
    }

    override fun toString(): String {
        return pitchLetter.toString() + accidental.toString()
    }
}