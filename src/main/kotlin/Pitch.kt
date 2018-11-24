data class Pitch(
    val pitchClass: PitchClass,
    val octave: Int
) {

    fun transpose(interval: Interval): Pitch {
        val fromPc = pitchClass
        val toPc = fromPc.transpose(interval)

        val normalizedIntegerDistance =
            fromPc.accidental.modifier - toPc.accidental.modifier + interval.integerDistance
        val appliedNormalizedIntegerDistance = fromPc.pitchLetter.integerValue + normalizedIntegerDistance
        val isEvenlyDivisible = normalizedIntegerDistance.rem(PITCH_CLASS_UNIVERSE_SIZE) == 0

        val toOctave = when {
            normalizedIntegerDistance.isNegative()
                    && !isEvenlyDivisible
                    && appliedNormalizedIntegerDistance <= PitchLetter.C.integerValue -> octave - 1
            normalizedIntegerDistance.isPositive()
                    && !isEvenlyDivisible
                    && appliedNormalizedIntegerDistance >= PitchLetter.B.integerValue -> octave + 1
            else -> octave
        } + normalizedIntegerDistance / PITCH_CLASS_UNIVERSE_SIZE

        return Pitch(toPc, toOctave)
    }

    fun toScale(intervals: List<Interval>): List<Pitch> {
        val scale = mutableListOf(this)

        intervals.fold(this) { pitch, interval ->
            pitch.transpose(interval)
                .also { scale.add(it) }
        }

        return scale
    }

    override fun toString() = "$pitchClass$octave"
}