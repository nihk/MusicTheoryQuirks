data class Pitch(
    val pitchClass: PitchClass,
    val octave: Int
) {
    fun transpose(interval: Interval): Pitch {
        TODO()
    }
}