import scala.annotation.tailrec

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
  override def toString: String = resolveReference(this, List.empty)

  private final def getReference: Option[Cell] = table.getCell(ix, iy)

  @tailrec
  private final def resolveReference(cell: ReferenceCell, references: List[ReferenceCell]): String =
    cell.getReference match {
      case Some(x) => x match {
        case y: ReferenceCell => if (references.contains(y)) "cyclic" else resolveReference(y, cell :: references)
        case _ => x.toString
      }
      case None => "outOfRange"
    }
}
