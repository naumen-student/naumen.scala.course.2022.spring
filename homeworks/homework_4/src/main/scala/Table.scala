import scala.collection.mutable

class Table(val width: Int,
            val height: Int) {
    val Cells: mutable.Seq[Cell] =
        mutable.Seq.fill(width * height)(new EmptyCell)

    def getCell(ix: Int, iy: Int): Option[Cell] = {
        if (ensureIndexesInRange(ix, iy))
            Option(Cells(ix + iy * width))
        else
            None
    }

    def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
        if (ensureIndexesInRange(ix, iy)) {
            Cells(ix + iy * width) = cell
        }
    }

    private def ensureIndexesInRange(ix: Int, iy: Int): Boolean = {
        ix >= 0 && ix < width && iy >= 0 && iy < height
    }
}
