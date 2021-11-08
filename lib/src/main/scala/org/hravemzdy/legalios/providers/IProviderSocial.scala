package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsSocial}

trait IProviderSocial extends IPropsProvider[IPropsSocial] {
  def maxAnnualsBasis(period: IPeriod): Int
  def factorEmployer(period: IPeriod): BigDecimal
  def factorEmployerHigher(period: IPeriod): BigDecimal
  def factorEmployee(period: IPeriod): BigDecimal
  def factorEmployeeGarant(period: IPeriod): BigDecimal
  def factorEmployeeReduce(period: IPeriod): BigDecimal
  def marginIncomeEmp(period: IPeriod): Int
  def marginIncomeAgr(period: IPeriod): Int
}
