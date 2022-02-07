package org.hravemzdy.legalios.interfaces

import org.hravemzdy.legalios.props.PropsTaxing
import org.hravemzdy.legalios.service.types.TaxDeclBenfOption.TaxDeclBenfOption
import org.hravemzdy.legalios.service.types.TaxDeclDisabOption.TaxDeclDisabOption
import org.hravemzdy.legalios.service.types.TaxDeclSignOption.TaxDeclSignOption
import org.hravemzdy.legalios.service.types.TaxNoneSignOption.TaxNoneSignOption
import org.hravemzdy.legalios.service.types.WorkTaxingTerms.WorkTaxingTerms

trait IPropsTaxing extends IProps {
  val allowancePayer: Int
  val allowanceDisab1st: Int
  val allowanceDisab2nd : Int
  val allowanceDisab3rd: Int
  val allowanceStudy: Int
  val allowanceChild1st: Int
  val allowanceChild2nd: Int
  val allowanceChild3rd: Int
  val factorAdvances: BigDecimal
  val factorWithhold: BigDecimal
  val factorSolidary: BigDecimal
  val factorTaxRate2: BigDecimal
  val minAmountOfTaxBonus: Int
  val maxAmountOfTaxBonus: Int
  val marginIncomeOfTaxBonus: Int
  val marginIncomeOfRounding: Int
  val marginIncomeOfWithhold: Int
  val marginIncomeOfSolidary: Int
  val marginIncomeOfTaxRate2: Int
  val marginIncomeOfWthEmp: Int
  val marginIncomeOfWthAgr: Int

  def valueEquals(other: Option[IPropsTaxing]): Boolean
  def hasWithholdIncome(termOpt: WorkTaxingTerms,
    signOpt: TaxDeclSignOption, noneOpt: TaxNoneSignOption, incomeSum: Int): Boolean
  def benefitAllowancePayer(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int
  def benefitAllowanceDisab(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclDisabOption): Int
  def benefitAllowanceStudy(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int
  def benefitAllowanceChild(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption, benefitOrds: Int, disabelOpts: Int): Int
  def bonusChildRaw(income: Int, benefit: Int, rebated: Int): Int
  def bonusChildFix(income: Int, benefit: Int, rebated: Int): Int
  def taxableIncomeSupers(incomeResult: Int, healthResult: Int, socialResult: Int): Int
  def taxableIncomeBasis(incomeResult: Int): Int
  def roundedBaseAdvances(incomeResult: Int): Int
  def roundedBaseAdvances(incomeResult: Int, healthResult: Int, socialResult: Int): Int
  def roundedBaseSolidary(incomeResult: Int): Int
  def roundedAdvancesPaym(supersResult: Int, basisResult: Int): Int
  def roundedSolidaryPaym(basisResult: Int): Int
  def roundedBaseWithhold(incomeResult: Int): Int
  def roundedWithholdPaym(supersResult: Int, basisResult: Int): Int
}
