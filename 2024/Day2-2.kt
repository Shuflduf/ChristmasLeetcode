import java.io.File

fun main() {
    val filePath = "Inputs/input2.txt"
    val fileContent = File(filePath).readText()

    var safeReports = 0
    for (report in fileContent.lines()) {
        if (report.isEmpty()) {
            continue
        }
        val levels = report.split(" ").map { it.toInt() }

        println("Before: $levels, ${isSafe(levels)}")
        var safe = isSafe(levels)
        if (!safe) {
            for (i in levels.indices) {
                val newLevels = levels.filterIndexed { index, _ -> index != i }
                println("After: $newLevels, ${isSafe(newLevels)}")
                safe = isSafe(newLevels)
                if (safe) {
                    break
                }
            }
        }
        if (safe) {
            safeReports += 1
        }
    }
    println(safeReports)
}

fun isSafe(input: List<Int>): Boolean {
    val positive = input[0] < input[1]
    for (j in input.indices) {
        if (j == 0) {
            continue
        }
        val value = input[j]
        if (positive) {
            if (!(value > input[j - 1] && value < input[j - 1] + 4)) {
                return false
            }
        } else {
            if (!(value < input[j - 1] && value > input[j - 1] - 4)) {
                return false
            }
        }
    }
    return true
}
