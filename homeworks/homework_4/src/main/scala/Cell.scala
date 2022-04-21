trait Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString: String = {
    "empty"
  }
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = {
    number.toString
  }
}

class StringCell(str: String) extends Cell {
  override def toString: String = {
    str
  }
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  private def getTable(): Table = {
    table
  }

  private def getIX(): Int = {
    ix
  }

  private def getIY(): Int = {
    iy
  }

  override def toString: String = {
    if (ix < 0 || ix >= table.getWidth || iy < 0 || iy >= table.getHeight) {
      return "outOfRange"
    }
    var referedCell = table.getCell(ix, iy).get
    if (referedCell.isInstanceOf[ReferenceCell]) {
      val referedX = referedCell.asInstanceOf[ReferenceCell].getIX()
      val referedY = referedCell.asInstanceOf[ReferenceCell].getIY()
      if (table.getCell(referedX, referedY).get == this) {
        return "cyclic"
      }
    }
    return referedCell.toString
  }
}