import kotlin.math.abs

fun main() {
    fun checkSafety(report: List<Int>): Boolean {
        if ((report.sorted() != report)&&(report.sortedDescending() != report)) {return false}
        if ((report.windowed(2).maxOf { abs(it[0] - it[1]) } <= 3)&&
            (report.windowed(2).minOf { abs(it[0] - it[1]) } >= 1)) {return true}
        return false
    }

    fun checkSafetyTolerate(report: List<Int>): Boolean {
        if (checkSafety(report)) {return true}
        report.forEachIndexed { index, i ->
            if (checkSafety(report.take(index) + report.takeLast(report.size - index - 1))) {return true}
        }
        return false
    }

    fun part1(input: List<String>): Int {
        return input.count { it -> checkSafety(it.split(' ').map { it.toInt() }) }
    }

    fun part2(input: List<String>): Int {
        return input.count { it -> checkSafetyTolerate(it.split(' ').map { it.toInt() }) }
    }


    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
