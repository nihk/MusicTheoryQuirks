interface Transposable {

    fun transpose(interval: Interval): Transposable

    fun toCollection(intervals: List<Interval>): List<Transposable> {
        val collection = mutableListOf(this)

        intervals.fold(this) { transposable, interval ->
            transposable.transpose(interval)
                .also { collection.add(it) }
        }

        return collection
    }
}