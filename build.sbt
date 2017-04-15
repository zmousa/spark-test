name := "SparkTest"

version := "1.0"

scalaVersion := "2.10.5"


libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-mllib_2.10" % "1.6.2"
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "3.0.1"
libraryDependencies += "com.holdenkarau" % "spark-testing-base_2.10" % "1.6.2_0.6.0"


libraryDependencies += "junit" % "junit" % "4.12"

test in assembly := {}

// super important with multiple tests running spark Contexts
parallelExecution in Test := false