interface Transposable<T> {

    fun transpose(interval: Interval): Transposable<T>
}