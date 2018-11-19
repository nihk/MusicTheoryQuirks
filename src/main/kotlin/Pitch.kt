data class Pitch(
    val pitchClass: PitchClass,
    val octave: Int
) {

    operator fun plus(interval: Interval) = transpose(interval)

    fun transpose(interval: Interval): Pitch {
        val newPc = pitchClass.transpose(interval)
        TODO()
    }
}