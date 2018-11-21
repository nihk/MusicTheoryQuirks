// Both of these fields are directional, i.e. a distance of -1 means moving left/counter-clockwise
// in pitch/pitch-class space, respectively. There's no guarantee as to what the output of a transposition will
// be if disregard this direction.
data class Interval(
    val letterDistance: Int,
    val integerDistance: Int
) {

    operator fun unaryMinus(): Interval = Interval(letterDistance = -letterDistance, integerDistance = -integerDistance)
}