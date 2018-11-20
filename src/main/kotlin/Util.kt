import kotlin.math.min
import kotlin.math.sign

fun Int.modulo(universe: Int): Int {
    var n = this
    while (n < universe) {
        n += universe
    }

    return n % universe
}

fun Int.mod12() = modulo(PITCH_CLASS_UNIVERSE_SIZE)

const val PITCH_CLASS_UNIVERSE_SIZE = 12

fun Int.isNegative() =
        sign == -1

fun Int.isPositive() =
        sign == 1

fun Int.invertDirectionModulo(universe: Int): Int {
    var result = this
    if (this < 0) {
        while (result < 0) result += universe
    } else {
        while (result > 0) result -= universe
    }
    return result
}

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