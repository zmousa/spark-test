Spark Test
==========
This project collect multiple unit tests for different spark components and within different testing libraries.

Project Source
--------------
   * `WordCounter.scala`: Spark job
   * `CoreUnitTest.scala`: unit test for Spark core statements using scalatest library.
   * `SqlUnitTest.scala`: unit test for Spark SQL using scalatest library.
   * `StreamingUnitTest.scala`: unit test for Spark Streaming using scalatest library.
   * `WordCounterTest.scala`: unit test for Spark job using spark-testing-base library.


Dependencies
------------
   * [scala-test](http://www.scalatest.org/)
   * [spark-testing-base](https://github.com/holdenk/spark-testing-base)
   * [SparkUnitTestingExamples](https://github.com/tmalaska/SparkUnitTestingExamples)