package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.interfaces.{IBundleProps, IProps}
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.scalatest.funspec.AnyFunSpec
import java.io.{File, FileWriter}
import java.nio.file.Paths

case class TestDecParams(title: String, year: Int, month: Int, expYear: Int, expMonth: Int, expected: Double) {
  def testBasicResult(test: AnyFunSpec, result: Either[HistoryResultError, IBundleProps], bundle: IBundleProps, props: IProps, error: HistoryResultError) : Unit = {
//    test.it("GetProps should return error = null") {
//      assertTrue(error == null)
//    }
//    test.it("GetProps should return result = success") {
//      assertTrue(result is Ok<IBundleProps>)
//    }
//    test.it("GetProps should return props not be nil") {
//      assertNotNull(bundle == null)
//    }
//    test.it("GetProps should return getPeriodYear = ${expYear} and getPeriodMonth = ${expMonth}") {
//      assertEquals(expYear, bundle?.getPeriodYear())
//      assertEquals(expMonth, bundle?.getPeriodMonth())
//    }
//    test.it("GetProps should return healthProps not to be nil") {
//      assertNotNull(props)
//    }
  }
  def expectedDec(): BigDecimal = {
    val intValue: Int = Math.round(expected*100).toInt
    return BigDecimal(intValue) / (BigDecimal(100))
  }
}
case class TestDecScenario(title: String, tests: List[TestDecParams])

case class TestIntParams(title: String, year: Int, month: Int, expYear: Int, expMonth: Int, expected: Int) {
  def testBasicResult(test: AnyFunSpec, result: Either[HistoryResultError, IBundleProps], bundle: IBundleProps, props: IProps, error: HistoryResultError) : Unit = {
    //    test.it("GetProps should return error = null") {
    //      assertTrue(error == null)
    //    }
    //    test.it("GetProps should return result = success") {
    //      assertTrue(result is Ok<IBundleProps>)
    //    }
    //    test.it("GetProps should return props not be nil") {
    //      assertNotNull(bundle == null)
    //    }
    //    test.it("GetProps should return getPeriodYear = ${expYear} and getPeriodMonth = ${expMonth}") {
    //      assertEquals(expYear, bundle?.getPeriodYear())
    //      assertEquals(expMonth, bundle?.getPeriodMonth())
    //    }
    //    test.it("GetProps should return healthProps not to be nil") {
    //      assertNotNull(props)
    //    }
  }
}
case class TestIntScenario(title: String, tests: List[TestIntParams])

object ServiceExampleBase {
  val __test_protokol_file__ = false

  val EXAMPLE_FOLDER_PATH = "../../../test_expected"
  val EXAMPLE_FOLDER_NAME = "test_expected"
  val PARENT_EXAMPLE_FOLDER_NAME = "legalios"

  def createLoggerFile(fileName : String): FileWriter = {
    var currPath = Paths.get(".").toAbsolutePath()
    while (!currPath.endsWith(PARENT_EXAMPLE_FOLDER_NAME) || currPath.getNameCount()==1) {
      currPath = currPath.getParent()
    }
    val basePath = Paths.get(currPath.toString(), EXAMPLE_FOLDER_NAME)
    val path = Paths.get(basePath.toString(), fileName).toAbsolutePath().toString()
    return new FileWriter(new File(path))
  }

  def closeLoggerFile(protokol: FileWriter): Unit = {
    protokol.flush()
    protokol.close()
  }

  def logTestStart(protokol: FileWriter): Unit = {
    protokol.write("")

    protokol.write("YEAR")
    for (testMonth <- 1 to 12) {
      protokol.write(s"\t$testMonth")
    }
    protokol.write("\n")
  }

  def logTestYear(protokol: FileWriter, value: String): Unit = {
    protokol.write(s"$value")
  }

  def logTestEnd(protokol: FileWriter): Unit = {
    protokol.write("\n")
  }

  def logExampleIntValue(protokol: FileWriter, value: Int): Unit = {
    protokol.write(s"\t$value")
  }

  def logTestIntExamples(fileName : String, tests: List[TestIntScenario]): Unit = {
    if (__test_protokol_file__) {
      var testLogger = createLoggerFile(fileName)

      try {
        logTestStart(testLogger)
        tests.foreach { tx =>
          logTestYear(testLogger, tx.title)
          tx.tests.foreach { tt =>
            logExampleIntValue(testLogger, tt.expected)
          }
          logTestEnd(testLogger)
        }
      } finally {
        closeLoggerFile(testLogger)
      }
    }
  }

  def logExampleDecValue(protokol: FileWriter, value: Double): Unit = {
    protokol.write(s"\t$value")
  }

  def logTestDecExamples(fileName : String, tests: List[TestDecScenario]): Unit = {
    if (__test_protokol_file__) {
      var testLogger = createLoggerFile(fileName)

      try {
        logTestStart(testLogger)
        tests.foreach { tx =>
          logTestYear(testLogger, tx.title)
          tx.tests.foreach { tt =>
            logExampleDecValue(testLogger, tt.expected)
          }
          logTestEnd(testLogger)
        }
      } finally {
        closeLoggerFile(testLogger)
      }
    }
  }
}
