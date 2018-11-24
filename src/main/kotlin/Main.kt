fun main(args: Array<String>) {
    val pitch = Pitch(PitchClass(PitchLetter.C), 4)

    println(pitch.toScale(Interval.majorScale))
    println(pitch.toScale(Interval.minorScale))
    println(pitch.toScale(Interval.majorPentatonicScale))
    println(pitch.toScale(Interval.minorPentatonicScale))
    println(pitch.toScale(Interval.wholeToneScale))
    println(pitch.toScale(Interval.chromaticScale))
    println(pitch.toScale(Interval.majorOctatonicScale))
    println(pitch.toScale(Interval.minorOctatonicScale))
    println(pitch.toScale(Interval.circleOfFifths))
}