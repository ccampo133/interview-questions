/**
 * Provide an algorithm to reverse a string, or character array, in place.
 *
 * @author Chris Campo
 */
object StringReversal {

  def main(args: Array[String]) = {
    val string = Array('O', 'R', 'L', 'A', 'N', 'D', 'O')
    printReverse(string)
  }

  def printReverse(s: Array[Char]): Unit = {
    for (i <- 0 until s.length) {
      val temp = s(i)
      s(i) = s(s.length - 1 - i)
      s(s.length - 1 - i) = temp
    }
    s foreach print
  }
}
