package org.hravemzdy.legalios.providers.period2014

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsHealth}
import org.hravemzdy.legalios.props.{PropsHealth, PropsHealth2014}
import org.hravemzdy.legalios.providers.{IProviderHealth, ProviderBase}

class ProviderHealth2014 extends ProviderBase(HistoryConstHealth2014.VERSION_CODE) with IProviderHealth {
  override def getProps(period: IPeriod): IPropsHealth = {
    return new PropsHealth2014(
      version,
      minMonthlyBasis(period),
      maxAnnualsBasis(period),
      limMonthlyState(period),
      limMonthlyDis50(period),
      factorCompound(period),
      factorEmployee(period),
      marginIncomeEmp(period),
      marginIncomeAgr(period)
    )
  }

  override def minMonthlyBasis(period: IPeriod): Int = {
    return HistoryConstHealth2014.MIN_MONTHLY_BASIS
  }

  override def maxAnnualsBasis(period: IPeriod): Int = {
    return HistoryConstHealth2014.MAX_ANNUALS_BASIS
  }

  override def limMonthlyState(period: IPeriod): Int = {
    return HistoryConstHealth2014.LIM_MONTHLY_STATE
  }

  override def limMonthlyDis50(period: IPeriod): Int = {
    if (isPeriodGreaterOrEqualThan(period, 2014, 7)) {
      return HistoryConstHealth2014var07.LIM_MONTHLY_DIS50
    }
    return HistoryConstHealth2014.LIM_MONTHLY_DIS50
  }

  override def factorCompound(period: IPeriod): BigDecimal = {
    return HistoryConstHealth2014.FACTOR_COMPOUND
  }

  override def factorEmployee(period: IPeriod):BigDecimal = {
    return HistoryConstHealth2014.FACTOR_EMPLOYEE
  }

  override def marginIncomeEmp(period: IPeriod): Int = {
    return HistoryConstHealth2014.MARGIN_INCOME_EMP
  }

  override def marginIncomeAgr(period: IPeriod): Int = {
    return HistoryConstHealth2014.MARGIN_INCOME_AGR
  }
}
