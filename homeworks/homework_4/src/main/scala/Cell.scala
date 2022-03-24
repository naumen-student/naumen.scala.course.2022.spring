import scala.annotation.tailrec

sealed trait Cell {
  def toString: String
}

final case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

final case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

final case class StringCell(text: String) extends Cell {
  override def toString: String = text
}

final case class ReferenceCell(x: Int, y: Int, table: Table) extends Cell {
  override def toString: String = referenceCellToString(table.getCell(x, y))

  @tailrec
  private def referenceCellToString(currentCell: Option[Cell]): String = {
    if (currentCell.isEmpty) "outOfRange"
    else
      currentCell.get match {
        case refCell: ReferenceCell =>
          if (refCell == this) "cyclic"
          else referenceCellToString(table.getCell(refCell.x, refCell.y))
        case normCell => normCell.toString
      }
  }
}