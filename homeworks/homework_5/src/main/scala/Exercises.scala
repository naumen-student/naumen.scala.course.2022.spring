import scala.language.higherKinds

object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](newAnimal: B) = Shelter(animals :+ newAnimal)

    def ++[B >: A <: Animal](anotherShelter: Shelter[B]) = Shelter(animals ++ anotherShelter.animals)

    def getNames = animals.map(_.name)

    def feed(food: Food[A]) = animals.map(food.feed)

  }


  trait Food[-A <: Animal] {
    def feed(animal: A): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal) = s"${animal.name} eats meat"
  }

  case object Milk extends Food[Cat] {
    override def feed(animal: Cat) = s"${animal.name} eats milk"
  }

  case object Bread extends Food[Dog] {
    override def feed(animal: Dog) = s"${animal.name} eats bread"
  }
}
