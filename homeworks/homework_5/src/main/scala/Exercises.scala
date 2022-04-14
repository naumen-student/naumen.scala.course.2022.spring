object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](b: B): Shelter[B] = Shelter(animals :+ b)

    def ++[B >: A <: Animal](b: Shelter[B]): Shelter[B] = Shelter(animals ++ b.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(animal => food.feed(animal))
  }



  trait Food[-T <: Animal] {
    def feed(animal: T): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal): String = animal.name + " eats meat"
  }

  case object Milk extends Food[Cat] {
    override def feed(cat: Cat): String = cat.name + " eats milk"
  }

  case object Bread extends Food[Dog] {
    override def feed(dog: Dog): String = dog.name + " eats bread"
  }
}
