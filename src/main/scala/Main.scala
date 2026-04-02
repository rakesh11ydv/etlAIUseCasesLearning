import org.apache.spark.sql.SparkSession

object Main {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("ETL AI Use Cases")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    Seq(1, 2, 3).toDS().show(false)
    // Your ETL logic here

    spark.stop()
  }
}
