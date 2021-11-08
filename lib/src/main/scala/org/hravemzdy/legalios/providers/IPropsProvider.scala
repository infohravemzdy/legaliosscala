package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.{IPeriod, IProps}
import org.hravemzdy.legalios.service.types.VersionId

trait IPropsProvider[+PXP <: IProps] {
  def getProps(period: IPeriod): PXP
  val version: VersionId
}
