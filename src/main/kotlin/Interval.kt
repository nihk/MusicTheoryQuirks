class Interval(
    val letterDistance: Int,
    val integerDistance: Int
) {

    operator fun unaryMinus(): Interval = Interval(letterDistance = -letterDistance, integerDistance = -integerDistance)
}