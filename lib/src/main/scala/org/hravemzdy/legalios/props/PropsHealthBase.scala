package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.{IParticyResult, IPropsHealth}
import org.hravemzdy.legalios.service.types.{OperationsDec, OperationsRound, VersionId}
import org.hravemzdy.legalios.service.types.WorkHealthTerms.WorkHealthTerms

abstract class PropsHealthBase(version: VersionId,
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

  override def valueEquals(other: Option[IPropsHealth]): Boolean = {
    return other match {
      case Some(otherVal) =>
        (this.minMonthlyBasis == otherVal.minMonthlyBasis &&
        this.maxAnnualsBasis == otherVal.maxAnnualsBasis &&
        this.limMonthlyState == otherVal.limMonthlyState &&
        this.limMonthlyDis50 == otherVal.limMonthlyDis50 &&
        this.factorCompound == otherVal.factorCompound &&
        this.factorEmployee == otherVal.factorEmployee &&
        this.marginIncomeEmp == otherVal.marginIncomeEmp &&
        this.marginIncomeAgr == otherVal.marginIncomeAgr)
      case _ => false
    }
  }

  override def hasParticy(term: WorkHealthTerms, incomeTerm: Int, incomeSpec: Int): Boolean = {
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

  protected def hasTermExemptionParticy(term: WorkHealthTerms): Boolean
  protected def hasIncomeBasedEmploymentParticy(term: WorkHealthTerms): Boolean
  protected def hasIncomeBasedAgreementsParticy(term: WorkHealthTerms): Boolean
  protected def hasIncomeCumulatedParticy(term: WorkHealthTerms): Boolean

  private def decInsuranceRoundUp(valueDec: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundUp(valueDec)
  }

  private def intInsuranceRoundUp(valueDec: BigDecimal): Int = {
    return OperationsRound.roundUp(valueDec)
  }

  override def roundedCompoundPaym(basisResult: Int): Int = {
    val factorCompound = OperationsDec.divide(this.factorCompound, BigDecimal.valueOf(100))

    return intInsuranceRoundUp(OperationsDec.multiply(BigDecimal.valueOf(basisResult), factorCompound))
  }

  override def roundedEmployeePaym(basisResult: Int): Int = {
    val factorCompound = OperationsDec.divide(this.factorCompound, BigDecimal.valueOf(100))
    return intInsuranceRoundUp(OperationsDec.multiplyAndDivide(BigDecimal.valueOf(basisResult), factorCompound, factorEmployee))
  }

  override def roundedAugmentEmployeePaym(basisGenerals: Int, basisAugment: Int): Int = {
    val factorCompound = OperationsDec.divide(this.factorCompound, BigDecimal.valueOf(100))

    return intInsuranceRoundUp(
    OperationsDec.multiply(BigDecimal.valueOf(basisAugment), factorCompound)
    + OperationsDec.multiplyAndDivide(BigDecimal.valueOf(basisGenerals), factorCompound, factorEmployee)
    )
  }

  override def roundedAugmentEmployerPaym(basisGenerals: Int, baseEmployee: Int, baseEmployer: Int): Int = {
    val factorCompound = OperationsDec.divide(this.factorCompound, BigDecimal.valueOf(100))

    val compoundBasis = baseEmployer + baseEmployee + basisGenerals

    val compoundPayment = intInsuranceRoundUp(OperationsDec.multiply(BigDecimal.valueOf(compoundBasis), factorCompound))
    val employeePayment = intInsuranceRoundUp(
    OperationsDec.multiply(BigDecimal.valueOf(baseEmployee), factorCompound)
    + OperationsDec.multiplyAndDivide(BigDecimal.valueOf(basisGenerals), factorCompound, factorEmployee)
    )

    return 0.max(compoundPayment - employeePayment)
  }

  override def roundedEmployerPaym(basisResult: Int): Int = {
    val compoundPayment = roundedCompoundPaym(basisResult)
    val employeePayment = roundedEmployeePaym(basisResult)

    return 0.max(compoundPayment - employeePayment)
  }

  override def annualsBasisCut[T <: IParticyResult](particyList: Iterable[T], incomeList: Iterable[T], annuityBasis: Int): (Int, Int, Iterable[T]) = {
    return maximResultCut[T](particyList, incomeList, annuityBasis, maxAnnualsBasis)
  }
}
