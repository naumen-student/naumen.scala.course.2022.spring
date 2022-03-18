import scala.annotation.tailrec

trait Cell {
  def toString: String
}

case class EmptyCell() extends Cell {
  override def toString: String = {
    "empty"
  }
}

case class NumberCell(number: Int) extends Cell {
  override def toString: String = {
    number.toString
  }
}

case class StringCell(text: String) extends Cell {
  override def toString: String = {
    text
  }
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = {
      val cell = table.getCell(ix, iy)
      referenceCellToString(cell)
  }

  @tailrec
  private def referenceCellToString(currentCell: Option[Cell]): String = {
    if (currentCell.isEmpty) return "outOfRange"
    currentCell.get match {
      case refCell: ReferenceCell =>
        if (refCell != this) {
          val nextCell = table.getCell(refCell.ix, refCell.iy)
          referenceCellToString(nextCell)
        } else
          "cyclic"
      case value => value.toString
    }
  }
}