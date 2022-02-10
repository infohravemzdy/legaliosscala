package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.{TestDecScenario, TestIntScenario}
import org.hravemzdy.legalios.interfaces.{IBundleProps, IProps}
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.scalatest.funspec.AnyFunSpec

import java.io.{File, FileWriter}
import java.nio.file.Paths

object ServiceExampleBase {
  val __test_examples_file__ = true

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
    if (__test_examples_file__) {
      var testLogger = createLoggerFile(fileName)

      try {
        logTestStart(testLogger)
        tests.foreach { tx =>
          logTestYear(testLogger, tx.testTitle)
          tx.tests.foreach { tt =>
            logExampleIntValue(testLogger, tt.resultValue)
          }
          logTestEnd(testLogger)
        }
      } finally {
        closeLoggerFile(testLogger)
      }
    }
  }

  def logExampleDecValue(protokol: FileWriter, value: BigDecimal): Unit = {
    val intValue: Int = (value*100).toInt
    protokol.write(s"\t$intValue")
  }

  def logTestDecExamples(fileName : String, tests: List[TestDecScenario]): Unit = {
    if (__test_examples_file__) {
      var testLogger = createLoggerFile(fileName)

      try {
        logTestStart(testLogger)
        tests.foreach { tx =>
          logTestYear(testLogger, tx.testTitle)
          tx.tests.foreach { tt =>
            logExampleDecValue(testLogger, tt.resultValue)
          }
          logTestEnd(testLogger)
        }
      } finally {
        closeLoggerFile(testLogger)
      }
    }
  }
}
