import scala.annotation.tailrec

trait Cell {
  def toString: String
}

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

case class StringCell(text: String) extends Cell {
  override def toString: String = text
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = referenceCellToString(List.empty)

  @tailrec
  private def referenceCellToString(visited: List[Cell]): String = {
    table.getCell(ix, iy) match {
      case Some(cell) => cell match {
        case referenceCell: ReferenceCell =>
          if (visited.contains(referenceCell))
            "cyclic"
          else
            referenceCell.referenceCellToString(referenceCell :: visited)
        case _ => cell.toString
      }
      case None => "outOfRange"
    }
  }
}