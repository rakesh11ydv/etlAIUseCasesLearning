package interviewprograms

import org.scalatest.funsuite.AnyFunSuite

class SampleProgramTest extends AnyFunSuite {

  test("sumOfEvens should return sum of even numbers") {
    val result = SampleProgram.sumOfEvens(List(1, 2, 3, 4, 5, 6))
    assert(result === 12) // 2 + 4 + 6 = 12
  }

  test("sumOfEvens should return 0 for list with no even numbers") {
    val result = SampleProgram.sumOfEvens(List(1, 3, 5))
    assert(result === 0)
  }

  test("reverseList should reverse a list") {
    val result = SampleProgram.reverseList(List(1, 2, 3, 4))
    assert(result === List(4, 3, 2, 1))
  }

  test("reverseList should work with strings") {
    val result = SampleProgram.reverseList(List("a", "b", "c"))
    assert(result === List("c", "b", "a"))
  }

  test("isPrime should identify prime numbers") {
    assert(SampleProgram.isPrime(2) === true)
    assert(SampleProgram.isPrime(3) === true)
    assert(SampleProgram.isPrime(5) === true)
    assert(SampleProgram.isPrime(7) === true)
    assert(SampleProgram.isPrime(11) === true)
  }

  test("isPrime should identify non-prime numbers") {
    assert(SampleProgram.isPrime(0) === false)
    assert(SampleProgram.isPrime(1) === false)
    assert(SampleProgram.isPrime(4) === false)
    assert(SampleProgram.isPrime(6) === false)
    assert(SampleProgram.isPrime(8) === false)
  }
}
