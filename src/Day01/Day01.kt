package Day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0

        input.forEach {
            if (it == "") {
                if (current > max) {
                    max = current
                }
                current = 0
            } else {
                current += it.toInt()
            }
        }

        return max
    }

    fun part2(input: List<String>): Int {
        val max = IntArray(3)
        var current = 0

        input.forEach {
            if (it == "") {
                if (current > max[0]) {
                    val tmp = max[0]
                    max[0] = current
                    current = tmp
                }

                if (current > max[1]) {
                    val tmp = max[1]
                    max[1] = current
                    current = tmp
                }

                if (current > max[2]) {
                    val tmp = max[2]
                    max[2] = current
                    current = tmp
                }
                current = 0
            } else {
                current += it.toInt()
            }
        }

        return max.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01/Day01_test")
//    check(part1(testInput) == 24000)
//    check(part2(testInput) == 45000)

    val input = readInput("Day01/Day01")
    println(part1(input))
    println(part2(input))
}
