data class Pitch(
    val pitchClass: PitchClass,
    val octave: Int
) {

    operator fun plus(interval: Interval) = transpose(interval)

    fun transpose(interval: Interval): Pitch {
        val newPc = pitchClass.transpose(interval)
        val reconciledLetterDistance = if (
            interval.letterDistance.isPositive() && interval.integerDistance.isNegative()
            ||
            interval.letterDistance.isNegative() && interval.integerDistance.isPositive()
        ) {
            interval.letterDistance.invertDirectionModulo(PitchLetter.values().size)
        } else {
            interval.letterDistance
        }

//        val newOctave = when {
//            pitchClass.value() + interval.integerDistance < PitchLetter.C.value -> octave - 1
//            pitchClass.value() + interval.integerDistance > PitchLetter.B.value -> octave + 1
//            else -> octave
//        } //+ interval.integerDistance / PITCH_CLASS_UNIVERSE_SIZE

        val newOctave = when {
            interval.integerDistance.isNegative() &&
                    pitchClass.value() - newPc.value() < PitchLetter.C.value -> octave - 1
            interval.integerDistance.isPositive() &&
                    pitchClass.value() + newPc.value() > PitchLetter.B.value -> octave + 1
            else -> octave
        } + interval.integerDistance / PITCH_CLASS_UNIVERSE_SIZE

        return Pitch(newPc, newOctave)
    }
}