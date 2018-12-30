data class Pitch(
    val pitchClass: PitchClass,
    val octave: Octave
) : Transposable {

    override fun transpose(interval: Interval): Pitch {
        val fromPc = pitchClass
        val toPc = fromPc.transpose(interval)

        val normalizedIntegerDistance =
            fromPc.accidental.modifier - toPc.accidental.modifier + interval.integerDistance
        val appliedNormalizedIntegerDistance = fromPc.pitchLetter.integerValue + normalizedIntegerDistance
        val isEvenlyDivisible = normalizedIntegerDistance.rem(PITCH_CLASS_UNIVERSE_SIZE) == 0

        val toOctave: Octave = when {
            normalizedIntegerDistance < 0
                    && !isEvenlyDivisible
                    && appliedNormalizedIntegerDistance < PitchLetter.C.integerValue -> octave - 1u
            normalizedIntegerDistance >= 0
                    && !isEvenlyDivisible
                    && appliedNormalizedIntegerDistance > PitchLetter.B.integerValue -> octave + 1u
            else -> octave
        } + (normalizedIntegerDistance / PITCH_CLASS_UNIVERSE_SIZE).toUInt()

        return Pitch(toPc, toOctave)
    }

    override fun toString() = "$pitchClass$octave"
}