class Table(width: Int, length: Int) {
  private val _cells: Array[Cell] = new Array[Cell](width * length).map(_ => EmptyCell())

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (_inBounds(ix, iy)) Some(_cells(_getIndex(ix, iy))) else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (_inBounds(ix, iy))
      _cells(_getIndex(ix, iy)) = cell
  }

  private def _getIndex(ix: Int, iy: Int): Int = ix + iy * width

  private def _inBounds(ix: Int, iy: Int): Boolean = {
    ix >= 0 && ix < width && iy >= 0 && iy < length
  }
}