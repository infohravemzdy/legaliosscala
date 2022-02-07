package org.hravemzdy.legalios.providers.period2010

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsSocial}
import org.hravemzdy.legalios.props.{PropsSocial, PropsSocial2010}
import org.hravemzdy.legalios.providers.{IProviderSocial, ProviderBase}

class ProviderSocial2010 extends ProviderBase(HistoryConstSocial2010.VERSION_CODE) with IProviderSocial {
  override def getProps(period: IPeriod): IPropsSocial = {
    return new PropsSocial2010(
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
    return HistoryConstSocial2010.MAX_ANNUALS_BASIS
  }

  override def factorEmployer(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2010.FACTOR_EMPLOYER
  }

  override def factorEmployerHigher(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2010.FACTOR_EMPLOYER_HIGHER
  }

  override def factorEmployee(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2010.FACTOR_EMPLOYEE
  }

  override def factorEmployeeGarant(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2010.FACTOR_EMPLOYEE_GARANT
  }

  override def factorEmployeeReduce(period: IPeriod): BigDecimal = {
    return HistoryConstSocial2010.FACTOR_EMPLOYEE_REDUCE
  }

  override def marginIncomeEmp(period: IPeriod): Int = {
    return HistoryConstSocial2010.MARGIN_INCOME_EMP
  }

  override def marginIncomeAgr(period: IPeriod): Int = {
    return HistoryConstSocial2010.MARGIN_INCOME_AGR
  }
}
