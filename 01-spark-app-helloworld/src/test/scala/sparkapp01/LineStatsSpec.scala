package sparkapp01

import org.scalatest.FunSpec

class LineStatsSpec extends FunSpec with SparkSessionTestWrapper {

  it("should count the A line and B lines correctly") {
    val logData = spark.read.textFile(getClass.getClassLoader.getResource("test_file.txt").getPath()).cache()
    val (numAs, numBs) = LineStats.countLinesWithLetterAAndLetterB(logData);
    assert(numAs == 6)
    assert(numBs == 1)
  }

}
