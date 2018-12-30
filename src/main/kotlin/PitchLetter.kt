enum class PitchLetter(
    val integerValue: Int
) : Transposable {

    A(9), B(11), C(0), D(2), E(4), F(5), G(7);

    override fun transpose(interval: Interval): PitchLetter =
        with(values()) {
            val modLetterDistance = interval.letterDistance.modulo(size)
            val key = (ordinal + modLetterDistance).modulo(size)
            return get(key)
        }

    fun next() = transpose(Interval(1, 0))

    fun previous() = transpose(Interval(-1, 0))
}