sealed class Direction(val sign: Int) {
    object Descending : Direction(-1)
    object Ascending : Direction(+1)
}