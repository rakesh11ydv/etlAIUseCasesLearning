import org.scalatest.funsuite.AnyFunSuite

class CollectionTestSuite extends AnyFunSuite {

  test("Test List operations") {
    val list = List(1, 2, 3, 4, 5)
    
    assert(list.length === 5)
    assert(list.sum === 15)
    assert(list.map(_ * 2) === List(2, 4, 6, 8, 10))
  }

  test("Test Set operations") {
    val numbers = Set(1, 2, 3, 4, 5)
    val moreNumbers = Set(4, 5, 6, 7)
    
    assert(numbers.union(moreNumbers) === Set(1, 2, 3, 4, 5, 6, 7))
    assert(numbers.intersect(moreNumbers) === Set(4, 5))
  }

  test("Test Map operations") {
    val data = Map("a" -> 1, "b" -> 2, "c" -> 3)
    
    assert(data("a") === 1)
    assert(data.size === 3)
    assert(data.keys.toList.sorted === List("a", "b", "c"))
  }

  test("Test Seq operations") {
    val seq = Seq(1, 2, 2, 3, 3, 3)
    
    assert(seq.distinct === Seq(1, 2, 3))
    assert(seq.groupBy(identity).mapValues(_.length) === Map(1 -> 1, 2 -> 2, 3 -> 3))
  }

  test("Test collection filtering") {
    val numbers = List(1, 2, 3, 4, 5, 6)
    val evens = numbers.filter(_ % 2 == 0)
    
    assert(evens === List(2, 4, 6))
  }

  test("Test custom case class collections") {
    case class Item(id: Int, name: String, price: Double)
    
    val items = List(
      Item(1, "Apple", 0.5),
      Item(2, "Banana", 0.3),
      Item(3, "Orange", 0.4)
    )
    
    val expensive = items.filter(_.price > 0.35)
    assert(expensive.map(_.name) === List("Apple", "Orange"))
  }
}
