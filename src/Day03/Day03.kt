package Day03

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var total = 0

        input.forEach { s ->
            val compOne = s.substring(0, s.length / 2).toSet()
            run findFirst@{
                s.substring(s.length / 2).toCharArray().forEach {
                    if (compOne.contains(it)) {
                        val intValue = it.toInt()
                        total += if (intValue < 92) {
                            intValue - 38
                        } else {
                            intValue - 96
                        }
                        return@findFirst
                    }
                }
            }
        }

        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0

        input.chunked(3).forEach {
            val badge = it.first().toSet().intersect(it[1].toSet()).intersect(it[2].toSet()).first().toInt()
            total += if (badge < 92) {
                badge - 38
            } else {
                badge - 96
            }
        }

        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03/Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03/Day03")
    println(part1(input))
    println(part2(input))
}
