/**
 * @author Chris Campo
 */
object Fibonacci extends App {

  def fibRecursive(n: Int): Int = {
    if (n == 0 || n == 1) n
    else fibRecursive(n - 1) + fibRecursive(n - 2)
  }

  def fibTailRecursive(n: Int): Int = {
    @annotation.tailrec
    def fibTailRecursive(n: Int, a: Int, b: Int): Int = {
      if (n == 0) a
      else if (n == 1) b
      else fibTailRecursive(n - 1, b, a + b)
    }
    fibTailRecursive(n, 0, 1)
  }

  def fibIterative(n: Int): Int = {
    if (n == 0) return 0
    var a = 0
    var b = 1
    for (i <- 1 until n) {
      val tmp = b
      b = a + b
      a = tmp
    }
    b
  }
}
