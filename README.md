# Умовні вирази, if, when
## Перевірити, чи рік високосний
```
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
```
### Результат
![image](https://github.com/user-attachments/assets/0f1349a3-a643-4236-8d34-2cfe17f0820e)
![image](https://github.com/user-attachments/assets/43fafa60-794a-450d-8ccc-ef44ba2581f4)

# Цикли та ітерації
##Порахувати кількість голосних у слові.
```
fun countVowelsInWord(){
    println("Введіть слово для підрахунку голосних:")
    val word = readLine()?.lowercase()
    if (word != null) {
        val vowels = "aeiou"
        val count = word.count { it in vowels }
        println("Кількість голосних в слові '$word': $count")
    }
}
```
### Результат
![image](https://github.com/user-attachments/assets/dc8733a5-4cf0-43e9-a891-e8eed3e6aa3e)

#Масиви, списки
##Перевірити, чи є в масиві задане число.
```
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
```
### Результат
![image](https://github.com/user-attachments/assets/3bc7c83e-5068-4919-ba22-957e0d5bcc65)
![image](https://github.com/user-attachments/assets/adadbb14-68a8-4b0a-96d1-179278a5970d)

