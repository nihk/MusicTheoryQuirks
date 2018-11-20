data class PitchClass(
    val pitchLetter: PitchLetter,
    val accidental: Accidental = Accidental(0)
) {

    operator fun plus(interval: Interval) = transpose(interval)

    operator fun minus(interval: Interval) = transpose(-interval)

    operator fun inc() = copy(accidental = accidental + 1)

    operator fun dec() = copy(accidental = accidental - 1)

    fun value() = (pitchLetter.value + accidental.modifier).mod12()

    fun transpose(interval: Interval): PitchClass {
        val newPitchLetter = pitchLetter.transpose(interval.letterDistance)
        val accModifier = shortestDistanceDirectional(newPitchLetter.value,
            (value() + interval.integerDistance).mod12(), PITCH_CLASS_UNIVERSE_SIZE)

        return PitchClass(newPitchLetter, Accidental(accModifier))
    }
}