# Домашнее задание №8 (курс Scala, Naumen)

## Задание 1. *Read*
Реализовать тайпкласс Read, который позволяет прочитать значение типа T, реализующего тайпкласс, из строки.
Тайпкласс должен иметь метод read, который на вход принимает строку, а на выходе выдает Either[String, T],
где в случае, если чтение было успешно, будет Right с нужным значением, если неуспешным, то Left со строкой,
поясняющей ошибку.

Реализовать для данного тайпкласса интерфейс с использованием неявных параметров и обогащающий класс.
Должны работать следующие синтаксисы: Read.read[T]("...") и "...".read[T]

Реализовать для данного тайпкласса инстансы для типов: String, Int и Option[T], где тип Т уже имеет инстанс Read.
Для типа String операция чтения всегда успешна и возвращает саму строку.
Для типа Int операция возвращает число, если поданная на вход строка является корректым представлением числа, или ошибку.
Для типа Option[T] операция возвращает None, если на вход подана строка "None", Some(<результат чтения внутреннего выражения>),
если на вход подана строка вида "Some(...)" и выражение в скобках было корректно прочитано в тип T, и ошибку во всех остальных случаях.
