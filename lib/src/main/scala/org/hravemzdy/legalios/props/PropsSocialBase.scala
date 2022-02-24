package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.{OperationsDec, OperationsRound, VersionId}
import org.hravemzdy.legalios.service.types.WorkSocialTerms.WorkSocialTerms

abstract class PropsSocialBase(version: VersionId,
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
  override def valueEquals(other: Option[IPropsSocial]): Boolean = {
    return other match {
      case Some(otherVal) =>
        (this.maxAnnualsBasis == otherVal.maxAnnualsBasis &&
          this.factorEmployer == otherVal.factorEmployer &&
          this.factorEmployerHigher == otherVal.factorEmployerHigher &&
          this.factorEmployee == otherVal.factorEmployee &&
          this.factorEmployeeGarant == otherVal.factorEmployeeGarant &&
          this.factorEmployeeReduce == otherVal.factorEmployeeReduce &&
          this.marginIncomeEmp == otherVal.marginIncomeEmp &&
          this.marginIncomeAgr == otherVal.marginIncomeAgr)
      case _ => false
    }
  }

  override def hasParticy(term: WorkSocialTerms, incomeTerm: Int, incomeSpec: Int): Boolean = {
    var particySpec: Boolean = true
    if (hasTermExemptionParticy(term)) {
      particySpec = false
      } else if (hasIncomeBasedAgreementsParticy(term) && marginIncomeAgr > 0) {
        particySpec = false
        if (hasIncomeCumulatedParticy(term)) {
          if (incomeTerm >= marginIncomeAgr) {
            particySpec = true
          }
        } else {
          if (incomeSpec >= marginIncomeAgr) {
            particySpec = true
          }
        }
      } else if (hasIncomeBasedEmploymentParticy(term) && marginIncomeEmp > 0) {
        particySpec = false
        if (hasIncomeCumulatedParticy(term)) {
          if (incomeTerm >= marginIncomeEmp) {
            particySpec = true
          }
        } else {
          if (incomeSpec >= marginIncomeEmp) {
            particySpec = true
          }
        }
      }
      return particySpec
    }

  protected def hasTermExemptionParticy(term: WorkSocialTerms): Boolean
  protected def hasIncomeBasedEmploymentParticy(term: WorkSocialTerms): Boolean
  protected def hasIncomeBasedAgreementsParticy(term: WorkSocialTerms): Boolean
  protected def hasIncomeCumulatedParticy(term: WorkSocialTerms): Boolean

  private def decInsuranceRoundUp(valueDec: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundUp(valueDec)
  }

  private def intInsuranceRoundUp(valueDec: BigDecimal): Int = {
    return OperationsRound.roundUp(valueDec)
  }

  override def roundedEmployeePaym(basisResult: Int): Int = {
    val factorEmployee = OperationsDec.divide(this.factorEmployee, BigDecimal.valueOf(100))
    return intInsuranceRoundUp(OperationsDec.multiply(BigDecimal.valueOf(basisResult), factorEmployee))
  }

  override def roundedEmployerPaym(basisResult: Int): Int = {
    val factorEmployer = OperationsDec.divide(this.factorEmployer, BigDecimal.valueOf(100))
    return intInsuranceRoundUp(OperationsDec.multiply(BigDecimal.valueOf(basisResult), factorEmployer))
  }

  override def resultOvercaps(baseSuma: Int, overCaps: Int): (Int, Int) = {
    val maxBaseEmployee = 0.max(baseSuma - overCaps)
    val empBaseOvercaps = 0.max(baseSuma - maxBaseEmployee)
    val valBaseOvercaps = 0.max(overCaps - empBaseOvercaps)
    return (maxBaseEmployee, valBaseOvercaps)
  }

  override def annualsBasisCut(incomeList: Iterable[ParticySocialTarget], annuityBasis: Int): (Int, Int, Iterable[ParticySocialResult]) = {
    val annualyMaxim: Int= maxAnnualsBasis
    val annualsBasis = 0.max(annualyMaxim - annuityBasis)
    var resultInit = (annualyMaxim, annualsBasis, List[ParticySocialResult]())

    var resultList = incomeList.foldLeft(resultInit) ((agr, x) => {
      var cutAnnualsBasis: Int = 0
      val rawAnnualsBasis: Int = x.targetsBase
      var remAnnualsBasis: Int = agr._2

      if (x.particyCode != 0) {
        cutAnnualsBasis = rawAnnualsBasis
        if (agr._1 > 0)
        {
          val ovrAnnualsBasis = 0.max(rawAnnualsBasis - agr._2)
          cutAnnualsBasis = (rawAnnualsBasis - ovrAnnualsBasis)
        }
        remAnnualsBasis = 0.max(agr._2 - cutAnnualsBasis)
      }

      val r = ParticySocialResult(x.contractCode, x.subjectType, x.interestCode,
        x.subjectTerm, x.particyCode, x.targetsBase, 0.max(cutAnnualsBasis))
      return (agr._1, remAnnualsBasis, agr._3 ++ Seq(r))
    })

    return resultList
  }
}

