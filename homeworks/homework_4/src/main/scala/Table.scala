import scala.collection.mutable

class Table(val width: Int, val height: Int) {

  val Cells: mutable.Seq[Cell] =
    mutable.Seq.fill(width * height)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (isInTableRange(ix, iy))
      Option(Cells(getIndex(ix, iy)))
    else
      None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (isInTableRange(ix, iy)) {
      Cells(getIndex(ix, iy)) = cell
    }
  }

  private def isInTableRange(ix: Int, iy: Int): Boolean = {
    ix >= 0 && ix < width &&
      iy >= 0 && iy < height
  }

  private def getIndex(ix: Int, iy: Int): Int = ix + iy * width
}
