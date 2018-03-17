/**
  * Created by danecek on 5/4/17.
  */
object Main {

  def isSafe(row: Int, queenRows: List[Int], d: Int): Boolean = {
    queenRows match {
      case Nil => true
      case h :: t => {
        if ((queenRows contains (row + d)) || (queenRows contains (row - d))) false
        else isSafe(row, t, d + 1)
      }
    }
  }


def queens(n: Int): List[List[Int]] = {
  def placeQueens(k: Int): List[List[Int]] =
    if (k == 0) List(List())
    else for {queenRows <- placeQueens(k - 1)
              row <- 1 to n // List.range(1, n + 1)
              if isSafe(row, queenRows, 0)
    } yield row :: queenRows

  placeQueens(n)
}

def main(args: Array[String]): Unit = {
  println(queens(3))
}
}
