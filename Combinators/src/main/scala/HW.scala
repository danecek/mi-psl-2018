import scala.util.parsing.combinator.JavaTokenParsers

object HW extends JavaTokenParsers {

  def wholeNumberValue: Parser[Int] = wholeNumber ^^ (_.toInt)

  def signedNumberValue: Parser[Int] = ("+" | "-") ~ wholeNumberValue ^^
    { case ~("+", x) => x
      case ~("-", x) => -x
    }

  def expr: Parser[Int] = (wholeNumberValue ~ rep(signedNumberValue)) ^^ //
    ((parseRes : ~[Int, List[Int]]) => parseRes._2.foldLeft(parseRes._1) { (acc, elem) => acc + elem })


  def main(args: Array[String]): Unit = {
    val r: ParseResult[Any] = parseAll(expr, "3+4-2-10+11")
    println(r)  }

}
