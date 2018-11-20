class Interval(
    letterDistance: Int,
    integerDistance: Int
) {

    val letterDistance = letterDistance.modulo(PitchLetter.values().size)
    val integerDistance = integerDistance.mod12()

    operator fun unaryMinus(): Interval = Interval(letterDistance = -letterDistance, integerDistance = -integerDistance)
}