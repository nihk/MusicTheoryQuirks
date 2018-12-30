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

    fun integerDistance(other: PitchLetter, direction: Direction) = when (direction) {
        Direction.Ascending -> other.integerValue - this.integerValue
        Direction.Descending -> this.integerValue - other.integerValue
    }.mod12() * direction.sign
}