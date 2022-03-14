import scala.collection.mutable

class Table(private val width: Int, private val height: Int){
  private val DefaultCell = new EmptyCell

  private val Cells: mutable.Map[(Int, Int), Cell] = mutable.Map[(Int, Int), Cell]()

  def getCell(x: Int, y: Int): Option[Cell] = {
    if (!inBorders(x, y))
      return None

    if(!Cells.contains(x, y))
      return Some(DefaultCell)

    Cells.get((x, y))
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    if (inBorders(x, y))
      Cells.put((x, y), cell)
  }

  private def inBorders(x: Int, y: Int): Boolean = x < width && y < height && x > -1 && y > -1
}