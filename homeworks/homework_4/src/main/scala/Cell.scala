trait Cell {
}

class EmptyCell extends Cell {
  override def toString = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {

  private def getReferencedCell: Option[Cell] = {
    var currentCell: ReferenceCell = this

    do {
      val nextCell = table.getCell(currentCell.ix, currentCell.iy)
      if (nextCell.isEmpty)
        return None
      if (!nextCell.get.isInstanceOf[ReferenceCell])
        return nextCell
      currentCell = nextCell.get.asInstanceOf[ReferenceCell]
    } while (currentCell != this)
    Some(this)
  }

  override def toString: String = {
    val refCell = getReferencedCell

    if (refCell.isEmpty)
      "outOfRange"
    else if (refCell.get == this)
      "cyclic"
    else refCell.get.toString
  }
}