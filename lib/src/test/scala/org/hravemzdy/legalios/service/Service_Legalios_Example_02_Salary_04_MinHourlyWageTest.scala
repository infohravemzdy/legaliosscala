package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.interfaces.{IBundleProps, IPropsSalary}
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.service.types.Period
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Service_Legalios_Example_02_Salary_04_MinHourlyWageTest extends AnyFunSpec {
  val testList = List(
    TestIntScenario("2011", List(
      TestIntParams( "2011-1", 2011, 1, 2011, 1, 4810 ),
      TestIntParams( "2011-2", 2011, 2, 2011, 2, 4810 ),
      TestIntParams( "2011-3", 2011, 3, 2011, 3, 4810 ),
      TestIntParams( "2011-4", 2011, 4, 2011, 4, 4810 ),
      TestIntParams( "2011-5", 2011, 5, 2011, 5, 4810 ),
      TestIntParams( "2011-6", 2011, 6, 2011, 6, 4810 ),
      TestIntParams( "2011-7", 2011, 7, 2011, 7, 4810 ),
      TestIntParams( "2011-8", 2011, 8, 2011, 8, 4810 ),
      TestIntParams( "2011-9", 2011, 9, 2011, 9, 4810 ),
      TestIntParams( "2011-10", 2011, 10, 2011, 10, 4810 ),
      TestIntParams( "2011-11", 2011, 11, 2011, 11, 4810 ),
      TestIntParams( "2011-12", 2011, 12, 2011, 12, 4810 ),
    )),
    TestIntScenario("2012", List(
      TestIntParams( "2012-1", 2012, 1, 2012, 1, 4810 ),
      TestIntParams( "2012-2", 2012, 2, 2012, 2, 4810 ),
      TestIntParams( "2012-3", 2012, 3, 2012, 3, 4810 ),
      TestIntParams( "2012-4", 2012, 4, 2012, 4, 4810 ),
      TestIntParams( "2012-5", 2012, 5, 2012, 5, 4810 ),
      TestIntParams( "2012-6", 2012, 6, 2012, 6, 4810 ),
      TestIntParams( "2012-7", 2012, 7, 2012, 7, 4810 ),
      TestIntParams( "2012-8", 2012, 8, 2012, 8, 4810 ),
      TestIntParams( "2012-9", 2012, 9, 2012, 9, 4810 ),
      TestIntParams( "2012-10", 2012, 10, 2012, 10, 4810 ),
      TestIntParams( "2012-11", 2012, 11, 2012, 11, 4810 ),
      TestIntParams( "2012-12", 2012, 12, 2012, 12, 4810 ),
    )),
    TestIntScenario("2013", List(
      TestIntParams( "2013-1", 2013, 1, 2013, 1, 4810 ),
      TestIntParams( "2013-2", 2013, 2, 2013, 2, 4810 ),
      TestIntParams( "2013-3", 2013, 3, 2013, 3, 4810 ),
      TestIntParams( "2013-4", 2013, 4, 2013, 4, 4810 ),
      TestIntParams( "2013-5", 2013, 5, 2013, 5, 4810 ),
      TestIntParams( "2013-6", 2013, 6, 2013, 6, 4810 ),
      TestIntParams( "2013-7", 2013, 7, 2013, 7, 4810 ),
      TestIntParams( "2013-8", 2013, 8, 2013, 8, 5060 ),
      TestIntParams( "2013-9", 2013, 9, 2013, 9, 5060 ),
      TestIntParams( "2013-10", 2013, 10, 2013, 10, 5060 ),
      TestIntParams( "2013-11", 2013, 11, 2013, 11, 5060 ),
      TestIntParams( "2013-12", 2013, 12, 2013, 12, 5060 ),
    )),
    TestIntScenario("2014", List(
      TestIntParams( "2014-1", 2014, 1, 2014, 1, 5060 ),
      TestIntParams( "2014-2", 2014, 2, 2014, 2, 5060 ),
      TestIntParams( "2014-3", 2014, 3, 2014, 3, 5060 ),
      TestIntParams( "2014-4", 2014, 4, 2014, 4, 5060 ),
      TestIntParams( "2014-5", 2014, 5, 2014, 5, 5060 ),
      TestIntParams( "2014-6", 2014, 6, 2014, 6, 5060 ),
      TestIntParams( "2014-7", 2014, 7, 2014, 7, 5060 ),
      TestIntParams( "2014-8", 2014, 8, 2014, 8, 5060 ),
      TestIntParams( "2014-9", 2014, 9, 2014, 9, 5060 ),
      TestIntParams( "2014-10", 2014, 10, 2014, 10, 5060 ),
      TestIntParams( "2014-11", 2014, 11, 2014, 11, 5060 ),
      TestIntParams( "2014-12", 2014, 12, 2014, 12, 5060 ),
    )),
    TestIntScenario("2015", List(
      TestIntParams( "2015-1", 2015, 1, 2015, 1, 5500 ),
      TestIntParams( "2015-2", 2015, 2, 2015, 2, 5500 ),
      TestIntParams( "2015-3", 2015, 3, 2015, 3, 5500 ),
      TestIntParams( "2015-4", 2015, 4, 2015, 4, 5500 ),
      TestIntParams( "2015-5", 2015, 5, 2015, 5, 5500 ),
      TestIntParams( "2015-6", 2015, 6, 2015, 6, 5500 ),
      TestIntParams( "2015-7", 2015, 7, 2015, 7, 5500 ),
      TestIntParams( "2015-8", 2015, 8, 2015, 8, 5500 ),
      TestIntParams( "2015-9", 2015, 9, 2015, 9, 5500 ),
      TestIntParams( "2015-10", 2015, 10, 2015, 10, 5500 ),
      TestIntParams( "2015-11", 2015, 11, 2015, 11, 5500 ),
      TestIntParams( "2015-12", 2015, 12, 2015, 12, 5500 ),
    )),
    TestIntScenario("2016", List(
      TestIntParams( "2016-1", 2016, 1, 2016, 1, 5870 ),
      TestIntParams( "2016-2", 2016, 2, 2016, 2, 5870 ),
      TestIntParams( "2016-3", 2016, 3, 2016, 3, 5870 ),
      TestIntParams( "2016-4", 2016, 4, 2016, 4, 5870 ),
      TestIntParams( "2016-5", 2016, 5, 2016, 5, 5870 ),
      TestIntParams( "2016-6", 2016, 6, 2016, 6, 5870 ),
      TestIntParams( "2016-7", 2016, 7, 2016, 7, 5870 ),
      TestIntParams( "2016-8", 2016, 8, 2016, 8, 5870 ),
      TestIntParams( "2016-9", 2016, 9, 2016, 9, 5870 ),
      TestIntParams( "2016-10", 2016, 10, 2016, 10, 5870 ),
      TestIntParams( "2016-11", 2016, 11, 2016, 11, 5870 ),
      TestIntParams( "2016-12", 2016, 12, 2016, 12, 5870 ),
    )),
    TestIntScenario("2017", List(
      TestIntParams( "2017-1", 2017, 1, 2017, 1, 6600 ),
      TestIntParams( "2017-2", 2017, 2, 2017, 2, 6600 ),
      TestIntParams( "2017-3", 2017, 3, 2017, 3, 6600 ),
      TestIntParams( "2017-4", 2017, 4, 2017, 4, 6600 ),
      TestIntParams( "2017-5", 2017, 5, 2017, 5, 6600 ),
      TestIntParams( "2017-6", 2017, 6, 2017, 6, 6600 ),
      TestIntParams( "2017-7", 2017, 7, 2017, 7, 6600 ),
      TestIntParams( "2017-8", 2017, 8, 2017, 8, 6600 ),
      TestIntParams( "2017-9", 2017, 9, 2017, 9, 6600 ),
      TestIntParams( "2017-10", 2017, 10, 2017, 10, 6600 ),
      TestIntParams( "2017-11", 2017, 11, 2017, 11, 6600 ),
      TestIntParams( "2017-12", 2017, 12, 2017, 12, 6600 ),
    )),
    TestIntScenario("2018", List(
      TestIntParams( "2018-1", 2018, 1, 2018, 1, 7320 ),
      TestIntParams( "2018-2", 2018, 2, 2018, 2, 7320 ),
      TestIntParams( "2018-3", 2018, 3, 2018, 3, 7320 ),
      TestIntParams( "2018-4", 2018, 4, 2018, 4, 7320 ),
      TestIntParams( "2018-5", 2018, 5, 2018, 5, 7320 ),
      TestIntParams( "2018-6", 2018, 6, 2018, 6, 7320 ),
      TestIntParams( "2018-7", 2018, 7, 2018, 7, 7320 ),
      TestIntParams( "2018-8", 2018, 8, 2018, 8, 7320 ),
      TestIntParams( "2018-9", 2018, 9, 2018, 9, 7320 ),
      TestIntParams( "2018-10", 2018, 10, 2018, 10, 7320 ),
      TestIntParams( "2018-11", 2018, 11, 2018, 11, 7320 ),
      TestIntParams( "2018-12", 2018, 12, 2018, 12, 7320 ),
    )),
    TestIntScenario("2019", List(
      TestIntParams( "2019-1", 2019, 1, 2019, 1, 7980 ),
      TestIntParams( "2019-2", 2019, 2, 2019, 2, 7980 ),
      TestIntParams( "2019-3", 2019, 3, 2019, 3, 7980 ),
      TestIntParams( "2019-4", 2019, 4, 2019, 4, 7980 ),
      TestIntParams( "2019-5", 2019, 5, 2019, 5, 7980 ),
      TestIntParams( "2019-6", 2019, 6, 2019, 6, 7980 ),
      TestIntParams( "2019-7", 2019, 7, 2019, 7, 7980 ),
      TestIntParams( "2019-8", 2019, 8, 2019, 8, 7980 ),
      TestIntParams( "2019-9", 2019, 9, 2019, 9, 7980 ),
      TestIntParams( "2019-10", 2019, 10, 2019, 10, 7980 ),
      TestIntParams( "2019-11", 2019, 11, 2019, 11, 7980 ),
      TestIntParams( "2019-12", 2019, 12, 2019, 12, 7980 ),
    )),
    TestIntScenario("2020", List(
      TestIntParams( "2020-1", 2020, 1, 2020, 1, 8730 ),
      TestIntParams( "2020-2", 2020, 2, 2020, 2, 8730 ),
      TestIntParams( "2020-3", 2020, 3, 2020, 3, 8730 ),
      TestIntParams( "2020-4", 2020, 4, 2020, 4, 8730 ),
      TestIntParams( "2020-5", 2020, 5, 2020, 5, 8730 ),
      TestIntParams( "2020-6", 2020, 6, 2020, 6, 8730 ),
      TestIntParams( "2020-7", 2020, 7, 2020, 7, 8730 ),
      TestIntParams( "2020-8", 2020, 8, 2020, 8, 8730 ),
      TestIntParams( "2020-9", 2020, 9, 2020, 9, 8730 ),
      TestIntParams( "2020-10", 2020, 10, 2020, 10, 8730 ),
      TestIntParams( "2020-11", 2020, 11, 2020, 11, 8730 ),
      TestIntParams( "2020-12", 2020, 12, 2020, 12, 8730 ),
    )),
    TestIntScenario("2021", List(
      TestIntParams( "2021-1", 2021, 1, 2021, 1, 9050 ),
      TestIntParams( "2021-2", 2021, 2, 2021, 2, 9050 ),
      TestIntParams( "2021-3", 2021, 3, 2021, 3, 9050 ),
      TestIntParams( "2021-4", 2021, 4, 2021, 4, 9050 ),
      TestIntParams( "2021-5", 2021, 5, 2021, 5, 9050 ),
      TestIntParams( "2021-6", 2021, 6, 2021, 6, 9050 ),
      TestIntParams( "2021-7", 2021, 7, 2021, 7, 9050 ),
      TestIntParams( "2021-8", 2021, 8, 2021, 8, 9050 ),
      TestIntParams( "2021-9", 2021, 9, 2021, 9, 9050 ),
      TestIntParams( "2021-10", 2021, 10, 2021, 10, 9050 ),
      TestIntParams( "2021-11", 2021, 11, 2021, 11, 9050 ),
      TestIntParams( "2021-12", 2021, 12, 2021, 12, 9050 ),
    )),
    TestIntScenario("2022", List(
      TestIntParams( "2022-1",  2022,  1, 2022,  1,9050 ),
      TestIntParams( "2022-2",  2022,  2, 2022,  2,9050 ),
      TestIntParams( "2022-3",  2022,  3, 2022,  3,9050 ),
      TestIntParams( "2022-4",  2022,  4, 2022,  4,9050 ),
      TestIntParams( "2022-5",  2022,  5, 2022,  5,9050 ),
      TestIntParams( "2022-6",  2022,  6, 2022,  6,9050 ),
      TestIntParams( "2022-7",  2022,  7, 2022,  7,9050 ),
      TestIntParams( "2022-8",  2022,  8, 2022,  8,9050 ),
      TestIntParams( "2022-9",  2022,  9, 2022,  9,9050 ),
      TestIntParams( "2022-10", 2022, 10, 2022, 10, 9050 ),
      TestIntParams( "2022-11", 2022, 11, 2022, 11, 9050 ),
      TestIntParams( "2022-12", 2022, 12, 2022, 12, 9050 ),
    )),
  )
  // 02_Salary_04_MinHourlyWage
  ServiceExampleBase.logTestIntExamples("02_Salary_04_MinHourlyWage.txt", testList)
  testList.foreach { tx =>
    describe(s"year ${tx.title}") {
      tx.tests.foreach { tt =>
        describe(s"period ${tt.title}") {
          val period = Period.getWithYearMonth(tt.year, tt.month)
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
          val props: IPropsSalary = result match {
            case Left(error) => null
            case Right(value) => value.salaryProps
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
          it(s"GetProps should return getPeriodYear = ${tt.expYear} and getPeriodMonth = ${tt.expMonth}") {
            assert(tt.expYear == bundle.getPeriodYear())
            assert(tt.expMonth == bundle.getPeriodMonth())
          }
          it("GetProps should return healthProps not to be nil") {
            assert(props != null)
          }
          it(s"GetProps should return value = ${tt.expected}") {
            assert(tt.expected == props.minHourlyWage)
          }
        }
      }
    }
  }
}

