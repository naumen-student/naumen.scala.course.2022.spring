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

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
    override def toString: String = {
        getReferencedCell match {
            case Some(_) if isCyclic => "cyclic"
            case Some(cell) => cell.toString
            case None => "outOfRange"
        }
    }

    private def getReferencedCell: Option[Cell] = table.getCell(ix, iy)

    private def isCyclic: Boolean = {
        getReferencedCell match {
            case Some(cell: ReferenceCell) =>
                cell.ix == ix && cell.iy == iy
            case _ => false
        }
    }
}
