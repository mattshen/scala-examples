package sparkapp01

import org.apache.spark.sql.Dataset

object LineStats {

  def countLinesWithLetterAAndLetterB(logData: Dataset[String]): (Long, Long) = {
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    return (numAs, numBs)
  }
}
