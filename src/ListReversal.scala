import scala.annotation.tailrec

/**
 * Provide an algorithm to reverse a singly linked-list.
 *
 * @author Chris Campo
 */
object ListReversal {

  def main(args: Array[String]) = {
    val list = Node('O', Some(Node('R', Some(Node('L', Some(Node('A', Some(Node('N', Some(Node('D', Some(Node('O', None)))))))))))))
    val reversed = reverse(list)
    printList(reversed)
  }

  case class Node(value: Char, next: Option[Node])

  def reverse(head: Node): Node = {
    @tailrec
    def reverse(list: Node, result: Option[Node]): Node = {
      list.next match {
        case None => Node(list.value, result)
        case Some(node) => reverse(node, Some(Node(list.value, result)))
      }
    }
    reverse(head, None)
  }

  def printList(list: Node): Unit = {
    print(list.value)
    list.next foreach printList
  }
}
