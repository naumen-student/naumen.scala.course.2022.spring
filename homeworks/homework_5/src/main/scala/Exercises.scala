object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+T <: Animal](animals: List[T]) {
    val animalsInShelter: List[T] = animals

    def +[A >: T <: Animal](newAnimal: A): Shelter[A] = {
      val newAnimals = animalsInShelter :+ newAnimal
      Shelter(newAnimals)
    }

    def ++[A >: T <: Animal](newShelter: Shelter[A]): Shelter[A] = {
      val newAnimals = animalsInShelter ::: newShelter.animalsInShelter
      Shelter(newAnimals)
    }

    def getNames: List[String] = animalsInShelter.map(x => x.name)

    def feed(food: Food[T]): List[String] = {
      animalsInShelter.map(food.feed)
    }
  }


  trait Food[-T <: Animal] {
    def name: String

    def feed(animal: T): String = s"${animal.name} eats ${name}"
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
