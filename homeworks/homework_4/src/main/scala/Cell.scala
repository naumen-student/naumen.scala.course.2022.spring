trait Cell

class EmptyCell extends Cell {
    override def toString: String = "empty"
}

class NumberCell(val value: Int) extends Cell {
    override def toString: String = value.toString
}

class StringCell(val value: String) extends Cell {
    override def toString: String = value
}

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {

    override def toString: String = {
        table.getCell(ix, iy) match {
            case Some(cell: ReferenceCell) =>
                if (table.getCell(cell.ix, cell.iy).get == this) "cyclic" else cell.toString
            case Some(cell) => cell.toString
            case None => "outOfRange"
        }
    }
}
