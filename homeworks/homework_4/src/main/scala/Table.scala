class Table(width: Int, height: Int) {

  private val table: Array[Cell] = Array.fill(width * height) {
    new EmptyCell
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = if (!isInRange(ix, iy)) None
  else Option(table(ix + iy * width))

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (isInRange(ix, iy))
      table(ix + iy * width) = cell
  }

  private def isInRange(ix: Int, iy: Int): Boolean =
    ix < width && iy < height && ix >= 0 && iy >= 0

}
