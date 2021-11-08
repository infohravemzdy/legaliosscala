package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.service.types.VersionId

class PropsSalary(version: VersionId,
                  override val workingShiftWeek: Int,
                  override val workingShiftTime: Int,
                  override val minMonthlyWage: Int,
                  override val minHourlyWage: Int) extends PropsBase(version) with IPropsSalary {

  def this(version: Int) = {
    this(VersionId.get(version), 0,0,0,0)
  }
}

object PropsSalary {
  def empty(): IPropsSalary = {
    return new PropsSalary(PropsBase.VERSION_ZERO)
  }
}
