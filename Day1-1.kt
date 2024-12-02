import java.io.File
import kotlin.math.abs

fun main() {
    val filePath = "Inputs/input.1-1.txt"
    val fileContent = File(filePath).readText()

    var listOne: MutableList<Int> = mutableListOf()
    var listTwo: MutableList<Int> = mutableListOf()
    println(fileContent.lines().size)
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
    println(listOne.size)
    listOne.sort()
    listOne.reverse()
    listTwo.sort()
    listTwo.reverse()

    var totalListDifference = 0
    repeat(listOne.size) {
        totalListDifference += abs(listOne.removeAt(listOne.lastIndex) - listTwo.removeAt(listTwo.lastIndex))
    }

    println(totalListDifference)
}
