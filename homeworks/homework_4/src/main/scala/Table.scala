class Table(width: Int, height: Int) {
  require(width >= 0, "width must be not negative")
  require(height >= 0, "height must be not negative")
  private var tableVector: Vector[Cell] = Vector.fill(width * height)(EmptyCell())
  def getCell(ix: Int, iy: Int): Option[Cell] = if (inTable(ix, iy)) Some(tableVector(toVectorIndex(ix, iy))) else None
  def setCell(ix: Int, iy: Int, cell: Cell): Unit =
    if (inTable(ix, iy)) tableVector = tableVector.updated(toVectorIndex(ix, iy), cell)
    else throw new IndexOutOfBoundsException()
  def inTable(ix: Int, iy: Int): Boolean = 0 <= ix && ix < width && 0 <= iy && iy < height
  private def toVectorIndex(ix: Int, iy: Int): Int = ix + iy * height
}
