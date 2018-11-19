data class PitchClass(
    val pitchLetter: PitchLetter,
    val accidental: Accidental = Accidental(0)
) {

    operator fun plus(interval: Interval) = transpose(interval)

    operator fun minus(interval: Interval) = transpose(-interval)

    operator fun inc() = copy(accidental = accidental + 1)

    operator fun dec() = copy(accidental = accidental - 1)

    fun value() = pitchLetter.value + accidental.modifier

    fun transpose(interval: Interval): PitchClass {
        val newPitchLetter = pitchLetter.transpose(interval.letterDistance)
        val modIntegerDistance = (interval.integerDistance + Constants.UNIVERSE) % Constants.UNIVERSE
        val accidentalModifier = value() + modIntegerDistance - newPitchLetter.value
        val newAccidental = Accidental(accidentalModifier)
        return PitchClass(newPitchLetter, newAccidental)
    }
}