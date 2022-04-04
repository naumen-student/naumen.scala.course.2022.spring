import scala.annotation.tailrec

sealed trait Cell

case class EmptyCell() extends Cell { //Тесты не позволяют использовать object
  override def toString: String = "empty"
}
case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}
case class StringCell(string: String) extends Cell {
  override def toString: String = string
}
case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String =
    table
      .getCell(ix, iy)
      .map(x => if (findCycle(Set(this))) "cyclic" else x.toString)
      .getOrElse("outOfRange") //Нет тестов на outOfRange

  @tailrec
  private def findCycle(visited: Set[ReferenceCell]): Boolean =
    table.getCell(ix, iy) match {
      case Some(x: ReferenceCell) if visited.contains(x) => true
      case Some(x: ReferenceCell)                        => x.findCycle(visited + x)
      case _                                             => false
    }
}
