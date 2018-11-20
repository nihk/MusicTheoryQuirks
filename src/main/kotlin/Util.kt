import kotlin.math.min

fun Int.modulo(universe: Int): Int {
    var n = this
    while (n < universe) {
        n += universe
    }

    return n % universe
}

fun Int.mod12() = modulo(PITCH_CLASS_UNIVERSE_SIZE)

const val PITCH_CLASS_UNIVERSE_SIZE = 12

fun shortestDistance(from: Int, to: Int, universe: Int) =
    min(
        (from - to).modulo(universe),
        (to - from).modulo(universe)
    )

fun shortestDistanceDirectional(from: Int, to: Int, universe: Int) =
    shortestDistance(from, to, universe).let {
        if ((from - it).modulo(universe) == to) {
            -it
        } else {
            it
        }
    }