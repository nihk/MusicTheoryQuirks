enum class PitchLetter(val value: Int) {
    A(9), B(11), C(0), D(2), E(4), F(5), G(7);

    operator fun plus(letterDistance: Int) = transpose(letterDistance)

    fun transpose(letterDistance: Int): PitchLetter = with(values()) {
        val modLetterDistance = letterDistance.modulo(size)
        val key = (ordinal + modLetterDistance) % size
        return get(key)
    }
}