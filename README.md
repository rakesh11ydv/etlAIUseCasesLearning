# etlAIUseCasesLearning

A Scala/Spark project for ETL use cases learning with local execution support.

## Prerequisites

- Java JDK 8 or 11
- Scala 2.12.15
- sbt 1.9.7+

## Build & Run

### Clean and Compile
```bash
sbt clean compile
```

### Run the Application
```bash
sbt run
```

### Run Tests
```bash
sbt test
```

### Run Specific Test Suite
```bash
sbt "testOnly MainTestSuite"
sbt "testOnly CollectionTestSuite"
```

### Package as JAR
```bash
sbt package
```

## Testing

This project includes comprehensive testing frameworks for Spark jobs:

### Testing Frameworks
- **ScalaTest** - Primary testing framework with multiple DSLs (FunSuite, WordSpec, etc.)
- **spark-testing-base** - Holden Karau's library for DataFrame/Dataset comparison utilities

### Test Capabilities
- ✅ DataFrame comparison and assertions
- ✅ Dataset testing with type safety
- ✅ Scala collection testing (List, Set, Map, Seq)
- ✅ Spark SQL transformations
- ✅ Aggregations and groupBy operations

### Test Files
- `src/test/scala/MainTestSuite.scala` - DataFrame, Dataset, and Spark SQL tests
- `src/test/scala/CollectionTestSuite.scala` - Scala collection tests

### Example Test Patterns

**DataFrame Comparison:**
```scala
val expected = Seq((1, "a")).toDF("id", "name")
val actual = Seq((1, "a")).toDF("id", "name")
assertDataFrameEquals(expected, actual)
```

**Dataset Testing:**
```scala
case class Person(id: Int, name: String)
val ds = Seq(Person(1, "Alice")).toDS()
assert(ds.count() === 1)
```

**Collection Testing:**
```scala
val list = List(1, 2, 3)
assert(list.map(_ * 2) === List(2, 4, 6))
```

## Configuration

- **Spark Master**: Configured for local mode with all available cores (`local[*]`)
- **JVM Memory**: Set to `-Xmx4g` (max 4GB) and `-Xms1g` (initial 1GB)
- **Logging**: Configured with log4j2.properties to reduce verbose output

## Project Structure

```
src/
├── main/
│   ├── scala/          # Scala source code
│   └── resources/      # Configuration files (log4j2.properties)
└── test/
    └── scala/          # Test code
```

## Dependencies

- Apache Spark 3.3.0 (Core & SQL)
- Scala 2.12.15

## Notes

- For local development, ensure your machine has sufficient RAM (minimum 2GB recommended)
- The `metastore_db/` directory is created locally during Spark execution and is excluded from git