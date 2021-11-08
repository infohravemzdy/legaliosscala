package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.VersionId

class PropsSocial(version: VersionId,
                  override val maxAnnualsBasis: Int,
                  override val factorEmployer: BigDecimal,
                  override val factorEmployerHigher: BigDecimal,
                  override val factorEmployee: BigDecimal,
                  override val factorEmployeeGarant: BigDecimal,
                  override val factorEmployeeReduce: BigDecimal,
                  override val marginIncomeEmp: Int,
                  override val marginIncomeAgr: Int) extends PropsBase(version) with IPropsSocial {

  def this(version: Int) = {
    this(VersionId.get(version),
      0,
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      0,0)
  }
}

object PropsSocial {
  def empty(): IPropsSocial = {
    return new PropsSocial(PropsBase.VERSION_ZERO)
  }
}
