package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsSalary}

trait IProviderSalary extends IPropsProvider[IPropsSalary] {
  def workingShiftWeek(period: IPeriod): Int
  def workingShiftTime(period: IPeriod): Int
  def minMonthlyWage(period: IPeriod): Int
  def minHourlyWage(period: IPeriod): Int
}
