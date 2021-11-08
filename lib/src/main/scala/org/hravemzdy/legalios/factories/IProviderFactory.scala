package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.{IPeriod, IProps}

trait IProviderFactory[+FXP <: IProps] {
  type VERSION = Int

  def getProps(period: IPeriod): FXP
}
