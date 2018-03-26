package elems

import scala.annotation.tailrec

object Main {

  def main(args: Array[String]): Unit = {
    println(new ListElem(List("xyz", "abc")))
    println(new CharElem('x', 5, 2) above new CharElem('y', 5, 3))
  }

}

class CharElem(c : Char, w : Int, h : Int) extends Elem  {

  private val line = c.toString * w
  val content: List[String] =  List.fill(h)(line)//
   //  (for (i <- 1 to h) yield line).toList

}

abstract class Elem {

  def above(that : Elem) : Elem = {
    new ListElem(content ++ that.content)
  }


  val content : List[String]

  def w : Int = content.head.size
  def h : Int = content.size

  override def toString: String = content.mkString("\n")
// @tailrec
  private def join(a:List[String], b : List[String]) : List[String] = {
    if (a.isEmpty || b.isEmpty) Nil
    else (a.head ++ b.head) :: join(a.tail, b.tail)
  }

  def beside(that : Elem) : Elem = {
    new ListElem(join(content, that.content))
  }


}



class ListElem(cont : List[String]) extends Elem {
    val content = cont
}

