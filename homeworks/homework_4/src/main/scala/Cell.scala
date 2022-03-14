import scala.annotation.tailrec

sealed trait Cell {
  def toString: String
}

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

case class StringCell(string: String) extends Cell {
  override def toString: String = string
}

case class ReferenceCell(private val ix: Int, private val iy: Int, private val table: Table) extends Cell {
  override def toString: String = getLastCellToString(this, Set())
  private val OUT_OF_RANGE = "outOfRange"
  private val CYCLIC = "cyclic"

  @tailrec
  private def getLastCellToString(cell: ReferenceCell, visited: Set[ReferenceCell]): String =
    cell.table.getCell(cell.ix, cell.iy) match {
      case Some(valueCell) => valueCell match {
        case nextCell: ReferenceCell =>
          if (visited.contains(nextCell)) CYCLIC
          else getLastCellToString(nextCell, visited + nextCell)
        case _ => valueCell.toString
      }
      case None => OUT_OF_RANGE
    }
}