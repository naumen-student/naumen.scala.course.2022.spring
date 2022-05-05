sealed trait Cell

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

case class NumberCell(num: Int) extends Cell {
  override def toString: String = num.toString
}

case class StringCell(str: String) extends Cell {
  override def toString: String = str
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  def getReferencedCell = table.getCell(ix, iy)

  override def toString: String = getReferencedCell.map {
    case cell: ReferenceCell if cell.getReferencedCell.orNull == this => "cyclic"
    case cell => cell.toString
  }.getOrElse("outOfRange")