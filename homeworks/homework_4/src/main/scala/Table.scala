import scala.collection.mutable.ArrayBuffer

case class Table(width: Int, height: Int) {
  private val cells: ArrayBuffer[Cell] = ArrayBuffer.fill(width * height)(EmptyCell())

  def getCell(x: Int, y: Int): Option[Cell] = {
    if (isCellInBounds(x, y))
      Some(cells(x + y * width))
    else
      None
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    if(isCellInBounds(x, y))
      cells(x + y * width) = cell
  }

  private def isCellInBounds(x: Int, y: Int): Boolean =
    x < width && y < height && x >= 0 && y >= 0
}