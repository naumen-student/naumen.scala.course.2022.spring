package example

object Main extends App {
    def say_hello(greetings: String, name: String): Unit = println(s"$greetings Scala! This is $name")

    val eng_greetings = "Hello"

    val name = "Ruslan Vlasenko"
    say_hello(eng_greetings, name)

    val spa_greetings = "Hola"

    val deu_greetings = "Guten tag"

    say_hello(spa_greetings, name)

    say_hello(deu_greetings, name)

    val reversed_name = name.reverse

    say_hello(eng_greetings, reversed_name)

    say_hello(spa_greetings, reversed_name)

    say_hello(deu_greetings, reversed_name)
}
