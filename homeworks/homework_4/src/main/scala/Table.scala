import scala.collection.mutable;

class Table(val width: Int, val height: Int)
{
  var Cells: mutable.Seq[Cell] = mutable.Seq.fill(width*height)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = if (isInRange(ix, iy)) Option(Cells(ix + iy * width)) else None

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = if (isInRange(ix, iy)) Cells(ix + iy * width) = cell

  def isInRange(ix: Int, iy: Int): Boolean = (0 until width contains ix) && (0 until height contains iy)
}