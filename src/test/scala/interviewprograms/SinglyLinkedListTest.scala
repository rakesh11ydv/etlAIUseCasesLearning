package interviewprograms

import org.scalatest.funsuite.AnyFunSuite

class SinglyLinkedListTest extends AnyFunSuite {

  test("Create empty linked list") {
    val list = new SinglyLinkedList()
    assert(list.head.isEmpty)
    assert(list.length() === 0)
  }

  test("Insert at beginning") {
    val list = new SinglyLinkedList()
    list.insertAtBeginning(10)
    list.insertAtBeginning(5)
    assert(list.toList() === List(5, 10))
  }

  test("Insert at end") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    assert(list.toList() === List(10, 20, 30))
  }

  test("Insert at position") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.insertAtPosition(15, 1)
    assert(list.toList() === List(10, 15, 20, 30))
  }

  test("Insert at position 0") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtPosition(5, 0)
    assert(list.toList() === List(5, 10))
  }

  test("Delete first element") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.delete(10)
    assert(list.toList() === List(20, 30))
  }

  test("Delete middle element") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.delete(20)
    assert(list.toList() === List(10, 30))
  }

  test("Delete last element") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.delete(30)
    assert(list.toList() === List(10, 20))
  }

  test("Delete non-existent element") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.delete(50)
    assert(list.toList() === List(10, 20))
  }

  test("Get list length") {
    val list = new SinglyLinkedList()
    assert(list.length() === 0)
    list.insertAtEnd(10)
    assert(list.length() === 1)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    assert(list.length() === 3)
  }

  test("Search for element") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    assert(list.search(20) === true)
    assert(list.search(50) === false)
  }

  test("Reverse linked list (iterative)") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.insertAtEnd(40)
    list.reverse()
    assert(list.toList() === List(40, 30, 20, 10))
  }

  test("Reverse single element linked list") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.reverse()
    assert(list.toList() === List(10))
  }

  test("Reverse empty linked list") {
    val list = new SinglyLinkedList()
    list.reverse()
    assert(list.toList() === List())
  }

  test("Reverse linked list (recursive)") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.insertAtEnd(40)
    list.reverseRecursive()
    assert(list.toList() === List(40, 30, 20, 10))
  }

  test("Multiple operations on linked list") {
    val list = new SinglyLinkedList()
    list.insertAtEnd(10)
    list.insertAtEnd(20)
    list.insertAtEnd(30)
    list.insertAtPosition(15, 1)
    list.delete(20)
    assert(list.toList() === List(10, 15, 30))
    assert(list.length() === 3)
    list.reverse()
    assert(list.toList() === List(30, 15, 10))
  }

  test("Insert and reverse mixed operations") {
    val list = new SinglyLinkedList()
    list.insertAtBeginning(20)
    list.insertAtBeginning(10)
    list.insertAtEnd(30)
    assert(list.toList() === List(10, 20, 30))
    list.reverse()
    assert(list.toList() === List(30, 20, 10))
    list.insertAtBeginning(40)
    assert(list.toList() === List(40, 30, 20, 10))
  }
}
