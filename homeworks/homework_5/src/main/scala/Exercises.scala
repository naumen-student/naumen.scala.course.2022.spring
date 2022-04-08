object Exercises {

  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal
  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[T]): List[String] = animals.map(x => food.feed(x))

    def +[A >: T <: Animal](otherAnimals: A): Shelter[A] = Shelter(animals :+ otherAnimals)

    def ++[A >: T <: Animal](otherShelter: Shelter[A]): Shelter[A] = Shelter(List(otherShelter.animals, animals).flatten)
  }

  trait Food[-T <: Animal] {
    def foodName: String = this.getClass.getSimpleName.stripSuffix("$")

    def feed(animal: T): String =
      s"${animal.name} eats ${foodName.toLowerCase}"
  }

  case object Meat extends Food[Animal]
  case object Milk extends Food[Cat]
  case object Bread extends Food[Dog]
}
