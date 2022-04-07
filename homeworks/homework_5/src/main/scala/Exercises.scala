object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal] (animals: List[A])
  {
    def +[O >: A <: Animal](other: O): Shelter[O] = Shelter(animals ::: List(other))

    def ++[O >: A <: Animal](other: Shelter[O]): Shelter[O] = Shelter(animals ::: other.animals)

    def getNames(): List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(food.feed(_));
  }



  trait Food[-A <: Animal]
  {
    def Name: String
    def feed(animal: A): String = s"${animal.name} eats ${Name}"
  }

  case object Meat extends Food[Animal]
  {
    override val Name: String = "meat"
  }

  case object Milk extends Food[Cat]
  {
    override val Name: String = "milk"
  }

  case object Bread extends Food[Dog]
  {
    override val Name: String = "bread"
  }
}
