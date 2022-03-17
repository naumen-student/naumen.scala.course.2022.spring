class Table(width: Int, height: Int) {
  val cells: Array[Array[Cell]] = createTable

  def createTable: Array[Array[Cell]] = {
    val matrix = Array.ofDim[Cell](width, height)
    for (i <- 0 until width)
      for (j <- 0 until height) {
        matrix(i)(j) = new EmptyCell
      }
    matrix
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (0 <= ix && ix < width && 0 <= iy && iy < height)
      Some(cells(ix)(iy))
    else
      None

  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if ((ix >= 0 && ix < width) && (iy >= 0 && iy < height))
      cells(ix)(iy) = cell
  }
}