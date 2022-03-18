class Table(width: Int, height: Int){
  private val array: Array[Cell] = new Array[Cell](width * height).map(_ => new EmptyCell())

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (inBorders(ix, iy)) Some(array(getIndex(ix, iy))) else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell) = {
    if (inBorders(ix, iy)) array(getIndex(ix, iy)) = cell;
  }

  private def getIndex(ix: Int, iy: Int) : Int = ix + iy * width

  private def inBorders(ix: Int, iy: Int)  = ix < width && ix > -1 && iy < height && iy > -1
}