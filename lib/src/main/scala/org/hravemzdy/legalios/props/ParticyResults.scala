package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.service.types.WorkHealthTerms.WorkHealthTerms
import org.hravemzdy.legalios.service.types.WorkSocialTerms.WorkSocialTerms
import org.hravemzdy.legalios.service.types.{WorkHealthTerms, WorkSocialTerms, WorkTaxingTerms}
import org.hravemzdy.legalios.service.types.WorkTaxingTerms.WorkTaxingTerms

class ParticyHealthTarget(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkHealthTerms, val particyCode: Int, var targetsBase: Int) {

  def addTargetBase(targetsBase: Int): Int = {
    this.targetsBase += targetsBase
    return this.targetsBase
  }

  def incomeScore(): Int = {
    val resultType: Int = (subjectType) match {
      case WorkTaxingTerms.TAXING_TERM_EMPLOYMENTS => 900
      case WorkTaxingTerms.TAXING_TERM_AGREEM_TASK => 100
      case WorkTaxingTerms.TAXING_TERM_STATUT_PART => 500
      case WorkTaxingTerms.TAXING_TERM_BY_CONTRACT => 0
    }
    val resultBase: Int = (subjectTerm) match {
      case WorkHealthTerms.HEALTH_TERM_EMPLOYMENTS => 9000
      case WorkHealthTerms.HEALTH_TERM_AGREEM_WORK => 5000
      case WorkHealthTerms.HEALTH_TERM_AGREEM_TASK => 4000
      case WorkHealthTerms.HEALTH_TERM_BY_CONTRACT => 0
    }
    var interestRes : Int = 0
    if (interestCode == 1) {
      interestRes = 10000
    }
    var particyRes : Int = 0
    if (particyCode == 1) {
      particyRes = 100000
    }
    return (resultType + resultBase + interestRes + particyRes)
  }
  def resultComparator() : (ParticyHealthTarget, ParticyHealthTarget) => Boolean = {
    (x: ParticyHealthTarget, y: ParticyHealthTarget) => {
      val xIncomeScore = x.incomeScore()
      val yIncomeScore = y.incomeScore()

      var result: Boolean = (yIncomeScore.compare(xIncomeScore) < 0)
      if (xIncomeScore.compare(yIncomeScore) == 0) {
        result = (x.contractCode.compare(y.contractCode) < 0)
      }
      result
    }
  }
}

case class ParticyHealthResult(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkHealthTerms, val particyCode: Int, var targetsBase: Int, val resultsBase: Int)

class ParticySocialTarget(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkSocialTerms, val particyCode: Int, var targetsBase: Int, val resultsBase: Int) {
  def addTargetBase(targetsBase: Int): Int = {
    this.targetsBase += targetsBase
    return this.targetsBase
  }

  def incomeScore(): Int = {
    val resultType: Int = (subjectType) match {
      case WorkTaxingTerms.TAXING_TERM_EMPLOYMENTS => 900
      case WorkTaxingTerms.TAXING_TERM_AGREEM_TASK => 100
      case WorkTaxingTerms.TAXING_TERM_STATUT_PART => 500
      case WorkTaxingTerms.TAXING_TERM_BY_CONTRACT => 0
    }
    val resultBase: Int = (subjectTerm) match {
      case WorkSocialTerms.SOCIAL_TERM_EMPLOYMENTS => 9000
      case WorkSocialTerms.SOCIAL_TERM_SMALLS_EMPL => 5000
      case WorkSocialTerms.SOCIAL_TERM_SHORTS_MEET => 4000
      case WorkSocialTerms.SOCIAL_TERM_SHORTS_DENY => 0
      case WorkSocialTerms.SOCIAL_TERM_BY_CONTRACT => 0
      case WorkSocialTerms.SOCIAL_TERM_AGREEM_TASK => 0
    }
    var interestRes : Int = 0
    if (interestCode == 1) {
      interestRes = 10000
    }
    var particyRes : Int = 0
    if (particyCode == 1) {
      particyRes = 100000
    }
    return (resultType + resultBase + interestRes + particyRes)
  }
  def resultComparator() : (ParticySocialTarget, ParticySocialTarget) => Boolean = {
    (x: ParticySocialTarget, y: ParticySocialTarget) => {
      val xIncomeScore = x.incomeScore()
      val yIncomeScore = y.incomeScore()

      var result: Boolean = (yIncomeScore.compare(xIncomeScore) < 0)
      if (xIncomeScore.compare(yIncomeScore) == 0) {
        result = (x.contractCode.compare(y.contractCode) < 0)
      }
      result
    }
  }
}

case class ParticySocialResult(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkSocialTerms, val particyCode: Int, var targetsBase: Int, val resultsBase: Int)

