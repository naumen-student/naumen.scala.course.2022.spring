object Exercises {

  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[T <: Animal](list: List[T]) {

    def +[V >: T <: Animal](that: V): Shelter[V] = {
      val a = that :: list
      Shelter(a)
    }

    def ++[V >: T <: Animal](that: Shelter[V]): Shelter[V] = {
      Shelter(this.list ++ that.list)
    }

    def getNames: List[String] = {
      list.map(_.name)
    }

    def feed[V >: T](food: Food[V]): List[String] = {
      list.map(animal => food.feed(animal))
    }
  }


  trait Food[T] {
    def feed(animal: T): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal): String = {
      s"${animal.name} eats meat"
    }
  }

  case object Milk extends Food[Cat] {
    override def feed(animal: Cat): String = {
      s"${animal.name} eats milk"
    }
  }

  case object Bread extends Food[Dog] {
    override def feed(animal: Dog): String = {
      s"${animal.name} eats bread"
    }
  }

}
