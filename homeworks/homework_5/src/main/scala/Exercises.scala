object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animals :+ animal)

    def ++[B >: A <: Animal](shelter: Shelter[B]): Shelter[B] = Shelter(animals ::: shelter.animals)

    def getNames: List[String] = {
      animals.map(anim => anim.name)
    }

    def feed(food: Food[A]): List[String] = animals.map(food.feed)
  }
  
   trait Food[-A <: Animal]
  {
    def foodName: String
    def feed(animal: A): String = s"${animal.name} eats ${foodName}"
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
