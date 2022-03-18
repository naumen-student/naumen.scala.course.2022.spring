import scala.collection.mutable

case class Table(width: Int, height: Int) {
  private val cells: mutable.MutableList[Cell] = mutable.MutableList.fill(width * height)(EmptyCell())

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (contains(ix, iy))
      Some(cells(getIndex(ix, iy)))
    else
      None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if(contains(ix, iy))
      cells(getIndex(ix, iy)) = cell
  }

  private def contains(ix: Int, iy: Int): Boolean = {
    ix < width && iy < height && ix >= 0 && iy >= 0
  }

  private def getIndex(ix: Int, iy: Int) = ix + iy * width
}