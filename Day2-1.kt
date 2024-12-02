import java.io.File

fun main() {
    val filePath = "Inputs/input2.txt"
    val fileContent = File(filePath).readText()

    var safeReports = 0
    for (report in fileContent.lines()) {
        if (report.isEmpty()) {
            continue
        }
        val levels = report.split(" ").map { it.toInt() }.toIntArray()

        val positive = levels[0] < levels[1]
        val dir = if (positive) 1 else -1
        var safe = true
        for (i in levels.indices) {
            if (i == 0) {
                continue
            }
            val value = levels[i]
            if (positive) {
                if (!(value > levels[i - 1] && value < levels[i - 1] + 4)) {
                    safe = false
                    break
                }
            } else {
                if (!(value < levels[i - 1] && value > levels[i - 1] - 4)) {
                    safe = false
                    break
                }
            }
        }
        println("$safe: $report")
        if (safe) {
            safeReports += 1
        }
    }
    println(safeReports)
}
