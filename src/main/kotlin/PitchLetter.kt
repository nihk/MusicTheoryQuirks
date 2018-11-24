enum class PitchLetter(val integerValue: Int) {
    A(9), B(11), C(0), D(2), E(4), F(5), G(7);

    fun transpose(letterDistance: Int): PitchLetter =
        with(values()) {
            val modLetterDistance = letterDistance.modulo(size)
            val key = (ordinal + modLetterDistance).modulo(size)
            return get(key)
        }
}