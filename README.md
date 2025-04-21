![image](https://github.com/user-attachments/assets/591ee375-e46f-4773-843a-30f8e3b7e9ea)![image](https://github.com/user-attachments/assets/f53f13b4-baab-466c-9ba2-82478dab61ce)# Умовні вирази, if, when
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
## Порахувати кількість голосних у слові.
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

# Масиви, списки
## Перевірити, чи є в масиві задане число.
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

#Null safety
### Написати функцію, яка повертає довжину рядка або 0, якщо null.
```
fun checkStringLength(){
    println("Введіть рядок для перевірки довжини:")
    val input = readLine()
    val length = input?.length ?: 0
    println("Довжина рядка: $length")
}
```
### Результат
![image](https://github.com/user-attachments/assets/50c7e70e-978b-4f25-8f0e-7c2032c5e9c2)
![image](https://github.com/user-attachments/assets/91a7dce1-fa2c-439c-a1d3-c0478bd26bb9)

#Обробка винятків
## Написати функцію, яка приймає ціле число, кидає виняток, якщо воно не з діапазону 1–100.
```
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
```
### Результат
![image](https://github.com/user-attachments/assets/fd8d49e4-8ab2-4f06-853f-c3c3e10a3172)
![image](https://github.com/user-attachments/assets/75c75042-9050-426d-bc1c-969146d2df18)

# Задача 2. «Меню доставки»
```
package com.example.consolelab2

fun main() {

    val menu = mapOf(
        1 to "Піца (150 грн)",
        2 to "Бургери (100 грн)",
        3 to "Суші (200 грн)",
        4 to "Паста (120 грн)",
        5 to "Салат (80 грн)"
    )


    val prices = mapOf(
        1 to 150,
        2 to 100,
        3 to 200,
        4 to 120,
        5 to 80
    )

    var totalAmount = 0

    fun displayMenu() {
        println("\nМеню доставки:")
        for ((key, value) in menu) {
            println("$key. $value")
        }
        println("0. Вихід")
    }


    class InvalidMenuChoiceException(message: String) : Exception(message)

    while (true) {
        displayMenu()

        try {
            print("\nВиберіть страву (1-5) або 0 для виходу: ")
            val choice = readln().toIntOrNull()

            if (choice == null || choice !in 0..5) {
                throw InvalidMenuChoiceException("Невірний вибір меню.")
            }

            if (choice == 0) {
                break
            }

            if (choice in prices) {
                totalAmount += prices[choice] ?: 0
                println("Ви обрали: ${menu[choice]}")
                println("До сплати: ${totalAmount} грн")
            }

        } catch (e: InvalidMenuChoiceException) {
            println("Помилка: ${e.message}")
        } catch (e: Exception) {
            println("Сталася помилка: ${e.message}")
        }
    }

    val discount = when {
        totalAmount > 500 -> 0.15
        totalAmount > 200 -> 0.10
        else -> 0.0
    }

    val finalAmount = totalAmount * (1 - discount)

    println("\nЗагальна сума замовлення: $totalAmount грн")
    if (discount > 0) {
        println("Ви отримали знижку: ${"%.0f".format(discount * 100)}%")
    } else {
        println("Знижка не надана.")
    }
    println("До сплати: $finalAmount грн")
}
```
### Результат
![image](https://github.com/user-attachments/assets/78d90c6f-4ffc-4d66-bdef-d238a52bd454)
![image](https://github.com/user-attachments/assets/32a0cb7e-83aa-46cd-a3b8-513b5edf8b31)


