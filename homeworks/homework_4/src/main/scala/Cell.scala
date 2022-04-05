trait Cell {
  def toString: String;
}

class EmptyCell() extends Cell {
  override def toString: String = "empty";
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString;
}

class StringCell(string: String) extends Cell {
  override def toString: String = string;
}

class ReferenceCell(val ix: Int, val iy: Int, val table: Table) extends Cell {
  override def toString: String = table.getCell(ix, iy) match {
    case None => "outOfRange";
    case Some(referenceCell: ReferenceCell) =>
      if (referenceCell.table.getCell(referenceCell.ix, referenceCell.iy).contains(this)) {
        "cyclic";
      } else {
        referenceCell.toString;
      }
    case Some(cell: Cell) => cell.toString;
  }
}