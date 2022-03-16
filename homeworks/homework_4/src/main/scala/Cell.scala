trait Cell {
    def toString(): String
}

class EmptyCell extends Cell {
    override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
    override def toString: String = s"$number"
}

class StringCell(string: String) extends Cell {
    override def toString: String = string
}

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {
    override def toString: String = table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(cell) if (cell.isInstanceOf[ReferenceCell] &&
                          table.getCell(cell.asInstanceOf[ReferenceCell].ix,
                                        cell.asInstanceOf[ReferenceCell].iy) == Some(this)) => "cyclic"
      case Some(cell) => cell.toString
    }
}
