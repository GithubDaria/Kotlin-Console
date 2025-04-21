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
