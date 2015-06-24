/**
 * @author Chris Campo
 */
object ZeroTwoOneHundred extends App {
  iterative()
  tailRecursive()

  def iterative(): Unit = {
    for (i <- 0 to 100) {
      println(100 - i)
    }
  }

  def tailRecursive(): Unit = {
    @annotation.tailrec
    def tailRecursive(i: Int): Unit = {
      if (i < 0) return
      println(i)
      tailRecursive(i - 1)
    }
    tailRecursive(100)
  }
}
