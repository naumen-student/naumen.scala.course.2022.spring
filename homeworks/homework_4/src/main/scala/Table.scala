class Table(width: Int, height: Int){
  private val array: Array[Cell] = new Array[Cell](width*height).map(_ => new EmptyCell())

  private def getIndex(ix: Int, iy: Int) : Int = ix + iy * width

  private def inBounds(ix: Int, iy: Int)  = ix < width && ix > -1 && iy < height && iy > -1

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (inBounds(ix, iy)) Some(array(getIndex(ix, iy))) else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell) = {
    if (inBounds(ix, iy)) array(getIndex(ix, iy)) = cell;
  }
}