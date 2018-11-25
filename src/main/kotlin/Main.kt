fun main(args: Array<String>) {
    val pitch = Pitch(PitchClass(PitchLetter.C), 3)

    println(pitch.toCollection(Interval.majorScale))
    println(pitch.toCollection(Interval.minorScale))
    println(pitch.toCollection(Interval.majorPentatonicScale))
    println(pitch.toCollection(Interval.minorPentatonicScale))
    println(pitch.toCollection(Interval.wholeToneScale))
    println(pitch.toCollection(Interval.chromaticScale))
    println(pitch.toCollection(Interval.majorOctatonicScale))
    println(pitch.toCollection(Interval.minorOctatonicScale))
    println(pitch.toCollection(Interval.circleOfFifths))
    println(pitch.toCollection(Interval.majorTriad))
    println(pitch.toCollection(Interval.minorTriad))
}