import scala.annotation.tailrec

trait Cell

case class EmptyCell() extends Cell {
    override def toString: String = "empty"
}

case class NumberCell(number: Int) extends Cell {
    override def toString: String = number.toString
}

case class StringCell(text: String) extends Cell {
    override def toString: String = text
}

case class ReferenceCell(xi: Int, yi: Int, table: Table) extends Cell {
    override def toString: String = resolveReference(this, List.empty)
    
    private final def getReference : Option[Cell] = table.getCell(xi, yi)
    
    @tailrec
    private final def resolveReference(cell: ReferenceCell, references: List[ReferenceCell]) : String =
        cell.getReference match {
            case Some(x) => x match {
                case y: ReferenceCell => if (references.contains(y)) "cyclic" else resolveReference(y, cell :: references)
                case _ => x.toString
            }
            case None => "outOfRange"
        }
}