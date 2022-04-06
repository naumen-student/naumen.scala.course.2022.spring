object Exercises {

  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+T <: Animal](animals: List[T]) {

    def +[TOther >: T <: Animal](other: TOther): Shelter[TOther] =
      Shelter(other :: animals)

    def ++[TOther >: T <: Animal](otherShelter: Shelter[TOther]): Shelter[TOther] =
      Shelter(otherShelter.animals ++ animals)

    def getNames: List[String] =
      animals.map(_.name)

    def feed(food: Food[T]): List[String] =
      animals.map(animal => food.feed(animal))
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
