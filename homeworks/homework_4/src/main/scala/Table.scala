import scala.collection.mutable

class Table(private val width: Int, private val height: Int) {
  private val Cells = mutable.Map[(Int, Int), Cell]()

  def getCell(x: Int, y: Int): Option[Cell] = {
    if (!isIndexInTable(x, y))
      return None
    if (Cells.contains((x, y))) Cells.get((x, y))
    else Option(new EmptyCell)
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = if (isIndexInTable(x, y)) Cells.put((x, y), cell)

  private def isIndexInTable(ix: Int, iy: Int): Boolean = ix < width && ix >= 0 && iy < height && iy >= 0
}