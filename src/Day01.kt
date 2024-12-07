import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val listLeft = mutableListOf<Int>()
        val listRight = mutableListOf<Int>()
        input.forEach{listLeft.add(it.split(" ")[0].toInt()); listRight.add(it.split("   ")[1].toInt())}
        return listLeft.sorted().zip(listRight.sorted()).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val listLeft = mutableListOf<Int>()
        val listRight = mutableListOf<Int>()
        input.forEach{listLeft.add(it.split(" ")[0].toInt()); listRight.add(it.split("   ")[1].toInt())}
        return listLeft.sumOf { it * listRight.count { elem -> elem == it } }
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 11)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
