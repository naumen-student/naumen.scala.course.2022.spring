import scala.collection.mutable

class Table(val width: Int, val height: Int){

  var cells: mutable.Seq[Cell] = mutable.Seq.fill(width * height)(EmptyCell())

  def getCell(ix: Int, iy: Int) = {
    if( 0 <= ix && ix < width && 0 <= iy && iy < height)
      Option(cells(ix + iy * width))
    else
      None
  }

  def setCell(ix: Int, iy: Int, cell: Cell) = {
    if( 0 <= ix && ix < width && 0 <= iy && iy < height)
      cells(ix + iy * width) = cell
  }
}