/**
 * @author Chris Campo
 */
object QueueStack {

  // Represents a singly linked node
  case class Node[T](value: T, var next: Option[Node[T]])

  // Represents an immutable stack
  class Stack[T] private(head: Option[Node[T]]) {

    def this() = this(None)

    def push(value: T): Stack[T] = new Stack(Some(Node(value, head)))

    def pop: Stack[T] = new Stack(head flatMap (_.next))

    def getHead: Option[T] = head map (_.value)

    def isEmpty: Boolean = head.isEmpty

    override def toString: String = head.toString
  }

  // Represents an immutable queue with O(1) enqueue and average O(1) dequeue (worst case O(n))
  class Queue[T] private(forwards: Stack[T], backwards: Stack[T]) {

    def this() = this(new Stack[T], new Stack[T])

    def enqueue(value: T): Queue[T] = new Queue[T](forwards, backwards.push(value))

    def dequeue: Queue[T] = {
      val f = forwards.pop
      if (!f.isEmpty) new Queue[T](f, backwards)
      else if (backwards.isEmpty) new Queue[T]
      else new Queue[T](reverse(backwards).pop, new Stack[T])
    }

    def getHead: Option[T] = if (forwards.isEmpty) reverse(backwards).getHead else forwards.getHead

    override def toString: String = if (forwards.isEmpty) reverse(backwards).toString else forwards.toString

    private def reverse(stack: Stack[T]): Stack[T] = {
      @annotation.tailrec
      def reverse(stack: Stack[T], result: Stack[T]): Stack[T] = {
        stack.getHead match {
          case None => result
          case Some(value) => reverse(stack.pop, result.push(value))
        }
      }
      reverse(stack, new Stack[T])
    }
  }
}
