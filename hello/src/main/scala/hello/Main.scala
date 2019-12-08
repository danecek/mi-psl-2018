package hello

import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {
    val rnd = for (i <- 0 to 20) yield Random.nextInt(100)
    println(mergeSort(rnd))
    println(selSort(rnd))
    println(s"Min: ${min(rnd)}")
  }

  def mergeSort(x: Seq[Int]): Seq[Int] = {

    def merge(left: Seq[Int], right: Seq[Int]): Seq[Int] = {
      if (left.isEmpty) right
      else if (right.isEmpty) left
      else if (left.head > right.head)
        left.head +: merge(left.tail, right)
      else
        right.head +: merge(left, right.tail)
    }
    if (x.size == 1) x
    else {
      val (left, right) = x.splitAt(x.size / 2)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  def min[T: Ordering](x: Seq[T]): Option[T] = {
    val ordering:Ordering[T] = implicitly[Ordering[T]]
    if (x.isEmpty) None
    else {
      val tailmin: Option[T] = min(x.tail)
      if (tailmin.isEmpty) Option(x.head)
      else {
        Option(ordering.min(x.head, tailmin.get))
      }
    }
  }

  def selSort[T: Ordering](x: Seq[T]): Seq[T] = {
    if (x.isEmpty) x
    else {
      val xmin: T = min(x).get
      val imin = x indexOf xmin
      val y = x.take(imin) ++ x.drop(imin + 1)
      xmin +: selSort(y)
    }
  }

}


