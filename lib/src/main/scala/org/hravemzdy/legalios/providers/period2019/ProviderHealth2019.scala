package org.hravemzdy.legalios.providers.period2019

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsHealth}
import org.hravemzdy.legalios.props.PropsHealth
import org.hravemzdy.legalios.providers.{IProviderHealth, ProviderBase}

class ProviderHealth2019 extends ProviderBase(HistoryConstHealth2019.VERSION_CODE) with IProviderHealth {
  override def getProps(period: IPeriod): IPropsHealth = {
    return new PropsHealth(
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
    return HistoryConstHealth2019.MIN_MONTHLY_BASIS
  }

  override def maxAnnualsBasis(period: IPeriod): Int = {
    return HistoryConstHealth2019.MAX_ANNUALS_BASIS
  }

  override def limMonthlyState(period: IPeriod): Int = {
    return HistoryConstHealth2019.LIM_MONTHLY_STATE
  }

  override def limMonthlyDis50(period: IPeriod): Int = {
    return HistoryConstHealth2019.LIM_MONTHLY_DIS50
  }

  override def factorCompound(period: IPeriod): BigDecimal = {
    return HistoryConstHealth2019.FACTOR_COMPOUND
  }

  override def factorEmployee(period: IPeriod):BigDecimal = {
    return HistoryConstHealth2019.FACTOR_EMPLOYEE
  }

  override def marginIncomeEmp(period: IPeriod): Int = {
    return HistoryConstHealth2019.MARGIN_INCOME_EMP
  }

  override def marginIncomeAgr(period: IPeriod): Int = {
    return HistoryConstHealth2019.MARGIN_INCOME_AGR
  }
}
