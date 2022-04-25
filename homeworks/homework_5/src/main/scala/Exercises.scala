object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[A >: T <: Animal](another: A) = {
      Shelter(this.animals :+ another)
    }

    def ++[A >: T <: Animal](another: Shelter[A]): Shelter[A] = {
      Shelter(this.animals ++ another.animals)
    }

    def getNames(): Set[String] = {
      var res = Set[String]()
      animals.foreach((animal: Animal) => res += animal.name)
      res
    }

    def feed(food: Food[T]): List[String] = {
      animals.map(food.feed)
    }
  }

  trait Food[-T <: Animal] {
    val productName: String
    def feed(animal: T): String = {
      s"${animal.name} eats $productName"
    }
  }

  case object Meat extends Food[Animal] {
    override val productName: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val productName: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val productName: String = "bread"
  }
}