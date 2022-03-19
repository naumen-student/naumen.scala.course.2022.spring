package scala.collection.mutable

class Table(val width: Int, val height: Int) {
  private val table: Array[cell] = Array.fill[Cell](width * height)(new EmptyCell)

  def inBounds(ix: Int, iy: Int): Option[Boolean] = Some(ix > -1 && ix < width && iy > -1 && iy < height)filter(_ == true)

  def getCell(ix: Int, iy: Int): Option[Cell]= {
    inBounds(ix, iy).map(_ => table(ix + iy * width))
  }

  def SetCell(ix: Int, iy: Int, cell: Cell): Unit ={
    inBounds(ix, iy).foreach(_ => table(ix + iy * width) = cell)
  }
}