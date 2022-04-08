object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+T <: Animal](list: List[T]) {
    def getNames: List[String] = list.map(_.name)

    def +[A >: T <: Animal](a: A) = Shelter(list :+ a)

    def ++[A >: T <: Animal](sh: Shelter[A]) = Shelter(List(sh.list, list).flatten)

    def feed(food: Food[T]) = list.map(x => food.feed(x))

  }


  trait Food[-T <: Animal] {
    def name: String

    def feed(a: T) = s"${a.name} eats ${name}"
  }

  case object Meat extends Food[Animal] {
    override def name: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override def name: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override def name: String = "bread"
  }
}
