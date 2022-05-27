object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal](animals: List[A]){
    def feed(food: Food[A]): List[String] = animals.map(a => food.feed(a))

    def getNames: List[String] = animals.map(_.name)

    def +[A1 >: A <: Animal](oth_animal: A1): Shelter[A1] = Shelter(animals :+ oth_animal)

    def ++[A2 >: A <: Animal](oth_shelter: Shelter[A2]): Shelter[A2] = Shelter(List(oth_shelter.animals, animals).flatten)
  }



  trait Food[-A <: Animal]{
    def fname: String

    def feed(animal: A): String = s"${animal.name} eats $fname"
  }

  case object Meat extends Food[Animal] {
    override val foodname: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val foodname: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val foodname: String = "bread"
  }
}
