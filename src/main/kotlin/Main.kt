fun main(args: Array<String>) {
    val c4 = Pitch(PitchClass(PitchLetter.C), 4)

    println(c4.toScale(Interval.majorScale))
    println(c4.toScale(Interval.minorScale))
    println(c4.toScale(Interval.majorPentatonicScale))
    println(c4.toScale(Interval.minorPentatonicScale))
    println(c4.toScale(Interval.wholeToneScale))
    println(c4.toScale(Interval.chromaticScale))
    println(c4.toScale(Interval.majorOctatonicScale))
    println(c4.toScale(Interval.minorOctatonicScale))
    println(c4.toScale(Interval.circleOfFifths))
}