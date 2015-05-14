/**
 * Show how to implement a simple binary tree, and provide an
 * algorithm to compute the maximum depth of said tree.
 *
 * @author Chris Campo
 */
object BinaryTree {

  sealed abstract class Tree

  case class Node[T](value: T, left: Tree, right: Tree) extends Tree

  case class Leaf[T](value: T) extends Tree

  def main(args: Array[String]) = {
    val tree = Node("0", Node("1", Node("2", Leaf("3"), Leaf("3")), Leaf("2")), Leaf("1"))
    println(maxDepth(tree))
  }

  def maxDepth(tree: Tree): Int = tree match {
    case Leaf(v) => 0
    case Node(v, l, r) =>
      val leftDepth = maxDepth(l)
      val rightDepth = maxDepth(r)
      if (leftDepth > rightDepth) leftDepth + 1 else rightDepth + 1
  }
}
