import kotlin.math.abs

data class Accidental(val modifier: Int) {

    override fun toString() = when {
        modifier < 0 -> "b".repeat(abs(modifier))
        modifier > 0 -> "#".repeat(modifier)
        else -> ""  // Implicit natural
    }
}