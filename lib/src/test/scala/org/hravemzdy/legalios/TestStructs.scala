package org.hravemzdy.legalios

import org.hravemzdy.legalios.interfaces.{IBundleProps, IProps}
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.scalatest.funspec.AnyFunSpec

case class TestYearsScenario(minYear: Int, maxYear: Int)
case class TestYearExpParams(testName: String, testYear: Int, testMonth: Int, resultYear: Int)
case class TestYearExpScenario(testTitle: String, tests: Iterable[TestYearExpParams])
case class TestPeriodParams(title: String, year: Int, month: Int)
case class TestPeriodScenario(title: String, tests: List[TestPeriodParams])

case class TestDecParams(testName: String, testYear: Int, testMonth: Int, resultYear: Int, resultMonth: Int, resultValue: BigDecimal) {
  def testBasicResult(test: AnyFunSpec, result: Either[HistoryResultError, IBundleProps], bundle: IBundleProps, props: IProps, error: HistoryResultError) : Unit = {
  }
  def resultValueDec(): BigDecimal = {
    val intValue: Int = (resultValue*100).setScale(0).toInt
    return BigDecimal(intValue) / (BigDecimal(100))
  }
}
case class TestDecScenario(testTitle: String, tests: Iterable[TestDecParams])

case class TestIntParams(testName: String, testYear: Int, testMonth: Int, resultYear: Int, resultMonth: Int, resultValue: Int) {
  def testBasicResult(test: AnyFunSpec, result: Either[HistoryResultError, IBundleProps], bundle: IBundleProps, props: IProps, error: HistoryResultError) : Unit = {
  }
}
case class TestIntScenario(testTitle: String, tests: Iterable[TestIntParams])
