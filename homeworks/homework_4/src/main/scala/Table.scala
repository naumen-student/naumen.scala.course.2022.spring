import scala.collection.mutable

class Table(width:Int, height:Int) {

  val cells: mutable.Seq[Cell] =
    mutable.Seq.fill(width * height)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix < width && ix >=0 && iy >= 0 && iy < height)
      Option(cells(ix + iy * width))
    else
      None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (ix < width && ix >=0 && iy >= 0 && iy < height)
      cells(ix + iy * width) = cell
  }
}