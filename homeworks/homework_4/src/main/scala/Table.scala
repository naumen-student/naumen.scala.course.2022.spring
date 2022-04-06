import scala.collection.mutable.ArrayBuffer


class Table(val width: Int, val length: Int) {
    private var cellsCollection = ArrayBuffer.fill[Cell](width * length)(new EmptyCell)

    def getCell(ix: Int, iy: Int): Option[Cell] = 
      if (ix >= 0 && ix <= width && iy >= 0 && iy <= length) 
        Option(cellsCollection(ix + iy * width))
      else None
      
    
    def setCell(ix: Int, iy: Int, cell: Cell): Unit =
      if (ix >= 0 && ix <= width && iy >= 0 && iy <= length) 
        cellsCollection(ix + iy * width) = cell
}