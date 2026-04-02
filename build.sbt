name := "etlAIUseCasesLearning"
version := "0.1.0"
scalaVersion := "2.12.15"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.3.0",
  "org.apache.spark" %% "spark-sql" % "3.3.0",
  // Testing framework
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "com.holdenkarau" %% "spark-testing-base" % "3.3.0_1.3.1" % Test
)

javaOptions ++= Seq(
  "-Xmx4g",
  "-Xms1g"
)
