enum class PitchLetter(val value: Int) {
    A(9), B(11), C(0), D(2), E(4), F(5), G(7);

    operator fun plus(letterDistance: Int) = transpose(letterDistance)

    fun transpose(letterDistance: Int): PitchLetter = with(values()) {
        val positiveDistance = (letterDistance + size) % size
        val key = (ordinal + positiveDistance) % size
        return get(key)
    }

    // TODO: Remove this
    fun addValue(value: Int) =
        (this.value + value) % Constants.UNIVERSE
}