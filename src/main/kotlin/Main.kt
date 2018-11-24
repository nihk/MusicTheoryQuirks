import kotlin.math.pow

fun main(args: Array<String>) {
    val minor2nd = Interval(1, 1)
    val major2nd = Interval(1, 2)

    val majorScaleIntervals = listOf(major2nd, major2nd, minor2nd, major2nd, major2nd, major2nd)
    val c4 = Pitch(PitchClass(PitchLetter.C), 4)

    val cMajorScale = mutableListOf(c4)

    val result = mutableListOf<Int>()
    val multipliers = listOf(1, 2, 3, 4, 5)
    var n = 10
    multipliers.forEach {
        n *= it
        result.add(n)
    }

    println(result)
    // 1, 2, 3, 4, 5
    // 10

    // result: 10, 20, 60, 240, 1200


    val eFlat0 = 38.8909
    val eFlat = (0..8).map { eFlat0 * 2f.pow(it) }
    println(eFlat[2])  // 155.5636

    majorScaleIntervals.fold(c4) { pitch, interval ->
        pitch.transpose(interval).also { cMajorScale.add(it) }
    }

    println(cMajorScale)

    println(PitchLetter.C)
}