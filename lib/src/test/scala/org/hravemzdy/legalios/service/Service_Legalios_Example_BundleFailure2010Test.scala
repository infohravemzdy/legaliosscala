package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.interfaces.{IBundleProps}
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.service.types.Period
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Service_Legalios_Example_BundleFailure2010Test extends AnyFunSpec {
  case class TestParams(title: String, year: Int, month: Int)
  case class TestScenario(title: String, tests: List[TestParams])

  val testList = List(
    TestScenario("2010", List(
      TestParams( "2010-1", 2010, 1),
      TestParams( "2010-2", 2010, 2),
      TestParams( "2010-3", 2010, 3),
      TestParams( "2010-4", 2010, 4),
      TestParams( "2010-5", 2010, 5),
      TestParams( "2010-6", 2010, 6),
      TestParams( "2010-7", 2010, 7),
      TestParams( "2010-8", 2010, 8),
      TestParams( "2010-9", 2010, 9),
      TestParams( "2010-10", 2010, 10),
      TestParams( "2010-11", 2010, 11),
      TestParams( "2010-12", 2010, 12),
    )),
  )
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
          it("GetProps should return error") {
            assert(error != null)
          }
          it("GetProps should return Left") {
            assert(result.isLeft)
          }
          it("GetProps should return props be nil") {
            assert(bundle == null)
          }
        }
      }
    }
  }
}

