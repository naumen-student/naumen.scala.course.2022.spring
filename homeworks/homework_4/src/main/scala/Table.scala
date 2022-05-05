import scala.collection.mutable

class Table(width: Int, height: Int) {

  var cells: mutable.Seq[Cell] = mutable.Seq.fill(width * height)(EmptyCell())

  def getCell(ix: Int, iy: Int) = cells.lift(ix + iy * width)

  def setCell(ix: Int, iy: Int, cell: Cell) = cells(ix + iy * width) = cell

}