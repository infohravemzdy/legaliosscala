package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsHealth}

trait IProviderHealth extends IPropsProvider[IPropsHealth]{
  def minMonthlyBasis(period: IPeriod): Int
  def maxAnnualsBasis(period: IPeriod): Int
  def limMonthlyState(period: IPeriod): Int
  def limMonthlyDis50(period: IPeriod): Int
  def factorCompound(period: IPeriod): BigDecimal
  def factorEmployee(period: IPeriod): BigDecimal
  def marginIncomeEmp(period: IPeriod): Int
  def marginIncomeAgr(period: IPeriod): Int
}
