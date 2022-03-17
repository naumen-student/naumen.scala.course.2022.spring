import scala.collection.mutable

class Table(private val width: Int, private val length: Int) {
  private val cells: mutable.MutableList[Cell] = mutable.MutableList.fill(width * length)(EmptyCell())

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (inBorders(ix, iy)) cells.get(getIndex(ix, iy)) else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
      if(inBorders(ix, iy)) cells.update(getIndex(ix, iy), cell)
  }

  def getIndex(x: Int, y: Int): Int = x + y * length

  def inBorders(x: Int, y: Int): Boolean = x >= 0 && y >= 0 && x < width && y < length
}