# Умовні вирази, if, when
## Перевірити, чи рік високосний
```kotlin
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
### Результат
![image](https://github.com/user-attachments/assets/0f1349a3-a643-4236-8d34-2cfe17f0820e)
