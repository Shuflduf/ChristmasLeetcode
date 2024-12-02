import java.io.File

fun main() {
    val filePath = "Inputs/input1.txt"
    val fileContent = File(filePath).readText()

    var listOne: MutableList<Int> = mutableListOf()
    var listTwo: MutableList<Int> = mutableListOf()
    for (i in fileContent.lines()) {
        if (i.isEmpty()) {
            continue
        }
        val numbers = i.split("   ")
        if (numbers.size > 1) {
            listOne.add(numbers[0].toInt())
            listTwo.add(numbers[1].toInt())
        }
    }
    listOne.sort()
    listTwo.sort()

    var similarityScore = 0
    for (n in listOne) {
        val firstIndex = listTwo.indexOfFirst { it == n }
        if (firstIndex == -1) {
            continue
        }
        var count = 1
        while (listTwo[firstIndex + count] == n) {
            count += 1
        }
        similarityScore += count * n
    }
    println(similarityScore)
}
