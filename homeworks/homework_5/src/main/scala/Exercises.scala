object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def feed(food: Food[T]): List[String] = animals.map(a => food.feed(a))

    def getNames: List[String] = animals.map(a => a.name)

    def +[T1 >: T <: Animal](animal: T1): Shelter[T1] = Shelter(animals :+ animal)

    def ++[T2 >: T <: Animal](anotherShelter: Shelter[T2]): Shelter[T2] = Shelter(List(anotherShelter.animals, animals).flatten)
  }


  trait Food[-T <: Animal] {
    def name: String

    def feed(animal: T): String = s"${animal.name} eats $name"
  }

  case object Meat extends Food[Animal] {
    override val name: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val name: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val name: String = "bread"
  }
}
