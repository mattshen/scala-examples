package sparkapp01

import org.scalatest.FunSpec

class HelloWorldSpec extends FunSpec with SparkSessionTestWrapper {

  import spark.implicits._

  it("should appends a greeting column to a DataFram") {
    val sourceDF = Seq(
      ("matt"),
      ("john")
    ).toDF("name")

    val actualDF = sourceDF.transform(HelloWorld.withGreeting())

    assert(actualDF.columns.containsSlice(Array("name", "greeting")))

  }

}
