object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal](animals: List[A] = List.empty) {
    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animals :+ animal)

    def ++[B >: A <: Animal](shelter: Shelter[B]): Shelter[B] = Shelter(animals ++ shelter.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(food.feed)
  }



  trait Food[-T <: Animal] {
    val foodName: String

    def feed(animal: T): String =  s"${animal.name} eats $foodName"
  }

  case object Meat extends Food[Animal] {
    override val foodName: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val foodName: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val foodName: String = "bread"
  }
}
