package org.hravemzdy.legalios.providers.period2013

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsHealth}
import org.hravemzdy.legalios.props.{PropsHealth, PropsHealth2012}
import org.hravemzdy.legalios.providers.{IProviderHealth, ProviderBase}

class ProviderHealth2013 extends ProviderBase(HistoryConstHealth2013.VERSION_CODE) with IProviderHealth {
  override def getProps(period: IPeriod): IPropsHealth = {
    return new PropsHealth2012(
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
    if (isPeriodGreaterOrEqualThan(period, 2013, 8)) {
      return HistoryConstHealth2013var08.MIN_MONTHLY_BASIS
    }
    return HistoryConstHealth2013.MIN_MONTHLY_BASIS
  }

  override def maxAnnualsBasis(period: IPeriod): Int = {
    return HistoryConstHealth2013.MAX_ANNUALS_BASIS
  }

  override def limMonthlyState(period: IPeriod): Int = {
    return HistoryConstHealth2013.LIM_MONTHLY_STATE
  }

  override def limMonthlyDis50(period: IPeriod): Int = {
    if (isPeriodGreaterOrEqualThan(period, 2013, 11)) {
      return HistoryConstHealth2013var11.LIM_MONTHLY_DIS50
    }
    return HistoryConstHealth2013.LIM_MONTHLY_DIS50
  }

  override def factorCompound(period: IPeriod): BigDecimal = {
    return HistoryConstHealth2013.FACTOR_COMPOUND
  }

  override def factorEmployee(period: IPeriod):BigDecimal = {
    return HistoryConstHealth2013.FACTOR_EMPLOYEE
  }

  override def marginIncomeEmp(period: IPeriod): Int = {
    return HistoryConstHealth2013.MARGIN_INCOME_EMP
  }

  override def marginIncomeAgr(period: IPeriod): Int = {
    return HistoryConstHealth2013.MARGIN_INCOME_AGR
  }
}
