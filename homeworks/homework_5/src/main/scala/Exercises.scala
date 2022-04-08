object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](animals: List[Animal]) {
    def +[T2 <: Animal](animal: T2): Shelter[T2] = Shelter(animals :+ animal)

    def ++(shelter: Shelter[Animal]): Shelter[Animal] = Shelter(animals ++ shelter.animals)

    def getNames: List[String] = {
      animals.map(_.name)
    }

    def feed(food: Food[Animal]): List[String] = {
      animals.map(food.feed)
    }
  }

  trait Food[+T <: Animal] {
    private val name = this.getClass.getSimpleName.toLowerCase
    private val nameWithoutLastChar = name.substring(0, name.length - 1)

    def feed(animal: Animal): String = {
      s"${animal.name} eats $nameWithoutLastChar"
    }
  }

  case object Meat extends Food[Animal]

  case object Milk extends Food[Cat]

  case object Bread extends Food[Dog]
}
