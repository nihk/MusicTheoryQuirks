fun main(args: Array<String>) {
    Pitch(PitchClass(PitchLetter.C), 4)
        .toCollection(Interval.chromaticScale).forEach { pitch ->
            println("majorScale:           ${pitch.toCollection(Interval.majorScale)}")
            println("naturalMinorScale:    ${pitch.toCollection(Interval.naturalMinorScale)}")
            println("majorPentatonicScale: ${pitch.toCollection(Interval.majorPentatonicScale)}")
            println("minorPentatonicScale: ${pitch.toCollection(Interval.minorPentatonicScale)}")
            println("wholeToneScale:       ${pitch.toCollection(Interval.wholeToneScale)}")
            println("majorOctatonicScale:  ${pitch.toCollection(Interval.majorOctatonicScale)}")
            println("minorOctatonicScale:  ${pitch.toCollection(Interval.minorOctatonicScale)}")
            println("circleOfFifths:       ${pitch.toCollection(Interval.circleOfFifths)}")
            println("majorTriad:           ${pitch.toCollection(Interval.majorTriad)}")
            println("minorTriad:           ${pitch.toCollection(Interval.minorTriad)}\n")
        }
}