package Day04

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var total = 0

        input.forEach {
            val shifts = it.split(',')
            val shiftOne = shifts[0].split('-')
            val shiftTwo = shifts[1].split('-')

            if (shiftOne[0].toInt() <= shiftTwo[0].toInt()
                && shiftOne[1].toInt() >= shiftTwo[1].toInt()) {
                total++
            } else if (shiftOne[0].toInt() >= shiftTwo[0].toInt()
                && shiftOne[1].toInt() <= shiftTwo[1].toInt()) {
                total++
            }
        }

        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0

        input.forEach {
            val shifts = it.split(',')
            val shiftOne = shifts[0].split('-')
            val shiftTwo = shifts[1].split('-')

            if (shiftTwo[0].toInt() in shiftOne[0].toInt()..shiftOne[1].toInt()
                || shiftTwo[1].toInt() in shiftOne[0].toInt()..shiftOne[1].toInt()
                || shiftOne[0].toInt() in shiftTwo[0].toInt()..shiftTwo[1].toInt()
                || shiftOne[1].toInt() in shiftTwo[0].toInt()..shiftTwo[1].toInt()) {
                total++
            }
        }

        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04/Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04/Day04")
    println(part1(input))
    println(part2(input))
}
