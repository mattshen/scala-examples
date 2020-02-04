package sparkapp01

import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logFile = s"${System.getenv().get("SPARK_HOME")}/README.md" // Should be some file on your system
    val logData = spark.read.textFile(logFile).cache()

    val (numAs, numBs) = LineStats.countLinesWithLetterAAndLetterB(logData);
    println(s"Lines with a: $numAs, Lines with b: $numBs")

    spark.stop()
  }
}
