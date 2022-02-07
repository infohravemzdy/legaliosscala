package org.hravemzdy.legalios.providers.period2013

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsSocial}
import org.hravemzdy.legalios.props.{PropsSocial, PropsSocial2012}
import org.hravemzdy.legalios.providers.{IProviderSocial, ProviderBase}

class ProviderSocial2013 extends ProviderBase(HistoryConstSocial2013.VERSION_CODE) with IProviderSocial {
  override def getProps(period: IPeriod): IPropsSocial = {
    return new PropsSocial2012(
      version,
      maxAnnualsBasis(period),
      factorEmployer(period),
      factorEmployerHigher(period),
      factorEmployee(period),
      factorEmployeeGarant(period),
      factorEmployeeReduce(period),
      marginIncomeEmp(period),
      marginIncomeAgr(period))
  }

  override def maxAnnualsBasis(period: IPeriod): Int = {
    return HistoryConstSocial2013.MAX_ANNUALS_BASIS
  }

  override def factorEmployer(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2013.FACTOR_EMPLOYER
  }

  override def factorEmployerHigher(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2013.FACTOR_EMPLOYER_HIGHER
  }

  override def factorEmployee(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2013.FACTOR_EMPLOYEE
  }

  override def factorEmployeeGarant(period: IPeriod): BigDecimal = {
    if (isPeriodGreaterOrEqualThan(period, 2013, 2)) {
      return HistoryConstSocial2013var02.FACTOR_EMPLOYEE_GARANT
    }
    return HistoryConstSocial2013.FACTOR_EMPLOYEE_GARANT
  }

  override def factorEmployeeReduce(period: IPeriod): BigDecimal = {
    if (isPeriodGreaterOrEqualThan(period, 2013, 2)) {
      return HistoryConstSocial2013var02.FACTOR_EMPLOYEE_REDUCE
    }
    return HistoryConstSocial2013.FACTOR_EMPLOYEE_REDUCE
  }

  override def marginIncomeEmp(period: IPeriod): Int = {
    return HistoryConstSocial2013.MARGIN_INCOME_EMP
  }

  override def marginIncomeAgr(period: IPeriod): Int = {
    return HistoryConstSocial2013.MARGIN_INCOME_AGR
  }
}
