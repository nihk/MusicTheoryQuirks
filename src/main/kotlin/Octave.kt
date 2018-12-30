inline class Octave(private val value: UInt) {

    operator fun plus(increment: UInt): Octave = Octave(value + increment)
    operator fun minus(decrement: UInt): Octave = Octave(value - decrement)

    override fun toString() = "$value"
}