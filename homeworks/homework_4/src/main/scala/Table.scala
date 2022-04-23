import scala.collection.mutable

class Table(private val height: Int, private val width: Int, private var data: mutable.Seq[Cell]) {

  def this(height: Int, width: Int) = {
    this(height, width, mutable.Seq.fill(height * width)(new EmptyCell()))
  }

  def getHeight: Int = {
    height
  }

  def getWidth: Int = {
    width
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix < 0 || ix >= width || iy < 0 || iy >= height) {
      return None
    }
    Option(data(iy * width + ix))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    data(width * iy + ix) = cell
  }
}