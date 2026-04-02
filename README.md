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

### Package as JAR
```bash
sbt package
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