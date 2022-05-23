
object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T1 <: Animal](animals: List[T1]) {
    def +[T2 >: T1 <: Animal](animal: T2): Shelter[T2] = Shelter(animals :+ animal)

    def ++[T2 >: T1 <: Animal](shelter: Shelter[T2]): Shelter[T2] = Shelter(animals ++ shelter.animals)

    def getNames: List[String] = {
      animals.map(_.name)
    }

    def feed(food: Food[T1]): List[String] = {
      animals.map(food.feed)
    }
  }

  trait Food[-T <: Animal] {
    private val name = this.getClass.getSimpleName.toLowerCase
    private val nameWithoutLastChar = name.substring(0, name.length - 1)

    def feed(animal: T): String = {
      s"${animal.name} eats $nameWithoutLastChar"
    }
  }

  case object Meat extends Food[Animal]

  case object Milk extends Food[Cat]

  case object Bread extends Food[Dog]
}
