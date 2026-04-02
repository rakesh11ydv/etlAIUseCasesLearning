import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql.{Dataset, Row}
import org.scalatest.funsuite.AnyFunSuite

class MainTestSuite extends AnyFunSuite with DataFrameSuiteBase {

  test("Create and validate a simple DataFrame") {
    import spark.implicits._

    // Create test data
    val testDF = Seq(1, 2, 3).toDF("value")

    // Verify the content
    assert(testDF.count() === 3)
    assert(testDF.columns === Array("value"))
  }

  test("Compare DataFrames for equality") {
    import spark.implicits._

    val expectedDF = Seq(
      (1, "a"),
      (2, "b"),
      (3, "c")
    ).toDF("id", "name")

    val actualDF = Seq(
      (1, "a"),
      (2, "b"),
      (3, "c")
    ).toDF("id", "name")

    // assertDataFrameEquals compares both schema and data
    assertDataFrameEquals(expectedDF, actualDF)
  }

  test("Test Dataset operations") {
    import spark.implicits._

    case class Person(id: Int, name: String, age: Int)

    val testDataset = Seq(
      Person(1, "Alice", 25),
      Person(2, "Bob", 30),
      Person(3, "Charlie", 35)
    ).toDS()

    // Filter and verify
    val filtered = testDataset.filter(_.age > 25)
    assert(filtered.count() === 2)

    // Collect and verify content
    val results = filtered.collect().map(_.name)
    assert(results.toList === List("Bob", "Charlie"))
  }

  test("Test Scala collections") {
    val numbers = List(1, 2, 3, 4, 5)
    val doubled = numbers.map(_ * 2)
    
    assert(doubled === List(2, 4, 6, 8, 10))
    assert(doubled.sum === 30)
  }

  test("Test DataFrame transformations") {
    import spark.implicits._

    val df = Seq(
      (1, 100),
      (2, 200),
      (3, 300)
    ).toDF("id", "value")

    val result = df
      .filter($"value" > 150)
      .select("id")

    val expected = Seq(2, 3).toDF("id")
    
    assertDataFrameEquals(expected, result)
  }

  test("Test aggregations on DataFrame") {
    import spark.implicits._

    val df = Seq(
      ("A", 10),
      ("B", 20),
      ("A", 15),
      ("B", 25)
    ).toDF("group", "amount")

    val result = df.groupBy("group").sum("amount")
    
    // Verify result has correct structure
    assert(result.count() === 2)
    assert(result.columns.contains("group"))
  }
}
