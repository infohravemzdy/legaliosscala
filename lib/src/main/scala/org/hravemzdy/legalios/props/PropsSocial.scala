package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.{VersionId, WorkSocialTerms}
import org.hravemzdy.legalios.service.types.WorkSocialTerms.WorkSocialTerms

class PropsSocial(version: VersionId,
                      _maxAnnualsBasis: Int,
                      _factorEmployer: BigDecimal,
                      _factorEmployerHigher: BigDecimal,
                      _factorEmployee: BigDecimal,
                      _factorEmployeeGarant: BigDecimal,
                      _factorEmployeeReduce: BigDecimal,
                      _marginIncomeEmp: Int,
                      _marginIncomeAgr: Int)
  extends PropsSocialBase(version,
    _maxAnnualsBasis,
    _factorEmployer,
    _factorEmployerHigher,
    _factorEmployee,
    _factorEmployeeGarant,
    _factorEmployeeReduce,
    _marginIncomeEmp,
    _marginIncomeAgr) with IPropsSocial {

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

  override def hasTermExemptionParticy(term: WorkSocialTerms): Boolean = {
    return false
  }
  override def hasIncomeBasedEmploymentParticy(term: WorkSocialTerms): Boolean = {
    return (term == WorkSocialTerms.SOCIAL_TERM_SMALLS_EMPL)
  }
  override def hasIncomeBasedAgreementsParticy(term: WorkSocialTerms): Boolean = {
    return (term == WorkSocialTerms.SOCIAL_TERM_AGREEM_TASK)
  }
  override def hasIncomeCumulatedParticy(term: WorkSocialTerms): Boolean = {
    val particy = term match {
      case WorkSocialTerms.SOCIAL_TERM_EMPLOYMENTS => false
      case WorkSocialTerms.SOCIAL_TERM_AGREEM_TASK => true
      case WorkSocialTerms.SOCIAL_TERM_SMALLS_EMPL => true
      case WorkSocialTerms.SOCIAL_TERM_SHORTS_MEET => false
      case WorkSocialTerms.SOCIAL_TERM_SHORTS_DENY => false
      case WorkSocialTerms.SOCIAL_TERM_BY_CONTRACT => false
    }
    return particy
  }
}

object PropsSocial {
  def empty(): IPropsSocial = {
    return new PropsSocial(PropsBase.VERSION_ZERO)
  }
}
