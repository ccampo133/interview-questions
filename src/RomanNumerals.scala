/**
 * @author Chris Campo
 */
object RomanNumerals {

  val numerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

  def toInt(n: String): Int = {
    case class Item(total: Int, prev: Int)
    n.foldRight(Item(0, 0)) { case (c, Item(total, prev)) =>
      val cur = numerals(c)
      if (cur >= prev) Item(total + cur, cur) else Item(total - cur, cur)
    }.total
  }
}
