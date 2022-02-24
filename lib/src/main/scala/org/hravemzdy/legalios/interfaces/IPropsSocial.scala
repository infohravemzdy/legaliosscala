package org.hravemzdy.legalios.interfaces

import org.hravemzdy.legalios.props.{ParticySocialResult, ParticySocialTarget}
import org.hravemzdy.legalios.service.types.WorkSocialTerms.WorkSocialTerms

trait IPropsSocial extends IProps {
  val maxAnnualsBasis: Int
  val factorEmployer: BigDecimal
  val factorEmployerHigher: BigDecimal
  val factorEmployee: BigDecimal
  val factorEmployeeGarant: BigDecimal
  val factorEmployeeReduce: BigDecimal
  val marginIncomeEmp: Int
  val marginIncomeAgr: Int

  def valueEquals(other: Option[IPropsSocial]): Boolean
  def hasParticy(term: WorkSocialTerms, incomeTerm: Int, incomeSpec: Int): Boolean
  def roundedEmployeePaym(basisResult: Int): Int
  def roundedEmployerPaym(basisResult: Int): Int
  def resultOvercaps(baseSuma: Int, overCaps: Int): (Int, Int)
  def annualsBasisCut(incomeList: Iterable[ParticySocialTarget], annuityBasis: Int): (Int, Int, Iterable[ParticySocialResult])
}
