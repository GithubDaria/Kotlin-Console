fun main() {
    var continueRunning = true

    while (continueRunning) {
        println("Оберіть дію, ввівши номер від 1 до 6:")
        println("1. Умовні вирази, if, when: Перевірити, чи рік високосний.")
        println("2. Цикли та ітерації: Порахувати кількість голосних у слові.")
        println("3. Масиви, списки: Перевірити, чи є в масиві задане число.")
        println("4. Null safety: Написати функцію, яка повертає довжину рядка або 0, якщо null.")
        println("5. Обробка винятків: Написати функцію, яка приймає ціле число, кидає виняток, якщо воно не з діапазону 1–100.")
        println("6. Завершити програму.")

        val choice = readLine()?.toIntOrNull()

        if (choice != null) {
            when (choice) {
                1 -> checkLeapYear()
                2 -> countVowelsInWord()
                3 -> checkNumberInArray()
                4 -> checkStringLength()
                5 -> validateNumberInRange()
                6 -> {
                    println("Завершення програми.")
                    continueRunning = false // Set to false to break out of the loop and exit
                }
                else -> println("Невірний вибір. Виберіть номер від 1 до 6.")
            }
        } else {
            println("Будь ласка, введіть правильне число.")
        }
    }
}

fun checkLeapYear() {
    println("Введіть рік для перевірки, чи він високосний:")
    val year = readLine()?.toIntOrNull()
    if (year != null) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            println("Рік $year є високосним.")
        } else {
            println("Рік $year не є високосним.")
        }
    } else {
        println("Будь ласка, введіть коректний рік.")
    }
}
fun countVowelsInWord(){
    println("Введіть слово для підрахунку голосних:")
    val word = readLine()?.lowercase()
    if (word != null) {
        val vowels = "aeiou"
        val count = word.count { it in vowels }
        println("Кількість голосних в слові '$word': $count")
    }
}
fun checkNumberInArray(){
    println("Введіть числа для масиву, розділені пробілами:")

    val input = readLine()

    if (!input.isNullOrEmpty()) {
        val numbers = input.split(" ").filter { it.isNotBlank() }.mapNotNull { it.toIntOrNull() }

        if (numbers.isNotEmpty()) {
            println("Масив: ${numbers.joinToString(", ")}")
            println("Введіть число для перевірки в масиві:")
            val numberToCheck = readLine()?.toIntOrNull()

            if (numberToCheck != null) {
                if (numberToCheck in numbers) {
                    println("Число $numberToCheck є в масиві.")
                } else {
                    println("Число $numberToCheck немає в масиві.")
                }
            } else {
                println("Будь ласка, введіть коректне число для перевірки.")
            }
        } else {
            println("Ви не ввели жодного числа.")
        }
    } else {
        println("Вхід порожній! Будь ласка, введіть числа через пробіл.")
    }
}
fun checkStringLength(){
    println("Введіть рядок для перевірки довжини:")
    val input = readLine()
    val length = input?.length ?: 0
    println("Довжина рядка: $length")
}
fun validateNumberInRange(){
    while (true) {
        println("Введіть мінімальне значення діапазону:")
        val min = readLine()?.toIntOrNull()

        println("Введіть максимальне значення діапазону:")
        val max = readLine()?.toIntOrNull()

        if (min != null && max != null) {
            println("Введіть ціле число для перевірки в межах діапазону $min–$max:")
            val number = readLine()?.toIntOrNull()

            if (number != null) {
                if (number in min..max) {
                    println("Число $number в межах діапазону $min–$max.")
                    break
                } else {
                    println("Число $number не в межах діапазону $min–$max. Спробуйте ще раз.")
                }
            } else {
                println("Будь ласка, введіть коректне число для перевірки. Спробуйте ще раз.")
            }
        } else {
            println("Будь ласка, введіть коректні значення для діапазону. Спробуйте ще раз.")
        }
    }
}


