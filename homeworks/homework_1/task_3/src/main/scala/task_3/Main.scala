package task_3

object Main extends App{
  def get_greetings_text(greetings: String, name: String) = println(s"$greetings Scala! This is $name")

  val greetings_array = Array("Hello", "Hola", "Guten Tag")
  val name = "Anna Ziablitseva"
  val reverse_name = name.reverse

  for (elem <- greetings_array) get_greetings_text(elem, name)
  for (elem <- greetings_array) get_greetings_text(elem, reverse_name)

}
