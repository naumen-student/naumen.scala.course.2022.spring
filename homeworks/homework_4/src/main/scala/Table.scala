import scala.collection.mutable.ArrayBuffer

class Table(columns: Int, rows: Int) {
  private val cells = ArrayBuffer.fill[Cell](columns * rows)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    cells.lift(ix + iy * columns)
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (ix < 0 || ix >= columns || iy < 0 || iy >= rows)
      throw new IllegalArgumentException
    cells(ix + iy * columns) = cell
  }
}