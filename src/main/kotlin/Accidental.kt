data class Accidental(val modifier: Int) {

    operator fun plus(n: Int) = copy(modifier = modifier + n)

    operator fun minus(n: Int) = plus(-n)

    fun sign() = when {
        modifier < 0 -> AccidentalSign.FLAT
        modifier > 0 -> AccidentalSign.SHARP
        else -> AccidentalSign.NATURAL
    }
}