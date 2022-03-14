import scala.annotation.tailrec
import scala.collection.immutable.HashSet

sealed trait Cell {
  def toString: String
}

final case class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

final case class NumberCell(number: Int) extends Cell{
  override def toString: String = number.toString
}

final case class StringCell(text: String) extends Cell{
  override def toString: String = text
}

final case class ReferenceCell(x: Int, y: Int, table: Table) extends Cell{
  override def toString: String = refToString(HashSet.empty)

  @tailrec
  private def refToString(hash: HashSet[Cell]): String = {
    table.getCell(x, y) match {
      case None => "outOfRange"
      case Some(cell) => cell match {
        case refCel: ReferenceCell =>
          if (hash.contains(refCel)) "cyclic" else refCel.refToString(hash + refCel)
        case someCell => someCell.toString
      }
    }
  }
}