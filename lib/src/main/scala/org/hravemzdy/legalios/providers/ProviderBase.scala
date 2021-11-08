package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.service.types.VersionId

abstract class ProviderBase(val version: VersionId) {
  def this(_version: Int) = {
    this(VersionId.get(_version))
  }
  protected def isPeriodGreaterOrEqualThan(period: IPeriod, yearFrom: Int, monthFrom: Int): Boolean = {
    return period.year > yearFrom || (period.year == yearFrom && period.month >= monthFrom)
  }
}
