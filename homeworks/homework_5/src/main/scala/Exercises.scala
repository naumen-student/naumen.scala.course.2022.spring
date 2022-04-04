object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animal :: animals)

    def ++[B >: A <: Animal](anotherShelter: Shelter[B]): Shelter[B] = Shelter(animals ::: anotherShelter.animals)
  }

  implicit class ShelterOps[A <: Animal](shelter: Shelter[A]) {
    def getNames: List[String] = shelter.animals.map(_.name)

    def feed(food: Food[A]): List[String] = shelter.animals.map(x => food.feed(x))
  }


  trait Food[-A <: Animal] {
    def feed(animal: A): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal): String = animal.eat("meat")
  }

  case object Milk extends Food[Cat] {
    override def feed(cat: Cat): String = cat.eat("milk")
  }

  case object Bread extends Food[Dog] {
    override def feed(dog: Dog): String = dog.eat("bread")
  }

  implicit class AnimalFeedSyntax(animal: Animal) {
    def eat(foodName: String): String = s"${animal.name} eats $foodName"
  }
}
