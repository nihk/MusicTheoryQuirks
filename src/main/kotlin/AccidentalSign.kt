enum class AccidentalSign(val modifier: Int) {
    FLAT(-1), NATURAL(0), SHARP(1);

    operator fun plus(n: Int): AccidentalSign {
        val newModifier = modifier + n

        return when {
            newModifier < 0 -> FLAT
            newModifier > 0 -> SHARP
            else -> NATURAL
        }
    }

    operator fun minus(n : Int): AccidentalSign = plus(-n)
}