package org.hravemzdy.legalios.providers.period2015

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsSalary}
import org.hravemzdy.legalios.props.PropsSalary
import org.hravemzdy.legalios.providers.{IProviderSalary, ProviderBase}

class ProviderSalary2015 extends ProviderBase(HistoryConstSalary2015.VERSION_CODE) with IProviderSalary {
  override def getProps(period: IPeriod): IPropsSalary = {
    return new PropsSalary(
      version,
      workingShiftWeek(period),
      workingShiftTime(period),
      minMonthlyWage(period),
      minHourlyWage(period))
  }
  
  override def workingShiftWeek(period: IPeriod): Int = {
    return HistoryConstSalary2015.WORKING_SHIFT_WEEK
  }

  override def workingShiftTime(period: IPeriod): Int = {
    return HistoryConstSalary2015.WORKING_SHIFT_TIME
  }

  override def minMonthlyWage(period: IPeriod): Int = {
    return HistoryConstSalary2015.MIN_MONTHLY_WAGE
  }

  override def minHourlyWage(period: IPeriod): Int = {
    return HistoryConstSalary2015.MIN_HOURLY_WAGE
  }
}
