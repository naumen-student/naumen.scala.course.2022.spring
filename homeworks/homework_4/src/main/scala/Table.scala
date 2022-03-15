import scala.collection.mutable

class Table(width: Int, height: Int) {
    private val cells: mutable.MutableList[Cell] = mutable.MutableList.fill(width * height)(EmptyCell())
    
    def getCell(xi: Int, yi: Int) : Option[Cell] = getIndex(xi, yi).flatMap(cells.get)
    
    def setCell(xi: Int, yi: Int, cell: Cell) : Unit = getIndex(xi, yi).foreach(cells.update(_, cell))
    
    private final def getIndex(xi: Int, yi: Int) : Option[Int] = for {
        x <- ValidateSize(xi, width)
        y <- ValidateSize(yi, height)
    } yield x + y * width

    private final def ValidateSize(x: Int, max: Int): Option[Int] =
        if (0 <= x && x < max) Some(x) else None
}