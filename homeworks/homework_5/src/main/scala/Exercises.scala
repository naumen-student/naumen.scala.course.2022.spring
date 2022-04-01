object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](animals: List[T]) {

    def +[TOther >: T <: Animal](other: TOther): Shelter[TOther] = {
      Shelter(other :: animals)
    }

    def ++[TOther >: T <: Animal](otherShelter: Shelter[TOther]): Shelter[TOther] = {
      Shelter(otherShelter.animals ++ animals)
    }

    def getNames: List[String] = {
      animals.map(_.name)
    }

    def feed[TFood >: T <: Animal](food: Food[TFood]): List[String] ={
      animals.map(animal => food.feed(animal))
    }
  }



  trait Food[T] {
    def feed(animal: T): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal): String =
      s"${animal.name} eats meat"
  }

  case object Milk extends Food[Cat] {
    override def feed(animal: Cat): String =
      s"${animal.name} eats milk"
  }

  case object Bread extends Food[Dog] {
    override def feed(animal: Dog): String =
      s"${animal.name} eats bread"
  }
}
