import scala.collection.mutable

class Table(width: Int, height: Int) {
  private val table: mutable.Seq[Cell] = mutable.Seq.fill(width * height)(new EmptyCell)

  def inTableBounds(ix: Int, iy: Int): Boolean = {
    ix >= 0 && ix < width && iy >= 0 && iy < height
  }

  def getCell(ix : Int, iy: Int): Option[Cell] = {
    if (inTableBounds(ix, iy))
      Option(table(ix + iy * width))
    else
      None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (inTableBounds(ix, iy))
      table(ix + iy * width) = cell
  }
}
