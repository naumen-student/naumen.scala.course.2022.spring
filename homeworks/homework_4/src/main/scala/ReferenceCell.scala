class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = {
    referenceCellToString(Seq[ReferenceCell]())
  }

  def referenceCellToString(referenceList: Seq[ReferenceCell]): String = {
    val cell = table.getCell(ix, iy)
    if (cell.isEmpty) {
      return "outOfRange"
    }
    if (referenceList.contains(this)) {
      return "cyclic"
    }
    cell.get match {
      case referenceCell: ReferenceCell =>
        referenceCell.referenceCellToString(referenceList ++ Seq(this))
      case _ =>
        cell.get.toString
    }
  }
}
