val hellos = List("Hello", "Yo", "Halo")
val names = List("Xenia", "Xenia Evdokimova".reverse)

def iPrint(hellos: List[String], names: List[String]): Unit = for {
  hello <- hellos
  name <- names
} yield println(s"$hello Scala! This is $name!")

iPrint(hellos, names)
