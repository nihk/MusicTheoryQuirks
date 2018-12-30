data class PitchClass(
    val pitchLetter: PitchLetter,
    val accidental: Accidental = Accidental(0)
) : Transposable {

    override fun transpose(interval: Interval): PitchClass {
        val newPitchLetter = pitchLetter.transpose(interval)
        val intervalDirection = if (interval.letterDistance < 0) Direction.Descending else Direction.Ascending
        val distanceToNewPitchLetter = pitchLetter.integerDistance(newPitchLetter, intervalDirection) - accidental.modifier
        val remainingDistance = interval.integerDistance.rem(PITCH_CLASS_UNIVERSE_SIZE) - distanceToNewPitchLetter

        return PitchClass(newPitchLetter, Accidental(remainingDistance))
    }

    override fun toString() = "$pitchLetter$accidental"
}