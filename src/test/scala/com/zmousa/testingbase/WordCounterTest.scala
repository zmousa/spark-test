package com.zmousa.testingbase

import com.holdenkarau.spark.testing.{RDDComparisons, RDDGenerator, SharedSparkContext}
import org.apache.spark.rdd.RDD
import org.scalacheck.Arbitrary
import org.scalacheck.Prop._
import org.scalatest.prop.Checkers
import org.scalatest.{FlatSpec, Matchers}

class WordCounterTest  extends FlatSpec with Matchers with SharedSparkContext with Checkers with RDDComparisons{

  behavior of "Words counter"

  it should "count words in a text" in {
    val text =
      """Hello Spark
        |Hello world
      """.stripMargin
    val inputRdd: RDD[String] = sc.parallelize(List(text))
    val expectedRdd: RDD[(String, Int)] = sc.parallelize(List(("Hello", 2), ("Spark", 1), ("world", 1)))

    val resRdd: RDD[(String, Int)] = WordCounter.count(inputRdd)
    assert(None === compareRDD(resRdd, expectedRdd))
  }

  it should "have stable count, with generated RDDs" in {
    val stableProperty =
      forAll(RDDGenerator.genRDD[String](sc)(Arbitrary.arbitrary[String])) {
        rdd => None === compareRDD(WordCounter.count(rdd), WordCounter.count(rdd))
      }

    check(stableProperty)
  }
}
