package org.hravemzdy.legalios.providers.period2012

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsSalary}
import org.hravemzdy.legalios.props.PropsSalary
import org.hravemzdy.legalios.providers.{IProviderSalary, ProviderBase}

class ProviderSalary2012 extends ProviderBase(HistoryConstSalary2012.VERSION_CODE) with IProviderSalary {
  override def getProps(period: IPeriod): IPropsSalary = {
    return new PropsSalary(
      version,
      workingShiftWeek(period),
      workingShiftTime(period),
      minMonthlyWage(period),
      minHourlyWage(period))
  }
  
  override def workingShiftWeek(period: IPeriod): Int = {
    return HistoryConstSalary2012.WORKING_SHIFT_WEEK
  }

  override def workingShiftTime(period: IPeriod): Int = {
    return HistoryConstSalary2012.WORKING_SHIFT_TIME
  }

  override def minMonthlyWage(period: IPeriod): Int = {
    return HistoryConstSalary2012.MIN_MONTHLY_WAGE
  }

  override def minHourlyWage(period: IPeriod): Int = {
    return HistoryConstSalary2012.MIN_HOURLY_WAGE
  }
}
