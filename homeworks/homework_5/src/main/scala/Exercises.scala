object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](newAnimal: B): Shelter[B] = Shelter(animals :+ newAnimal)

    def ++[B >: A <: Animal](newAnimals : Shelter[B]) : Shelter[B] = Shelter(animals ::: newAnimals.animals)

    def getNames: List[String] = {
      animals.map(animal => animal.name)
    }

    def feed(food: Food[A]): List[String] = {
      animals.map(animal => food.feed(animal))
    }
  }



  trait Food[-A <: Animal] {
    val foodName: String
    def feed(animal: A): String = s"${animal.name} eats $foodName"
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
