const val PITCH_CLASS_UNIVERSE_SIZE = 12

fun Int.modulo(universe: Int): Int {
    var n = this
    while (n < universe) {
        n += universe
    }

    return n % universe
}

fun Int.mod12() = modulo(PITCH_CLASS_UNIVERSE_SIZE)