object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal](animals: List[A]){
    def +[B >: A <: Animal](anotherAnimal: B): Shelter[B] =
      Shelter(anotherAnimal :: animals)

    def ++[B >: A <: Animal](anotherShelter : Shelter[B]) : Shelter[B] =
      Shelter(animals ++ anotherShelter.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(x => food.feed(x))

  }



  trait Food{
    def foodName: String = this.getClass.getSimpleName.stripSuffix("$")

    def feed(animal: Animal): String =
      s"${animal.name} eats ${foodName.toLowerCase}"
  }

  case object Meat extends Food[Animal]

  case object Milk extends Food[Cat]

  case object Bread extends Food[Dog]
}
