/**
 * Algorithms to compute the sum of a sequence. I used type-classes to handle generic numeric types.
 *
 * @author Chris Campo
 */
object Sum {

  def sumRecursive[N: Numeric](numbers: Seq[N]): N = {
    if (numbers.size == 1) numbers.head
    else implicitly[Numeric[N]].plus(numbers.head, sumRecursive(numbers.tail))
  }

  def sumTailRecursive[N: Numeric](numbers: Seq[N], sum: N): N = {
    if (numbers.size == 0) sum
    else sumTailRecursive(numbers.tail, implicitly[Numeric[N]].plus(sum, numbers.head))
  }

  def sumIterative[N: Numeric](numbers: Seq[N]): N = {
    var sum = implicitly[Numeric[N]].fromInt(0)
    for (n <- numbers) sum = implicitly[Numeric[N]].plus(sum, n)
    sum
  }
}
