/**
 * @author Chris Campo
 */
object MissingNumbers {

  def getMissing(n: Int, set: Set[Int]): Int = (1 to n).find(!set.contains(_)).getOrElse(0)

  def getMissingAlgebraically(n: Int, set: Set[Int]): Int = (1 to n).sum - set.sum
}
