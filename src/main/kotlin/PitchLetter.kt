enum class PitchLetter {
    A, B, C, D, E, F, G;

    fun transpose(letterDistance: Int): PitchLetter = with(values()) {
        return get((ordinal + letterDistance) % size)
    }
}