import scala.collection.mutable

class Table(width: Int, height: Int) {
 private val cells: mutable.MutableList[Cell] = mutable.MutableList.fill(width * height)(EmptyCell())
 def getCell(ix: Int, iy: Int) = cells.lift(ix + iy * width)
 def setCell(ix: Int, iy: Int, cell: Cell) = cells(ix + iy * width) = cell
} 
