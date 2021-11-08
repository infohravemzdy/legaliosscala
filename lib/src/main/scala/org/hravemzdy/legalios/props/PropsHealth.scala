package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.service.types.VersionId

class PropsHealth(version: VersionId,
  override val minMonthlyBasis: Int,
  override val maxAnnualsBasis: Int,
  override val limMonthlyState: Int,
  override val limMonthlyDis50: Int,
  override val factorCompound: BigDecimal,
  override val factorEmployee: BigDecimal,
  override val marginIncomeEmp: Int,
  override val marginIncomeAgr: Int) extends PropsBase(version) with IPropsHealth {

  def this(version: Int) = {
    this(VersionId.get(version),
      0,0,0,0,
      BigDecimal.valueOf(0), BigDecimal.valueOf(0),
      0,0)
  }
}

object PropsHealth {
  def empty(): IPropsHealth = {
    return new PropsHealth(PropsBase.VERSION_ZERO)
  }
}
