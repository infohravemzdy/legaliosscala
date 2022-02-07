package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.service.types.{VersionId, WorkHealthTerms}
import org.hravemzdy.legalios.service.types.WorkHealthTerms.WorkHealthTerms

class PropsHealth2010(version: VersionId,
                      _minMonthlyBasis: Int,
                      _maxAnnualsBasis: Int,
                      _limMonthlyState: Int,
                      _limMonthlyDis50: Int,
                      _factorCompound: BigDecimal,
                      _factorEmployee: BigDecimal,
                      _marginIncomeEmp: Int,
                      _marginIncomeAgr: Int)
  extends PropsHealthBase(version,
    _minMonthlyBasis,
    _maxAnnualsBasis,
    _limMonthlyState,
    _limMonthlyDis50,
    _factorCompound,
    _factorEmployee,
    _marginIncomeEmp,
    _marginIncomeAgr) with IPropsHealth {

  def this(version: Int) = {
    this(VersionId.get(version),
      0,0,0,0,
      BigDecimal.valueOf(0), BigDecimal.valueOf(0),
      0,0)
  }
  override def hasTermExemptionParticy(term: WorkHealthTerms): Boolean = {
    return false
  }
  override def hasIncomeBasedEmploymentParticy(term: WorkHealthTerms): Boolean = {
    return (term == WorkHealthTerms.HEALTH_TERM_AGREEM_WORK)
  }
  override def hasIncomeBasedAgreementsParticy(term: WorkHealthTerms): Boolean = {
    return false
  }
  override def hasIncomeCumulatedParticy(term: WorkHealthTerms): Boolean = {
    val particy = term match {
      case WorkHealthTerms.HEALTH_TERM_EMPLOYMENTS => false
      case WorkHealthTerms.HEALTH_TERM_AGREEM_WORK => false
      case WorkHealthTerms.HEALTH_TERM_AGREEM_TASK => false
      case WorkHealthTerms.HEALTH_TERM_BY_CONTRACT => false
    }
    return particy
  }
}

object PropsHealth2010 {
  def empty(): IPropsHealth = {
    return new PropsHealth2010(PropsBase.VERSION_ZERO)
  }
}
