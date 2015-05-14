

/**
 * Algorithms to compute the sum of a sequence. I used type-classes to handle generic numeric types.
 *
 * @author Chris Campo
 */
object Sum {

  def sumRecursive[N: Numeric](numbers: Seq[N]): N = {
    if (numbers.isEmpty) implicitly[Numeric[N]].zero
    else implicitly[Numeric[N]].plus(numbers.head, sumRecursive(numbers.tail))
  }

  def sumTailRecursive[N: Numeric](numbers: Seq[N]): N = {
    @annotation.tailrec
    def sumTailRecursive(numbers: Seq[N], sum: N): N = {
      if (numbers.isEmpty) sum
      else sumTailRecursive(numbers.tail, implicitly[Numeric[N]].plus(sum, numbers.head))
    }
    sumTailRecursive(numbers, implicitly[Numeric[N]].zero)
  }

  def sumIterative[N: Numeric](numbers: Seq[N]): N = {
    var sum = implicitly[Numeric[N]].zero
    for (n <- numbers) sum = implicitly[Numeric[N]].plus(sum, n)
    sum
  }
}
