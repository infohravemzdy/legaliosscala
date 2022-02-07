package org.hravemzdy.legalios.providers.period2011

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsHealth}
import org.hravemzdy.legalios.props.{PropsHealth, PropsHealth2010}
import org.hravemzdy.legalios.providers.{IProviderHealth, ProviderBase}

class ProviderHealth2011 extends ProviderBase(HistoryConstHealth2011.VERSION_CODE) with IProviderHealth {
  override def getProps(period: IPeriod): IPropsHealth = {
    return new PropsHealth2010(
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
    return HistoryConstHealth2011.MIN_MONTHLY_BASIS
  }

  override def maxAnnualsBasis(period: IPeriod): Int = {
    return HistoryConstHealth2011.MAX_ANNUALS_BASIS
  }

  override def limMonthlyState(period: IPeriod): Int = {
    return HistoryConstHealth2011.LIM_MONTHLY_STATE
  }

  override def limMonthlyDis50(period: IPeriod): Int = {
    return HistoryConstHealth2011.LIM_MONTHLY_DIS50
  }

  override def factorCompound(period: IPeriod): BigDecimal = {
    return HistoryConstHealth2011.FACTOR_COMPOUND
  }

  override def factorEmployee(period: IPeriod):BigDecimal = {
    return HistoryConstHealth2011.FACTOR_EMPLOYEE
  }

  override def marginIncomeEmp(period: IPeriod): Int = {
    return HistoryConstHealth2011.MARGIN_INCOME_EMP
  }

  override def marginIncomeAgr(period: IPeriod): Int = {
    return HistoryConstHealth2011.MARGIN_INCOME_AGR
  }
}
