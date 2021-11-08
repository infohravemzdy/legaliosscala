package org.hravemzdy.legalios.service

import org.hravemzdy.legalios.interfaces.{IBundleProps, IPeriod}
import org.hravemzdy.legalios.service.errors.HistoryResultError

trait IServiceLegalios {
  def getBundle(period: IPeriod): Either[HistoryResultError, IBundleProps]
}
