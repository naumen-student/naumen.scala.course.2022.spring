sealed trait Cell{
  def toString: String
}

class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

class NumberCell(cellNumber: Int) extends Cell{
  override def toString: String = cellNumber.toString;
}

class StringCell(cellText: String) extends Cell{
  override def toString: String = cellText;
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell{
  override def toString: String = {
    table.getCell(ix, iy).map(_.toString).getOrElse("OutOfRange")
  }

  private def toStringImpl(historyCells: Seq[Cell] = Nil): Option[String] =
    table.getCell(ix, iy) match{
      case Some(:ReferenceCell) => Some(historyCells.contains(this)).filter(_ == false).flatMap(_ => refCell.toStringImpl(historyCells :+ this)).orElse(Some("cyclic"))
      case cell: Option[Cell] => cell.map(_.toString)
    }
}