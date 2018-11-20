data class Pitch(
    val pitchClass: PitchClass,
    val octave: Int
) {

    operator fun plus(interval: Interval) = transpose(interval)

    fun transpose(interval: Interval): Pitch {
        val newPc = pitchClass.transpose(interval)

        val newOctave = when {
            interval.letterDistance.isNegative()
                    && pitchClass.value() - newPc.value() < PitchLetter.C.value -> octave - 1
            interval.letterDistance.isPositive()
                    && pitchClass.value() + newPc.value() > PitchLetter.B.value -> octave + 1
            else -> octave
        } + interval.integerDistance / PITCH_CLASS_UNIVERSE_SIZE

        return Pitch(newPc, newOctave)
    }
}