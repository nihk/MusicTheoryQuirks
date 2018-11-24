data class Pitch(
    val pitchClass: PitchClass,
    val octave: Int
) {

    fun transpose(interval: Interval): Pitch {
        val fromPc = pitchClass
        val toPc = fromPc.transpose(interval)

        val normalizedIntegerDistance =
            fromPc.accidental.modifier - toPc.accidental.modifier + interval.integerDistance

        val isEvenlyDivisible = normalizedIntegerDistance.rem(PITCH_CLASS_UNIVERSE_SIZE) == 0

        val toOctave = when {
            normalizedIntegerDistance.isNegative()
                    && !isEvenlyDivisible
                    && fromPc.pitchLetter.integerValue + normalizedIntegerDistance <= PitchLetter.C.integerValue -> octave - 1
            normalizedIntegerDistance.isPositive()
                    && !isEvenlyDivisible
                    && fromPc.pitchLetter.integerValue + normalizedIntegerDistance >= PitchLetter.B.integerValue -> octave + 1
            else -> octave
        } + normalizedIntegerDistance / PITCH_CLASS_UNIVERSE_SIZE

        return Pitch(toPc, toOctave)
    }

    override fun toString(): String {
        return pitchClass.toString() + octave
    }
}