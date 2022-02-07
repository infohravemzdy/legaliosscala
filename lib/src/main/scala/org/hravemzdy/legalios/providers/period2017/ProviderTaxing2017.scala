package org.hravemzdy.legalios.providers.period2017

import org.hravemzdy.legalios.interfaces.{IPeriod, IPropsTaxing}
import org.hravemzdy.legalios.props.PropsTaxing
import org.hravemzdy.legalios.providers.{IProviderTaxing, ProviderBase}

class ProviderTaxing2017 extends ProviderBase(HistoryConstTaxing2017.VERSION_CODE) with IProviderTaxing {
  override def getProps(period: IPeriod): IPropsTaxing = {
    return new PropsTaxing(
      version,
      allowancePayer(period),
      allowanceDisab1st(period),
      allowanceDisab2nd(period),
      allowanceDisab3rd(period),
      allowanceStudy(period),
      allowanceChild1st(period),
      allowanceChild2nd(period),
      allowanceChild3rd(period),
      factorAdvances(period),
      factorWithhold(period),
      factorSolidary(period),
      minAmountOfTaxBonus(period),
      maxAmountOfTaxBonus(period),
      marginIncomeOfTaxBonus(period),
      marginIncomeOfRounding(period),
      marginIncomeOfWithhold(period),
      marginIncomeOfSolidary(period),
      marginIncomeOfWthEmp(period),
      marginIncomeOfWthAgr(period))
  }

  override def allowancePayer(period: IPeriod): Int = {
    return HistoryConstTaxing2017.ALLOWANCE_PAYER
  }

  override def allowanceDisab1st(period: IPeriod): Int = {
    return HistoryConstTaxing2017.ALLOWANCE_DISAB_1ST
  }

  override def allowanceDisab2nd(period: IPeriod): Int = {
    return HistoryConstTaxing2017.ALLOWANCE_DISAB_2ND
  }

  override def allowanceDisab3rd(period: IPeriod): Int = {
    return HistoryConstTaxing2017.ALLOWANCE_DISAB_3RD
  }

  override def allowanceStudy(period: IPeriod): Int = {
    return HistoryConstTaxing2017.ALLOWANCE_STUDY
  }

  override def allowanceChild1st(period: IPeriod): Int = {
    return HistoryConstTaxing2017.ALLOWANCE_CHILD_1ST
  }

  override def allowanceChild2nd(period: IPeriod): Int = {
    if (isPeriodGreaterOrEqualThan(period, 2017, 7)) {
      return HistoryConstTaxing2017var07.ALLOWANCE_CHILD_2ND
    }
    return HistoryConstTaxing2017.ALLOWANCE_CHILD_2ND
  }

  override def allowanceChild3rd(period: IPeriod): Int = {
    if (isPeriodGreaterOrEqualThan(period, 2017, 7)) {
      return HistoryConstTaxing2017var07.ALLOWANCE_CHILD_3RD
    }
    return HistoryConstTaxing2017.ALLOWANCE_CHILD_3RD
  }

  override def factorAdvances(period: IPeriod): BigDecimal = {
    return HistoryConstTaxing2017.FACTOR_ADVANCES
  }

  override def factorWithhold(period: IPeriod): BigDecimal = {
    return HistoryConstTaxing2017.FACTOR_WITHHOLD
  }

  override def factorSolidary(period: IPeriod): BigDecimal = {
    return HistoryConstTaxing2017.FACTOR_SOLIDARY
  }

  override def minAmountOfTaxBonus(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MIN_AMOUNT_OF_TAXBONUS
  }

  override def maxAmountOfTaxBonus(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MAX_AMOUNT_OF_TAXBONUS
  }

  override def marginIncomeOfTaxBonus(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MARGIN_INCOME_OF_TAXBONUS
  }

  override def marginIncomeOfRounding(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MARGIN_INCOME_OF_ROUNDING
  }

  override def marginIncomeOfWithhold(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MARGIN_INCOME_OF_WITHHOLD
  }

  override def marginIncomeOfSolidary(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MARGIN_INCOME_OF_SOLIDARY
  }

  override def marginIncomeOfWthEmp(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MARGIN_INCOME_OF_WHT_EMP
  }

  override def marginIncomeOfWthAgr(period: IPeriod): Int = {
    return HistoryConstTaxing2017.MARGIN_INCOME_OF_WHT_AGR
  }
}
