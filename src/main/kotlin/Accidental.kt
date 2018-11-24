import kotlin.math.abs

data class Accidental(val modifier: Int) {

    override fun toString() = modifier.let {
        when {
            it < 0 -> "b".repeat(abs(it))
            it > 0 -> "#".repeat(it)
            else -> ""  // Implicit natural
        }
    }
}