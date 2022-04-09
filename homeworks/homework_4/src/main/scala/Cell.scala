trait Cell

case class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

case class NumberCell(number: Int) extends Cell{
  override def toString: String = number.toString
}

case class StringCell(string: String) extends Cell{
  override def toString: String = string
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell{

  override def toString: String = table.getCell(ix, iy) match {
    case None => "outOfRange"
    case Some(_) if isCyclic => "cyclic"
    case Some(cell) => cell.toString
  }

  def isCyclic: Boolean = {
    table.getCell(ix, iy) match{
      case Some(cell: ReferenceCell) => cell.ix == ix && cell.iy == iy
      case _ => false
    }
  }

}