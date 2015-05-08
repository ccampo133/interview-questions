/**
 * @author Chris Campo
 */
object Cubed {
  def getCubeCount(n: Int): Int = Math.pow(n, 3).toInt
  def getInvisibleCubeCount(n: Int): Int = Math.pow(n - 2, 3).toInt
}
