data class Interval(
    val letterDistance: Int,
    val integerDistance: Int
) {

    operator fun unaryMinus(): Interval = copy(letterDistance = -letterDistance, integerDistance = -integerDistance)
}