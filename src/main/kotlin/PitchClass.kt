data class PitchClass(
    val pitchLetter: PitchLetter,
    val accidental: Accidental = Accidental(0)
) {

    fun integerValue() = pitchLetter.integerValue.plus(accidental.modifier).mod12()

    fun transpose(interval: Interval): PitchClass {
        val newPitchLetter = pitchLetter.transpose(interval.letterDistance)
        val newAccidental = shortestDistanceDirectional(
            from = newPitchLetter.integerValue,
            to = integerValue().plus(interval.integerDistance).mod12(),
            universe = PITCH_CLASS_UNIVERSE_SIZE
        )

        return PitchClass(newPitchLetter, Accidental(newAccidental))
    }

    override fun toString() = "$pitchLetter$accidental"
}