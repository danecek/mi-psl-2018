package rac

import scala.annotation.tailrec

object Main {

  def main(args: Array[String]) {
    println(Rac(1, 2) * Rac(3, 4))
    println(Rac(1, 2) == Rac(2, 4))
    println(2 * Rac(3, 4))
    println(Rac(3, 4)*2)
    println(-Rac(3, 4))
  }
}

class Rac(n: Int, d: Int) {

  def *(that: Rac): Rac = {
    Rac(nm * that.nm, dn * that.dn)
  }
  def *(that: Int): Rac = {
    Rac(nm * that, dn)
  }

  def unary_- : Rac = Rac(-n, d)
  import Rac.gcd
  val nm = n / gcd(n, d)
  val dn = d / gcd(n, d)

  override def toString: String = s"Rac($nm,$dn)"

  override def equals(th: scala.Any): Boolean = {
    if (isInstanceOf[Rac]) {
      val that = th.asInstanceOf[Rac]
      this.nm == that.nm && this.dn == that.dn
    }
    else false
  }
}

object Rac {

  def apply(n: Int, d: Int): Rac = new Rac(n, d)

  implicit def int2Rac(i: Int): Rac = Rac(i, 1)

  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a
  else gcd(b, a % b)

}


