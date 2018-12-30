import kotlin.math.abs
import kotlin.math.absoluteValue

data class PitchClass(
    val pitchLetter: PitchLetter,
    val accidental: Accidental = Accidental(0)
) : Transposable {

    fun integerValue() = pitchLetter.integerValue.plus(accidental.modifier).mod12()

    override fun transpose(interval: Interval): PitchClass {
        val newPitchLetter = pitchLetter.transpose(interval)
        val currIntegerValue = integerValue()
        val desiredIntegerValue = currIntegerValue + interval.integerDistance

        // I need to get the integer distance from this.integerValue to newPitchLetter, but I need to take
        // into account the direction it goes

        // I need the distance from newPitchLetter.integerValue to desiredIntegerValue, but in the right direction

        // Lets get the integer distance from this.integerValue() to newPitchLetter.integerValue using directional signed integer
        var distance = 0
        var copy = this.pitchLetter

        while (copy != newPitchLetter) {
            if (interval.letterDistance < 0) {
                val prev = copy.previous()
                distance -= shortestDistance(copy.integerValue, prev.integerValue, 12)
                copy = prev
            } else if (interval.letterDistance > 0) {
                val next = copy.next()
                distance += shortestDistance(copy.integerValue, next.integerValue, 12)
                copy = next
            } else {
                break
            }
        }

        distance -= accidental.modifier

        distance -= interval.integerDistance.rem(12)

        var iterationsLeft = distance.absoluteValue

        // Need to factor in direction of interval.pitchLetter. Because for C down to B#, the Interval is (-1, 0).
        // Given PitchLetter B from that, there's no way to know whether B should go up 1 time to B# or down 11 times to Bbbbbbb etc.
        val desiredPitchClass = PitchClass(newPitchLetter)
        var flatDirection = desiredPitchClass
        var sharpDirection = desiredPitchClass

        // TODO: Also count the number of iterations + compare to integer.distance == the original PC value
        while (iterationsLeft --> 0) {
            // TODO: Replace with unary -- and ++
            flatDirection = flatDirection.copy(accidental = Accidental(flatDirection.accidental.modifier - 1))
            sharpDirection = sharpDirection.copy(accidental = Accidental(sharpDirection.accidental.modifier + 1))
        }

        return when {
            flatDirection.integerValue() == desiredIntegerValue.mod12() -> flatDirection
            sharpDirection.integerValue() == desiredIntegerValue.mod12() -> sharpDirection
            else -> error("wtf")
        }
    }

    override fun toString() = "$pitchLetter$accidental"
}