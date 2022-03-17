trait Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(text: String) extends Cell {
  override def toString: String = text
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {

  def getReferencedCell: Option[Cell] = table.getCell(ix, iy)

  override def toString: String = {
    table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(x) => x match {
        case cell: ReferenceCell if cell.getReferencedCell.orNull == this => "cyclic"
        case _ => x.toString
      }
    }
  }
}