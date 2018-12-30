import kotlin.math.abs

inline class Accidental(val modifier: Int) {

    override fun toString() = modifier.let {
        when {
            it < 0 -> "♭".repeat(abs(it))
            it > 0 -> "♯".repeat(it)
            else -> ""  // Implicit natural
        }
    }
}