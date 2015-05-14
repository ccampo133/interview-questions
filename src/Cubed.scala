/**
 * Provide algorithms to compute the number of invisible cubes in
 * a cube that has been cut `n` times. Also provide an algorithm to
 * give the total number of cubes.
 *
 * @author Chris Campo
 */
object Cubed {
  def getCubeCount(n: Int): Int = Math.pow(n, 3).toInt
  def getInvisibleCubeCount(n: Int): Int = Math.pow(n - 2, 3).toInt
}
