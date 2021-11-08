package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.{IBundleProps, IPeriod}

trait IBundleBuilder {
  def getBundle(period: IPeriod): IBundleProps
}
