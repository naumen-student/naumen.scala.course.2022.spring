sealed trait Cell {
    def toString: String
}

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
            case None => "outOfRange"
            case Some(cell: ReferenceCell) if isCyclic(cell) => "cyclic"
            case Some(cell) => cell.toString
        }
    }

    private def getReferencedCell: Option[Cell] = table.getCell(ix, iy)

    private def isCyclic(referencedCell: ReferenceCell): Boolean = {
        referencedCell.ix == ix && referencedCell.iy == iy
    }
}
