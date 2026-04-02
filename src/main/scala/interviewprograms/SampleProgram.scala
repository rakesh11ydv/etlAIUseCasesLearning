package interviewprograms

/**
 * Sample program to demonstrate the interviewprograms package
 */
object SampleProgram {
  
  /**
   * Example: Find the sum of all even numbers in a list
   */
  def sumOfEvens(numbers: List[Int]): Int = {
    numbers.filter(_ % 2 == 0).sum
  }

  /**
   * Example: Reverse a list
   */
  def reverseList[T](list: List[T]): List[T] = {
    list.reverse
  }

  /**
   * Example: Check if a number is prime
   */
  def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else if (n == 2) true
    else if (n % 2 == 0) false
    else (3 to Math.sqrt(n).toInt by 2).forall(n % _ != 0)
  }

  def main(args: Array[String]): Unit = {
    println(s"Sum of evens in [1, 2, 3, 4, 5]: ${sumOfEvens(List(1, 2, 3, 4, 5))}")
    println(s"Reverse of [1, 2, 3, 4]: ${reverseList(List(1, 2, 3, 4))}")
    println(s"Is 7 prime? ${isPrime(7)}")
  }
}
