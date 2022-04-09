trait Cell {}

class EmptyCell extends Cell{
  override def toString(): String = "empty"
}

class NumberCell(value: Int) extends Cell{
  override def toString(): String = value.toString
}

class StringCell(value: String) extends Cell{
  override def toString(): String = value
}

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell{
  override def toString(): String =
    table.getCell(ix, iy) match {
      case Some(cell: ReferenceCell) => if (isCycllic(cell)) "cyclic" else cell.toString
      case Some(cell) => cell.toString
      case None => "outOfRange"
    }

  def isCycllic(cell: ReferenceCell): Boolean = table.getCell(cell.ix, cell.iy).orNull == this
}