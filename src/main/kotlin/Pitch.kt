data class Pitch(
    val pitchClass: PitchClass,
    val octave: Int
) {

    operator fun plus(interval: Interval) = transpose(interval)

    fun transpose(interval: Interval): Pitch {
        val from = pitchClass
        val to = from.transpose(interval)

        val normalizedIntegerDistance =
            from.accidental.modifier - to.accidental.modifier + interval.integerDistance

        val isEvenlyDivisible = normalizedIntegerDistance.rem(PITCH_CLASS_UNIVERSE_SIZE) == 0

        val newOctave = when {
            normalizedIntegerDistance.isNegative()
                    && !isEvenlyDivisible
                    && from.pitchLetter.integerValue - to.pitchLetter.integerValue <= PitchLetter.C.integerValue -> octave - 1
            normalizedIntegerDistance.isPositive()
                    && !isEvenlyDivisible
                    && from.pitchLetter.integerValue + to.pitchLetter.integerValue >= PitchLetter.B.integerValue -> octave + 1
            else -> octave
        } + normalizedIntegerDistance / PITCH_CLASS_UNIVERSE_SIZE

        return Pitch(to, newOctave)
    }
}