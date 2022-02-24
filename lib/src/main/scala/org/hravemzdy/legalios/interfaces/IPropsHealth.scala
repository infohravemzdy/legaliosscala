package org.hravemzdy.legalios.interfaces

import org.hravemzdy.legalios.props.{ParticyHealthResult, ParticyHealthTarget}
import org.hravemzdy.legalios.service.types.WorkHealthTerms.WorkHealthTerms

trait IPropsHealth extends IProps {
  val minMonthlyBasis: Int
  val maxAnnualsBasis: Int
  val limMonthlyState: Int
  val limMonthlyDis50: Int
  val factorCompound: BigDecimal
  val factorEmployee: BigDecimal
  val marginIncomeEmp: Int
  val marginIncomeAgr: Int

  def valueEquals(other: Option[IPropsHealth]): Boolean
  def hasParticy(term: WorkHealthTerms, incomeTerm: Int, incomeSpec: Int): Boolean
  def roundedCompoundPaym(basisResult: Int): Int
  def roundedEmployeePaym(basisResult: Int): Int
  def roundedAugmentEmployeePaym(basisGenerals: Int, basisAugment: Int): Int
  def roundedAugmentEmployerPaym(basisGenerals: Int, baseEmployee: Int, baseEmployer: Int): Int
  def roundedEmployerPaym(basisResult: Int): Int
  def annualsBasisCut(incomeList: Iterable[ParticyHealthTarget], annuityBasis: Int): (Int, Int, Iterable[ParticyHealthResult])
}
