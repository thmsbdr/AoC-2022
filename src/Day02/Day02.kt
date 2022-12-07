package Day02

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var total = 0
        val valueOfMove = mapOf('X' to 1, 'Y' to 2, 'Z' to 3)
        val whoDoIBeat = mapOf('X' to 'C', 'Y' to 'A', 'Z' to 'B')

        input.forEach {
            if (it[0] == it[2] -23) {
                total += 3
            } else if (whoDoIBeat.getValue(it[2]) == it[0]) {
                total += 6
            }

            total += valueOfMove.getValue(it[2])
        }

        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        val valueOfMove = mapOf('A' to 1, 'B' to 2, 'C' to 3)
        val whoDoIBeat = mapOf('A' to 'C', 'B' to 'A', 'C' to 'B')

        input.forEach { s ->
            if (s[2] == 'X') {
                total += valueOfMove.getValue(whoDoIBeat.getValue(s[0]))
            } else if (s[2] == 'Y') {
                total += valueOfMove.getValue(s[0])
                total += 3
            } else {
                whoDoIBeat.keys.forEach {
                    if (whoDoIBeat.getValue(it) == s[0])
                        total += valueOfMove.getValue(it)
                }
                total += 6
            }
        }

        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02/Day02")
    println(part1(input))
    println(part2(input))
}
