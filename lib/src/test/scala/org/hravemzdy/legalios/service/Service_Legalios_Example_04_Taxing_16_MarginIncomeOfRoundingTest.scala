package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.{TestIntParams, TestIntScenario}
import org.hravemzdy.legalios.interfaces.{IBundleProps, IPropsTaxing}
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.service.types.Period
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Service_Legalios_Example_04_Taxing_16_MarginIncomeOfRoundingTest extends AnyFunSpec {
  val testList = List(
    TestIntScenario("2010", List(
      TestIntParams( "2010-1", 2010, 1, 2010, 1, 100 ),
      TestIntParams( "2010-2", 2010, 2, 2010, 2, 100 ),
      TestIntParams( "2010-3", 2010, 3, 2010, 3, 100 ),
      TestIntParams( "2010-4", 2010, 4, 2010, 4, 100 ),
      TestIntParams( "2010-5", 2010, 5, 2010, 5, 100 ),
      TestIntParams( "2010-6", 2010, 6, 2010, 6, 100 ),
      TestIntParams( "2010-7", 2010, 7, 2010, 7, 100 ),
      TestIntParams( "2010-8", 2010, 8, 2010, 8, 100 ),
      TestIntParams( "2010-9", 2010, 9, 2010, 9, 100 ),
      TestIntParams( "2010-10", 2010, 10, 2010, 10, 100 ),
      TestIntParams( "2010-11", 2010, 11, 2010, 11, 100 ),
      TestIntParams( "2010-12", 2010, 12, 2010, 12, 100 ),
    )),
    TestIntScenario("2011", List(
      TestIntParams( "2011-1", 2011, 1, 2011, 1, 100 ),
      TestIntParams( "2011-2", 2011, 2, 2011, 2, 100 ),
      TestIntParams( "2011-3", 2011, 3, 2011, 3, 100 ),
      TestIntParams( "2011-4", 2011, 4, 2011, 4, 100 ),
      TestIntParams( "2011-5", 2011, 5, 2011, 5, 100 ),
      TestIntParams( "2011-6", 2011, 6, 2011, 6, 100 ),
      TestIntParams( "2011-7", 2011, 7, 2011, 7, 100 ),
      TestIntParams( "2011-8", 2011, 8, 2011, 8, 100 ),
      TestIntParams( "2011-9", 2011, 9, 2011, 9, 100 ),
      TestIntParams( "2011-10", 2011, 10, 2011, 10, 100 ),
      TestIntParams( "2011-11", 2011, 11, 2011, 11, 100 ),
      TestIntParams( "2011-12", 2011, 12, 2011, 12, 100 ),
    )),
    TestIntScenario("2012", List(
      TestIntParams( "2012-1", 2012, 1, 2012, 1, 100 ),
      TestIntParams( "2012-2", 2012, 2, 2012, 2, 100 ),
      TestIntParams( "2012-3", 2012, 3, 2012, 3, 100 ),
      TestIntParams( "2012-4", 2012, 4, 2012, 4, 100 ),
      TestIntParams( "2012-5", 2012, 5, 2012, 5, 100 ),
      TestIntParams( "2012-6", 2012, 6, 2012, 6, 100 ),
      TestIntParams( "2012-7", 2012, 7, 2012, 7, 100 ),
      TestIntParams( "2012-8", 2012, 8, 2012, 8, 100 ),
      TestIntParams( "2012-9", 2012, 9, 2012, 9, 100 ),
      TestIntParams( "2012-10", 2012, 10, 2012, 10, 100 ),
      TestIntParams( "2012-11", 2012, 11, 2012, 11, 100 ),
      TestIntParams( "2012-12", 2012, 12, 2012, 12, 100 ),
    )),
    TestIntScenario("2013", List(
      TestIntParams( "2013-1", 2013, 1, 2013, 1, 100 ),
      TestIntParams( "2013-2", 2013, 2, 2013, 2, 100 ),
      TestIntParams( "2013-3", 2013, 3, 2013, 3, 100 ),
      TestIntParams( "2013-4", 2013, 4, 2013, 4, 100 ),
      TestIntParams( "2013-5", 2013, 5, 2013, 5, 100 ),
      TestIntParams( "2013-6", 2013, 6, 2013, 6, 100 ),
      TestIntParams( "2013-7", 2013, 7, 2013, 7, 100 ),
      TestIntParams( "2013-8", 2013, 8, 2013, 8, 100 ),
      TestIntParams( "2013-9", 2013, 9, 2013, 9, 100 ),
      TestIntParams( "2013-10", 2013, 10, 2013, 10, 100 ),
      TestIntParams( "2013-11", 2013, 11, 2013, 11, 100 ),
      TestIntParams( "2013-12", 2013, 12, 2013, 12, 100 ),
    )),
    TestIntScenario("2014", List(
      TestIntParams( "2014-1", 2014, 1, 2014, 1, 100 ),
      TestIntParams( "2014-2", 2014, 2, 2014, 2, 100 ),
      TestIntParams( "2014-3", 2014, 3, 2014, 3, 100 ),
      TestIntParams( "2014-4", 2014, 4, 2014, 4, 100 ),
      TestIntParams( "2014-5", 2014, 5, 2014, 5, 100 ),
      TestIntParams( "2014-6", 2014, 6, 2014, 6, 100 ),
      TestIntParams( "2014-7", 2014, 7, 2014, 7, 100 ),
      TestIntParams( "2014-8", 2014, 8, 2014, 8, 100 ),
      TestIntParams( "2014-9", 2014, 9, 2014, 9, 100 ),
      TestIntParams( "2014-10", 2014, 10, 2014, 10, 100 ),
      TestIntParams( "2014-11", 2014, 11, 2014, 11, 100 ),
      TestIntParams( "2014-12", 2014, 12, 2014, 12, 100 ),
    )),
    TestIntScenario("2015", List(
      TestIntParams( "2015-1", 2015, 1, 2015, 1, 100 ),
      TestIntParams( "2015-2", 2015, 2, 2015, 2, 100 ),
      TestIntParams( "2015-3", 2015, 3, 2015, 3, 100 ),
      TestIntParams( "2015-4", 2015, 4, 2015, 4, 100 ),
      TestIntParams( "2015-5", 2015, 5, 2015, 5, 100 ),
      TestIntParams( "2015-6", 2015, 6, 2015, 6, 100 ),
      TestIntParams( "2015-7", 2015, 7, 2015, 7, 100 ),
      TestIntParams( "2015-8", 2015, 8, 2015, 8, 100 ),
      TestIntParams( "2015-9", 2015, 9, 2015, 9, 100 ),
      TestIntParams( "2015-10", 2015, 10, 2015, 10, 100 ),
      TestIntParams( "2015-11", 2015, 11, 2015, 11, 100 ),
      TestIntParams( "2015-12", 2015, 12, 2015, 12, 100 ),
    )),
    TestIntScenario("2016", List(
      TestIntParams( "2016-1", 2016, 1, 2016, 1, 100 ),
      TestIntParams( "2016-2", 2016, 2, 2016, 2, 100 ),
      TestIntParams( "2016-3", 2016, 3, 2016, 3, 100 ),
      TestIntParams( "2016-4", 2016, 4, 2016, 4, 100 ),
      TestIntParams( "2016-5", 2016, 5, 2016, 5, 100 ),
      TestIntParams( "2016-6", 2016, 6, 2016, 6, 100 ),
      TestIntParams( "2016-7", 2016, 7, 2016, 7, 100 ),
      TestIntParams( "2016-8", 2016, 8, 2016, 8, 100 ),
      TestIntParams( "2016-9", 2016, 9, 2016, 9, 100 ),
      TestIntParams( "2016-10", 2016, 10, 2016, 10, 100 ),
      TestIntParams( "2016-11", 2016, 11, 2016, 11, 100 ),
      TestIntParams( "2016-12", 2016, 12, 2016, 12, 100 ),
    )),
    TestIntScenario("2017", List(
      TestIntParams( "2017-1", 2017, 1, 2017, 1, 100 ),
      TestIntParams( "2017-2", 2017, 2, 2017, 2, 100 ),
      TestIntParams( "2017-3", 2017, 3, 2017, 3, 100 ),
      TestIntParams( "2017-4", 2017, 4, 2017, 4, 100 ),
      TestIntParams( "2017-5", 2017, 5, 2017, 5, 100 ),
      TestIntParams( "2017-6", 2017, 6, 2017, 6, 100 ),
      TestIntParams( "2017-7", 2017, 7, 2017, 7, 100 ),
      TestIntParams( "2017-8", 2017, 8, 2017, 8, 100 ),
      TestIntParams( "2017-9", 2017, 9, 2017, 9, 100 ),
      TestIntParams( "2017-10", 2017, 10, 2017, 10, 100 ),
      TestIntParams( "2017-11", 2017, 11, 2017, 11, 100 ),
      TestIntParams( "2017-12", 2017, 12, 2017, 12, 100 ),
    )),
    TestIntScenario("2018", List(
      TestIntParams( "2018-1", 2018, 1, 2018, 1, 100 ),
      TestIntParams( "2018-2", 2018, 2, 2018, 2, 100 ),
      TestIntParams( "2018-3", 2018, 3, 2018, 3, 100 ),
      TestIntParams( "2018-4", 2018, 4, 2018, 4, 100 ),
      TestIntParams( "2018-5", 2018, 5, 2018, 5, 100 ),
      TestIntParams( "2018-6", 2018, 6, 2018, 6, 100 ),
      TestIntParams( "2018-7", 2018, 7, 2018, 7, 100 ),
      TestIntParams( "2018-8", 2018, 8, 2018, 8, 100 ),
      TestIntParams( "2018-9", 2018, 9, 2018, 9, 100 ),
      TestIntParams( "2018-10", 2018, 10, 2018, 10, 100 ),
      TestIntParams( "2018-11", 2018, 11, 2018, 11, 100 ),
      TestIntParams( "2018-12", 2018, 12, 2018, 12, 100 ),
    )),
    TestIntScenario("2019", List(
      TestIntParams( "2019-1", 2019, 1, 2019, 1, 100 ),
      TestIntParams( "2019-2", 2019, 2, 2019, 2, 100 ),
      TestIntParams( "2019-3", 2019, 3, 2019, 3, 100 ),
      TestIntParams( "2019-4", 2019, 4, 2019, 4, 100 ),
      TestIntParams( "2019-5", 2019, 5, 2019, 5, 100 ),
      TestIntParams( "2019-6", 2019, 6, 2019, 6, 100 ),
      TestIntParams( "2019-7", 2019, 7, 2019, 7, 100 ),
      TestIntParams( "2019-8", 2019, 8, 2019, 8, 100 ),
      TestIntParams( "2019-9", 2019, 9, 2019, 9, 100 ),
      TestIntParams( "2019-10", 2019, 10, 2019, 10, 100 ),
      TestIntParams( "2019-11", 2019, 11, 2019, 11, 100 ),
      TestIntParams( "2019-12", 2019, 12, 2019, 12, 100 ),
    )),
    TestIntScenario("2020", List(
      TestIntParams( "2020-1", 2020, 1, 2020, 1, 100 ),
      TestIntParams( "2020-2", 2020, 2, 2020, 2, 100 ),
      TestIntParams( "2020-3", 2020, 3, 2020, 3, 100 ),
      TestIntParams( "2020-4", 2020, 4, 2020, 4, 100 ),
      TestIntParams( "2020-5", 2020, 5, 2020, 5, 100 ),
      TestIntParams( "2020-6", 2020, 6, 2020, 6, 100 ),
      TestIntParams( "2020-7", 2020, 7, 2020, 7, 100 ),
      TestIntParams( "2020-8", 2020, 8, 2020, 8, 100 ),
      TestIntParams( "2020-9", 2020, 9, 2020, 9, 100 ),
      TestIntParams( "2020-10", 2020, 10, 2020, 10, 100 ),
      TestIntParams( "2020-11", 2020, 11, 2020, 11, 100 ),
      TestIntParams( "2020-12", 2020, 12, 2020, 12, 100 ),
    )),
    TestIntScenario("2021", List(
      TestIntParams( "2021-1", 2021, 1, 2021, 1, 100 ),
      TestIntParams( "2021-2", 2021, 2, 2021, 2, 100 ),
      TestIntParams( "2021-3", 2021, 3, 2021, 3, 100 ),
      TestIntParams( "2021-4", 2021, 4, 2021, 4, 100 ),
      TestIntParams( "2021-5", 2021, 5, 2021, 5, 100 ),
      TestIntParams( "2021-6", 2021, 6, 2021, 6, 100 ),
      TestIntParams( "2021-7", 2021, 7, 2021, 7, 100 ),
      TestIntParams( "2021-8", 2021, 8, 2021, 8, 100 ),
      TestIntParams( "2021-9", 2021, 9, 2021, 9, 100 ),
      TestIntParams( "2021-10", 2021, 10, 2021, 10, 100 ),
      TestIntParams( "2021-11", 2021, 11, 2021, 11, 100 ),
      TestIntParams( "2021-12", 2021, 12, 2021, 12, 100 ),
    )),
    TestIntScenario("2022", List(
      TestIntParams( "2022-1",  2022,  1, 2022,  1,100 ),
      TestIntParams( "2022-2",  2022,  2, 2022,  2,100 ),
      TestIntParams( "2022-3",  2022,  3, 2022,  3,100 ),
      TestIntParams( "2022-4",  2022,  4, 2022,  4,100 ),
      TestIntParams( "2022-5",  2022,  5, 2022,  5,100 ),
      TestIntParams( "2022-6",  2022,  6, 2022,  6,100 ),
      TestIntParams( "2022-7",  2022,  7, 2022,  7,100 ),
      TestIntParams( "2022-8",  2022,  8, 2022,  8,100 ),
      TestIntParams( "2022-9",  2022,  9, 2022,  9,100 ),
      TestIntParams( "2022-10", 2022, 10, 2022, 10, 100 ),
      TestIntParams( "2022-11", 2022, 11, 2022, 11, 100 ),
      TestIntParams( "2022-12", 2022, 12, 2022, 12, 100 ),
    )),
  )
  // 04_Taxing_15_MarginIncomeOfRounding
  ServiceExampleBase.logTestIntExamples("04_Taxing_16_MarginIncomeOfRounding.txt", testList)
  testList.foreach { tx =>
    describe(s"year ${tx.testTitle}") {
      tx.tests.foreach { tt =>
        describe(s"period ${tt.testName}") {
          val period = Period.getWithYearMonth(tt.testYear, tt.testMonth)
          val service = new ServiceLegalios()
          val result: Either[HistoryResultError, IBundleProps] = service.getBundle(period)
          val bundle: IBundleProps = result match {
            case Left(error) => null
            case Right(value) => value
          }
          val error: HistoryResultError = result match {
            case Left(error) => error
            case Right(value) => null
          }
          val props: IPropsTaxing = result match {
            case Left(error) => null
            case Right(value) => value.taxingProps
          }
          it("GetProps should return error = null") {
            assert(error == null)
          }
          it("GetProps should return result = success") {
            assert(result.isRight)
          }
          it("GetProps should return props not be nil") {
            assert(bundle != null)
          }
          it(s"GetProps should return getPeriodYear = ${tt.resultYear} and getPeriodMonth = ${tt.resultMonth}") {
            assert(tt.resultYear == bundle.getPeriodYear())
            assert(tt.resultMonth == bundle.getPeriodMonth())
          }
          it("GetProps should return healthProps not to be nil") {
            assert(props != null)
          }
          it(s"GetProps should return value = ${tt.resultValue}") {
            assert(tt.resultValue == props.marginIncomeOfRounding)
          }
        }
      }
    }
  }
}

