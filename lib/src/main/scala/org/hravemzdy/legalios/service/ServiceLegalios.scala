package org.hravemzdy.legalios.service
import org.hravemzdy.legalios.factories.{BundleBuilder, IBundleBuilder}
import org.hravemzdy.legalios.interfaces.{IBundleProps, IPeriod}
import org.hravemzdy.legalios.service.errors.HistoryResultError

class ServiceLegalios(private val builder : IBundleBuilder) extends IServiceLegalios {
  def this() = {
    this(new BundleBuilder())
  }

  override def getBundle(period: IPeriod): Either[HistoryResultError, IBundleProps] = {
    val bundle : IBundleProps = builder.getBundle(period)

    if (bundle == null) {
      val error = HistoryResultError.BundleNoneError
      return Left[HistoryResultError, IBundleProps](error)
    }
    if (bundle.getPeriodCode() == 0) {
      val error = HistoryResultError.BundleEmptyError
      return Left[HistoryResultError, IBundleProps](error)
    }
    if (bundle.getPeriodCode() != period.code) {
      val error = HistoryResultError.BundleInvalidError
      return Left[HistoryResultError, IBundleProps](error)
    }
    return Right[HistoryResultError, IBundleProps](bundle)
  }
}
