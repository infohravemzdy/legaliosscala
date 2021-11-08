package org.hravemzdy.legalios.providers.period2013

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsSalary}
import org.hravemzdy.legalios.props.PropsSalary
import org.hravemzdy.legalios.providers.{IProviderSalary, ProviderBase}

class ProviderSalary2013 extends ProviderBase(HistoryConstSalary2013.VERSION_CODE) with IProviderSalary {
  override def getProps(period: IPeriod): IPropsSalary = {
    return new PropsSalary(
      version,
      workingShiftWeek(period),
      workingShiftTime(period),
      minMonthlyWage(period),
      minHourlyWage(period))
  }
  
  override def workingShiftWeek(period: IPeriod): Int = {
    return HistoryConstSalary2013.WORKING_SHIFT_WEEK
  }

  override def workingShiftTime(period: IPeriod): Int = {
    return HistoryConstSalary2013.WORKING_SHIFT_TIME
  }

  override def minMonthlyWage(period: IPeriod): Int = {
    if (isPeriodGreaterOrEqualThan(period, 2013, 8)) {
      return HistoryConstSalary2013var08.MIN_MONTHLY_WAGE
    }
    return HistoryConstSalary2013.MIN_MONTHLY_WAGE
  }

  override def minHourlyWage(period: IPeriod): Int = {
    if (isPeriodGreaterOrEqualThan(period, 2013, 8)) {
      return HistoryConstSalary2013var08.MIN_HOURLY_WAGE
    }
    return HistoryConstSalary2013.MIN_HOURLY_WAGE
  }
}
