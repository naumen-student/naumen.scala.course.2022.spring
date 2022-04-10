object Exercises {


  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def feed(food: Food[T]): List[String] = animals.map(food.feed)
    def +[E >: T <: Animal](animal: E): Shelter[E] = Shelter(animals :+ animal)
    def ++[E >: T <: Animal](shelter: Shelter[E]): Shelter[E] = Shelter(animals ::: shelter.animals)
    def getNames: List[String] = {
      animals.map(anim => anim.name)
    }
  }

  trait Food[-T <: Animal]
  {
    def foodName: String
    def feed(animal: T): String = s"${animal.name} eats ${foodName}"
  }

  case object Meat extends Food[Animal]
  {
    override val foodName: String = "meat"
  }

  case object Milk extends Food[Cat]
  {
    override val foodName: String = "milk"
  }

  case object Bread extends Food[Dog]
  {
    override val foodName: String = "bread"
  }

}
