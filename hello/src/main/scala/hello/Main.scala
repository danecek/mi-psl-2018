package hello

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val rnd = for (i <- 0 to 10) yield Random.nextInt(100)


    println(mergeSort(rnd))
//    println(selSort(rnd))
//
//    println(min(rnd))
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

//  def min[T: Ordering](x: Seq[T])(implicit i: Ordering[T]): Option[T] = {
//
//    val i = implicitly[Ordering[T]]
//
//    if (x.isEmpty) None
//    else {
//      val o: Option[T] = min(x.tail)
//      if (o == None) Option(x.head)
//      else {
//        Option(i.min(x.head, o.get))
//      }
//    }
//  }
//
//  def selSort[T:Ordering](x: Seq[T]): Seq[T] = {
//    if (x.isEmpty) x
//    else {
//      val xmin : T = min(x).get
//      val imin = x indexOf (xmin)
//      val y = (x.take(imin) ++ x.drop(imin + 1))
//      selSort(y) :+ xmin
//    }
//  }


}

