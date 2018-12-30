import kotlin.math.abs
import kotlin.math.min
import kotlin.math.sign

const val PITCH_CLASS_UNIVERSE_SIZE = 12

fun Int.modulo(universe: Int): Int {
    var n = this
    while (n < universe) {
        n += universe
    }

    return n % universe
}

fun Int.mod12() = modulo(PITCH_CLASS_UNIVERSE_SIZE)

fun Int.isNegative() =
        sign == -1

fun Int.isPositive() =
        sign == 1

fun shortestDistance(from: Int, to: Int, universe: Int) =
    min(
        from.minus(to).modulo(universe),
        to.minus(from).modulo(universe)
    )

fun shortestDistanceDirectional(from: Int, to: Int, universe: Int) =
    shortestDistance(from, to, universe).let {
        if (from.minus(it).modulo(universe) == to) {
            -it
        } else {
            it
        }
    }