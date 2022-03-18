trait Cell

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(value: String) extends Cell {
  override def toString: String = value
}

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {
  override def toString: String = {
    table.getCell(ix, iy) match {
      case Some(_) if isCyclic => "cyclic"
      case Some(cell) => cell.toString
      case None => "outOfRange"
    }
  }

  private def isCyclic: Boolean = {
    table.getCell(ix, iy) match {
      case Some(cell) => cell.isInstanceOf[ReferenceCell] &&
        table.getCell(cell.asInstanceOf[ReferenceCell].ix,
          cell.asInstanceOf[ReferenceCell].iy).contains(this)
      case _ => false
    }
  }
}