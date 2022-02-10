package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.{TestPeriodParams, TestPeriodScenario}
import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.service.types.Period
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Service_Legalios_Example_BundleFailure2009Test extends AnyFunSpec {
  val testList = List(
    TestPeriodScenario("2009", List(
      TestPeriodParams( "2009-1", 2009, 1),
      TestPeriodParams( "2009-2", 2009, 2),
      TestPeriodParams( "2009-3", 2009, 3),
      TestPeriodParams( "2009-4", 2009, 4),
      TestPeriodParams( "2009-5", 2009, 5),
      TestPeriodParams( "2009-6", 2009, 6),
      TestPeriodParams( "2009-7", 2009, 7),
      TestPeriodParams( "2009-8", 2009, 8),
      TestPeriodParams( "2009-9", 2009, 9),
      TestPeriodParams( "2009-10", 2009, 10),
      TestPeriodParams( "2009-11", 2009, 11),
      TestPeriodParams( "2009-12", 2009, 12),
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

