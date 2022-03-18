import Array.ofDim

class Table(rowsCount :Int, columnsCount :Int) {
  private val table = ofDim[Cell](rowsCount, columnsCount)
  for (ix <- 0 until columnsCount) {
    for (iy <- 0 until rowsCount) {
      table(iy)(ix) = new EmptyCell
    }
  }

  def getCell(ix: Int, iy: Int) :Option[Cell] = {
    if (!checkIndexes(ix, iy)) {
      return None
    }
    Some(table(iy)(ix))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (!checkIndexes(ix, iy)) {
      throw new IndexOutOfBoundsException()
    }
    table(iy)(ix) = cell
  }

  private def checkIndexes(ix: Int, iy: Int): Boolean = {
    ix >= 0 && ix < columnsCount && iy >= 0 && iy < rowsCount
  }
}
