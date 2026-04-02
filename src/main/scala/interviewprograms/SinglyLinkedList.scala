package interviewprograms

/**
 * Singly Linked List Implementation
 * 
 * A singly linked list is a linear data structure where each node contains data
 * and a reference to the next node. The last node points to None/null.
 */

case class Node(data: Int, var next: Option[Node] = None) {
  override def toString: String = data.toString
}

class SinglyLinkedList {
  var head: Option[Node] = None

  /**
   * Insert a value at the beginning of the linked list
   */
  def insertAtBeginning(value: Int): Unit = {
    val newNode = Node(value)
    newNode.next = head
    head = Some(newNode)
  }

  /**
   * Insert a value at the end of the linked list
   */
  def insertAtEnd(value: Int): Unit = {
    val newNode = Node(value)
    if (head.isEmpty) {
      head = Some(newNode)
    } else {
      var current = head
      while (current.get.next.nonEmpty) {
        current = current.get.next
      }
      current.get.next = Some(newNode)
    }
  }

  /**
   * Insert a value at a specific position (0-indexed)
   */
  def insertAtPosition(value: Int, position: Int): Unit = {
    if (position < 0) {
      println("Invalid position")
      return
    }
    
    if (position == 0) {
      insertAtBeginning(value)
      return
    }

    var current = head
    var count = 0

    while (current.nonEmpty && count < position - 1) {
      current = current.get.next
      count += 1
    }

    if (current.isEmpty) {
      println("Position out of bounds")
      return
    }

    val newNode = Node(value)
    newNode.next = current.get.next
    current.get.next = Some(newNode)
  }

  /**
   * Delete a node with a specific value
   */
  def delete(value: Int): Unit = {
    if (head.isEmpty) {
      println("List is empty")
      return
    }

    // If head needs to be deleted
    if (head.get.data == value) {
      head = head.get.next
      return
    }

    var current = head
    while (current.get.next.nonEmpty) {
      if (current.get.next.get.data == value) {
        current.get.next = current.get.next.get.next
        return
      }
      current = current.get.next
    }

    println(s"Value $value not found in the list")
  }

  /**
   * Display all elements in the linked list
   */
  def display(): Unit = {
    var current = head
    print("List: ")
    while (current.nonEmpty) {
      print(s"${current.get.data} -> ")
      current = current.get.next
    }
    println("null")
  }

  /**
   * Convert linked list to a list for easy comparison in tests
   */
  def toList(): List[Int] = {
    var result = scala.collection.mutable.ListBuffer[Int]()
    var current = head
    while (current.nonEmpty) {
      result += current.get.data
      current = current.get.next
    }
    result.toList
  }

  /**
   * Get the length of the linked list
   */
  def length(): Int = {
    var count = 0
    var current = head
    while (current.nonEmpty) {
      count += 1
      current = current.get.next
    }
    count
  }

  /**
   * Reverse the singly linked list (iterative approach)
   */
  def reverse(): Unit = {
    var prev: Option[Node] = None
    var current = head
    var next: Option[Node] = None

    while (current.nonEmpty) {
      // Store the next node
      next = current.get.next
      // Reverse the link
      current.get.next = prev
      // Move prev and current one step forward
      prev = current
      current = next
    }

    // Update head to point to the new first node
    head = prev
  }

  /**
   * Reverse the linked list recursively
   */
  def reverseRecursive(): Unit = {
    def reverseHelper(node: Option[Node]): Option[Node] = {
      if (node.isEmpty || node.get.next.isEmpty) {
        node
      } else {
        val rest = reverseHelper(node.get.next)
        node.get.next.get.next = node
        node.get.next = None
        rest
      }
    }

    head = reverseHelper(head)
  }

  /**
   * Search for a value in the linked list
   */
  def search(value: Int): Boolean = {
    var current = head
    while (current.nonEmpty) {
      if (current.get.data == value) {
        return true
      }
      current = current.get.next
    }
    false
  }
}

object LinkedListDemo {
  def main(args: Array[String]): Unit = {
    val list = new SinglyLinkedList()

    // Insert elements
    println("=== Inserting elements ===")
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.insertAtEnd(40)
    list.display()

    println("\n=== Insert at beginning ===")
    list.insertAtBeginning(5)
    list.display()

    println("\n=== Insert at position 2 ===")
    list.insertAtPosition(15, 2)
    list.display()

    println("\n=== Delete 20 ===")
    list.delete(20)
    list.display()

    println("\n=== List length ===")
    println(s"Length: ${list.length()}")

    println("\n=== Search for 30 ===")
    println(s"Found 30: ${list.search(30)}")

    println("\n=== Reverse the list ===")
    list.reverse()
    list.display()
  }
}
