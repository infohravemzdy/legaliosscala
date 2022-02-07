package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsTaxing}

trait IProviderTaxing extends IPropsProvider[IPropsTaxing] {
  def allowancePayer(period: IPeriod): Int
  def allowanceDisab1st(period: IPeriod): Int
  def allowanceDisab2nd(period: IPeriod): Int
  def allowanceDisab3rd(period: IPeriod): Int
  def allowanceStudy(period: IPeriod): Int
  def allowanceChild1st(period: IPeriod): Int
  def allowanceChild2nd(period: IPeriod): Int
  def allowanceChild3rd(period: IPeriod): Int
  def factorAdvances(period: IPeriod): BigDecimal
  def factorWithhold(period: IPeriod): BigDecimal
  def factorSolidary(period: IPeriod): BigDecimal
  def factorTaxRate2(period: IPeriod): BigDecimal
  def minAmountOfTaxBonus(period: IPeriod): Int
  def maxAmountOfTaxBonus(period: IPeriod): Int
  def marginIncomeOfTaxBonus(period: IPeriod): Int
  def marginIncomeOfRounding(period: IPeriod): Int
  def marginIncomeOfWithhold(period: IPeriod): Int
  def marginIncomeOfSolidary(period: IPeriod): Int
  def marginIncomeOfTaxRate2(period: IPeriod): Int
  def marginIncomeOfWthEmp(period: IPeriod): Int
  def marginIncomeOfWthAgr(period: IPeriod): Int
}
