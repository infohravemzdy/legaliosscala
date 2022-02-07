package org.hravemzdy.legalios.protokols
  
import org.hravemzdy.legalios.factories.IProviderFactory
import org.hravemzdy.legalios.interfaces.IProps
import org.hravemzdy.legalios.providers.IPropsProvider
import org.hravemzdy.legalios.service.types.Period
import java.io.{File, FileWriter}
import java.nio.file.Paths

object ProtokolBaseTest {
  val __test_protokol_file__ = true

  val PROTOKOL_FOLDER_PATH = "../../../test_values"
  val PROTOKOL_FOLDER_NAME = "test_values"
  val PARENT_PROTOKOL_FOLDER_NAME = "legalios"

  def ExportPropsIntFile[B <: IPropsProvider[P], P <: IProps](fileName : String, minYear: Int, maxYear: Int, sut: IProviderFactory[P], func: (P) => Int) = {
    if (ProtokolBaseTest.__test_protokol_file__) {
      var testProtokol = createProtokolFile(fileName)

      try {
        exportPropsStart(testProtokol)

        for (testYear <- minYear to maxYear) {
          exportPropsIntLine[B, P](testProtokol, testYear, sut, func)
        }
      } finally {
        exportPropsClose(testProtokol)
      }
    }
  }

  def exportPropsIntLine[B <: IPropsProvider[P], P <: IProps](protokol: FileWriter, testYear: Int, sut: IProviderFactory[P], func: (P) => Int) : Unit = {
    exportPropsYear(protokol, testYear)

    for (testMonth <- 1 to 12) {
      val testPeriod = Period.getWithYearMonth(testYear, testMonth)
      val testResult: P = sut.getProps(testPeriod)
      var testValue: Int = func(testResult)
      exportPropsValue(protokol, testValue)
    }

    exportPropsEnd(protokol)
  }

  def exportPropsValue(protokol: FileWriter, value: Int) : Unit = {
    protokol.write(s"\t$value")
  }

  def ExportPropsDecFile[B <: IPropsProvider[P], P <: IProps](fileName : String, minYear: Int, maxYear: Int, sut: IProviderFactory[P], func: (P) => BigDecimal) : Unit = {
    if (__test_protokol_file__) {
      var testProtokol = createProtokolFile(fileName)

      try {
        exportPropsStart(testProtokol)

        for (testYear <- minYear to maxYear) {
          exportPropsDecLine[B, P](testProtokol, testYear, sut, func)
        }
      } finally {
        exportPropsClose(testProtokol)
      }
    }
  }

  def exportPropsDecLine[B <: IPropsProvider[P], P <: IProps](protokol: FileWriter, testYear: Int, sut: IProviderFactory[P], func: (P) => BigDecimal) = {
    exportPropsYear(protokol, testYear)

    for (testMonth <- 1 to 12) {
      val testPeriod = Period.getWithYearMonth(testYear, testMonth)
      val testResult: P = sut.getProps(testPeriod)
      var testValue: BigDecimal = func(testResult)
      exportPropsValue(protokol, testValue)
    }

    exportPropsEnd(protokol)
  }

  def exportPropsValue(protokol: FileWriter, value: BigDecimal)  = {
    val intValue: Int = (value*BigDecimal(100)).toInt
    protokol.write(s"\t$intValue")
  }

  def createProtokolFile(fileName : String): FileWriter  = {
    var currPath = Paths.get(".").toAbsolutePath()
    while (!currPath.endsWith(PARENT_PROTOKOL_FOLDER_NAME) || currPath.getNameCount()==1) {
      currPath = currPath.getParent()
    }
    val basePath = Paths.get(currPath.toString(), PROTOKOL_FOLDER_NAME)
    val path = Paths.get(basePath.toString(), fileName).toAbsolutePath().toString()
    return new FileWriter(new File(path))
  }

  def exportPropsClose(protokol: FileWriter)  = {
    protokol.flush()
    protokol.close()
  }

  def exportPropsStart(protokol: FileWriter)  = {
    protokol.write("")

    protokol.write("YEAR")
    for (testMonth <- 1 to 12) {
      protokol.write(s"\t$testMonth")
    }
    protokol.write(s"\n")
  }

  def exportPropsYear(protokol: FileWriter, value: Int) = {
    protokol.write(s"$value")
  }

  def exportPropsEnd(protokol: FileWriter) = {
    protokol.write(s"\n")
  }
}



