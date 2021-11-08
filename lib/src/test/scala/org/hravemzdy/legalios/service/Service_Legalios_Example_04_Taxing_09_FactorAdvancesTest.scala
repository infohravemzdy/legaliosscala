package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.interfaces.{IBundleProps, IPropsTaxing}
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.service.types.Period
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Service_Legalios_Example_04_Taxing_09_FactorAdvancesTest extends AnyFunSpec {
  val testList = List(
    TestDecScenario("2011", List(
      TestDecParams( "2011-1", 2011, 1, 2011, 1, 15.0 ),
      TestDecParams( "2011-2", 2011, 2, 2011, 2, 15.0 ),
      TestDecParams( "2011-3", 2011, 3, 2011, 3, 15.0 ),
      TestDecParams( "2011-4", 2011, 4, 2011, 4, 15.0 ),
      TestDecParams( "2011-5", 2011, 5, 2011, 5, 15.0 ),
      TestDecParams( "2011-6", 2011, 6, 2011, 6, 15.0 ),
      TestDecParams( "2011-7", 2011, 7, 2011, 7, 15.0 ),
      TestDecParams( "2011-8", 2011, 8, 2011, 8, 15.0 ),
      TestDecParams( "2011-9", 2011, 9, 2011, 9, 15.0 ),
      TestDecParams( "2011-10", 2011, 10, 2011, 10, 15.0 ),
      TestDecParams( "2011-11", 2011, 11, 2011, 11, 15.0 ),
      TestDecParams( "2011-12", 2011, 12, 2011, 12, 15.0 ),
    )),
    TestDecScenario("2012", List(
      TestDecParams( "2012-1", 2012, 1, 2012, 1, 15.0 ),
      TestDecParams( "2012-2", 2012, 2, 2012, 2, 15.0 ),
      TestDecParams( "2012-3", 2012, 3, 2012, 3, 15.0 ),
      TestDecParams( "2012-4", 2012, 4, 2012, 4, 15.0 ),
      TestDecParams( "2012-5", 2012, 5, 2012, 5, 15.0 ),
      TestDecParams( "2012-6", 2012, 6, 2012, 6, 15.0 ),
      TestDecParams( "2012-7", 2012, 7, 2012, 7, 15.0 ),
      TestDecParams( "2012-8", 2012, 8, 2012, 8, 15.0 ),
      TestDecParams( "2012-9", 2012, 9, 2012, 9, 15.0 ),
      TestDecParams( "2012-10", 2012, 10, 2012, 10, 15.0 ),
      TestDecParams( "2012-11", 2012, 11, 2012, 11, 15.0 ),
      TestDecParams( "2012-12", 2012, 12, 2012, 12, 15.0 ),
    )),
    TestDecScenario("2013", List(
      TestDecParams( "2013-1", 2013, 1, 2013, 1, 15.0 ),
      TestDecParams( "2013-2", 2013, 2, 2013, 2, 15.0 ),
      TestDecParams( "2013-3", 2013, 3, 2013, 3, 15.0 ),
      TestDecParams( "2013-4", 2013, 4, 2013, 4, 15.0 ),
      TestDecParams( "2013-5", 2013, 5, 2013, 5, 15.0 ),
      TestDecParams( "2013-6", 2013, 6, 2013, 6, 15.0 ),
      TestDecParams( "2013-7", 2013, 7, 2013, 7, 15.0 ),
      TestDecParams( "2013-8", 2013, 8, 2013, 8, 15.0 ),
      TestDecParams( "2013-9", 2013, 9, 2013, 9, 15.0 ),
      TestDecParams( "2013-10", 2013, 10, 2013, 10, 15.0 ),
      TestDecParams( "2013-11", 2013, 11, 2013, 11, 15.0 ),
      TestDecParams( "2013-12", 2013, 12, 2013, 12, 15.0 ),
    )),
    TestDecScenario("2014", List(
      TestDecParams( "2014-1", 2014, 1, 2014, 1, 15.0 ),
      TestDecParams( "2014-2", 2014, 2, 2014, 2, 15.0 ),
      TestDecParams( "2014-3", 2014, 3, 2014, 3, 15.0 ),
      TestDecParams( "2014-4", 2014, 4, 2014, 4, 15.0 ),
      TestDecParams( "2014-5", 2014, 5, 2014, 5, 15.0 ),
      TestDecParams( "2014-6", 2014, 6, 2014, 6, 15.0 ),
      TestDecParams( "2014-7", 2014, 7, 2014, 7, 15.0 ),
      TestDecParams( "2014-8", 2014, 8, 2014, 8, 15.0 ),
      TestDecParams( "2014-9", 2014, 9, 2014, 9, 15.0 ),
      TestDecParams( "2014-10", 2014, 10, 2014, 10, 15.0 ),
      TestDecParams( "2014-11", 2014, 11, 2014, 11, 15.0 ),
      TestDecParams( "2014-12", 2014, 12, 2014, 12, 15.0 ),
    )),
    TestDecScenario("2015", List(
      TestDecParams( "2015-1", 2015, 1, 2015, 1, 15.0 ),
      TestDecParams( "2015-2", 2015, 2, 2015, 2, 15.0 ),
      TestDecParams( "2015-3", 2015, 3, 2015, 3, 15.0 ),
      TestDecParams( "2015-4", 2015, 4, 2015, 4, 15.0 ),
      TestDecParams( "2015-5", 2015, 5, 2015, 5, 15.0 ),
      TestDecParams( "2015-6", 2015, 6, 2015, 6, 15.0 ),
      TestDecParams( "2015-7", 2015, 7, 2015, 7, 15.0 ),
      TestDecParams( "2015-8", 2015, 8, 2015, 8, 15.0 ),
      TestDecParams( "2015-9", 2015, 9, 2015, 9, 15.0 ),
      TestDecParams( "2015-10", 2015, 10, 2015, 10, 15.0 ),
      TestDecParams( "2015-11", 2015, 11, 2015, 11, 15.0 ),
      TestDecParams( "2015-12", 2015, 12, 2015, 12, 15.0 ),
    )),
    TestDecScenario("2016", List(
      TestDecParams( "2016-1", 2016, 1, 2016, 1, 15.0 ),
      TestDecParams( "2016-2", 2016, 2, 2016, 2, 15.0 ),
      TestDecParams( "2016-3", 2016, 3, 2016, 3, 15.0 ),
      TestDecParams( "2016-4", 2016, 4, 2016, 4, 15.0 ),
      TestDecParams( "2016-5", 2016, 5, 2016, 5, 15.0 ),
      TestDecParams( "2016-6", 2016, 6, 2016, 6, 15.0 ),
      TestDecParams( "2016-7", 2016, 7, 2016, 7, 15.0 ),
      TestDecParams( "2016-8", 2016, 8, 2016, 8, 15.0 ),
      TestDecParams( "2016-9", 2016, 9, 2016, 9, 15.0 ),
      TestDecParams( "2016-10", 2016, 10, 2016, 10, 15.0 ),
      TestDecParams( "2016-11", 2016, 11, 2016, 11, 15.0 ),
      TestDecParams( "2016-12", 2016, 12, 2016, 12, 15.0 ),
    )),
    TestDecScenario("2017", List(
      TestDecParams( "2017-1", 2017, 1, 2017, 1, 15.0 ),
      TestDecParams( "2017-2", 2017, 2, 2017, 2, 15.0 ),
      TestDecParams( "2017-3", 2017, 3, 2017, 3, 15.0 ),
      TestDecParams( "2017-4", 2017, 4, 2017, 4, 15.0 ),
      TestDecParams( "2017-5", 2017, 5, 2017, 5, 15.0 ),
      TestDecParams( "2017-6", 2017, 6, 2017, 6, 15.0 ),
      TestDecParams( "2017-7", 2017, 7, 2017, 7, 15.0 ),
      TestDecParams( "2017-8", 2017, 8, 2017, 8, 15.0 ),
      TestDecParams( "2017-9", 2017, 9, 2017, 9, 15.0 ),
      TestDecParams( "2017-10", 2017, 10, 2017, 10, 15.0 ),
      TestDecParams( "2017-11", 2017, 11, 2017, 11, 15.0 ),
      TestDecParams( "2017-12", 2017, 12, 2017, 12, 15.0 ),
    )),
    TestDecScenario("2018", List(
      TestDecParams( "2018-1", 2018, 1, 2018, 1, 15.0 ),
      TestDecParams( "2018-2", 2018, 2, 2018, 2, 15.0 ),
      TestDecParams( "2018-3", 2018, 3, 2018, 3, 15.0 ),
      TestDecParams( "2018-4", 2018, 4, 2018, 4, 15.0 ),
      TestDecParams( "2018-5", 2018, 5, 2018, 5, 15.0 ),
      TestDecParams( "2018-6", 2018, 6, 2018, 6, 15.0 ),
      TestDecParams( "2018-7", 2018, 7, 2018, 7, 15.0 ),
      TestDecParams( "2018-8", 2018, 8, 2018, 8, 15.0 ),
      TestDecParams( "2018-9", 2018, 9, 2018, 9, 15.0 ),
      TestDecParams( "2018-10", 2018, 10, 2018, 10, 15.0 ),
      TestDecParams( "2018-11", 2018, 11, 2018, 11, 15.0 ),
      TestDecParams( "2018-12", 2018, 12, 2018, 12, 15.0 ),
    )),
    TestDecScenario("2019", List(
      TestDecParams( "2019-1", 2019, 1, 2019, 1, 15.0 ),
      TestDecParams( "2019-2", 2019, 2, 2019, 2, 15.0 ),
      TestDecParams( "2019-3", 2019, 3, 2019, 3, 15.0 ),
      TestDecParams( "2019-4", 2019, 4, 2019, 4, 15.0 ),
      TestDecParams( "2019-5", 2019, 5, 2019, 5, 15.0 ),
      TestDecParams( "2019-6", 2019, 6, 2019, 6, 15.0 ),
      TestDecParams( "2019-7", 2019, 7, 2019, 7, 15.0 ),
      TestDecParams( "2019-8", 2019, 8, 2019, 8, 15.0 ),
      TestDecParams( "2019-9", 2019, 9, 2019, 9, 15.0 ),
      TestDecParams( "2019-10", 2019, 10, 2019, 10, 15.0 ),
      TestDecParams( "2019-11", 2019, 11, 2019, 11, 15.0 ),
      TestDecParams( "2019-12", 2019, 12, 2019, 12, 15.0 ),
    )),
    TestDecScenario("2020", List(
      TestDecParams( "2020-1", 2020, 1, 2020, 1, 15.0 ),
      TestDecParams( "2020-2", 2020, 2, 2020, 2, 15.0 ),
      TestDecParams( "2020-3", 2020, 3, 2020, 3, 15.0 ),
      TestDecParams( "2020-4", 2020, 4, 2020, 4, 15.0 ),
      TestDecParams( "2020-5", 2020, 5, 2020, 5, 15.0 ),
      TestDecParams( "2020-6", 2020, 6, 2020, 6, 15.0 ),
      TestDecParams( "2020-7", 2020, 7, 2020, 7, 15.0 ),
      TestDecParams( "2020-8", 2020, 8, 2020, 8, 15.0 ),
      TestDecParams( "2020-9", 2020, 9, 2020, 9, 15.0 ),
      TestDecParams( "2020-10", 2020, 10, 2020, 10, 15.0 ),
      TestDecParams( "2020-11", 2020, 11, 2020, 11, 15.0 ),
      TestDecParams( "2020-12", 2020, 12, 2020, 12, 15.0 ),
    )),
    TestDecScenario("2021", List(
      TestDecParams( "2021-1", 2021, 1, 2021, 1, 15.0 ),
      TestDecParams( "2021-2", 2021, 2, 2021, 2, 15.0 ),
      TestDecParams( "2021-3", 2021, 3, 2021, 3, 15.0 ),
      TestDecParams( "2021-4", 2021, 4, 2021, 4, 15.0 ),
      TestDecParams( "2021-5", 2021, 5, 2021, 5, 15.0 ),
      TestDecParams( "2021-6", 2021, 6, 2021, 6, 15.0 ),
      TestDecParams( "2021-7", 2021, 7, 2021, 7, 15.0 ),
      TestDecParams( "2021-8", 2021, 8, 2021, 8, 15.0 ),
      TestDecParams( "2021-9", 2021, 9, 2021, 9, 15.0 ),
      TestDecParams( "2021-10", 2021, 10, 2021, 10, 15.0 ),
      TestDecParams( "2021-11", 2021, 11, 2021, 11, 15.0 ),
      TestDecParams( "2021-12", 2021, 12, 2021, 12, 15.0 ),
    )),
    TestDecScenario("2022", List(
      TestDecParams( "2022-1",  2022,  1, 2022,  1,15.0 ),
      TestDecParams( "2022-2",  2022,  2, 2022,  2,15.0 ),
      TestDecParams( "2022-3",  2022,  3, 2022,  3,15.0 ),
      TestDecParams( "2022-4",  2022,  4, 2022,  4,15.0 ),
      TestDecParams( "2022-5",  2022,  5, 2022,  5,15.0 ),
      TestDecParams( "2022-6",  2022,  6, 2022,  6,15.0 ),
      TestDecParams( "2022-7",  2022,  7, 2022,  7,15.0 ),
      TestDecParams( "2022-8",  2022,  8, 2022,  8,15.0 ),
      TestDecParams( "2022-9",  2022,  9, 2022,  9,15.0 ),
      TestDecParams( "2022-10", 2022, 10, 2022, 10, 15.0 ),
      TestDecParams( "2022-11", 2022, 11, 2022, 11, 15.0 ),
      TestDecParams( "2022-12", 2022, 12, 2022, 12, 15.0 ),
    )),
  )
  // 04_Taxing_09_FactorAdvances
  ServiceExampleBase.logTestDecExamples("04_Taxing_09_FactorAdvances.txt", testList)
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
          it(s"GetProps should return getPeriodYear = ${tt.expYear} and getPeriodMonth = ${tt.expMonth}") {
            assert(tt.expYear == bundle.getPeriodYear())
            assert(tt.expMonth == bundle.getPeriodMonth())
          }
          it("GetProps should return healthProps not to be nil") {
            assert(props != null)
          }
          it(s"GetProps should return value = ${tt.expected}") {
            val expDecimal = tt.expectedDec()
            assert(expDecimal == props.factorAdvances)
          }
        }
      }
    }
  }
}

