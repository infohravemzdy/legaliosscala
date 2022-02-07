package org.hravemzdy.legalios.providers.period2010

// MIN_MONTHLY_BASIS     Minimální základ zdravotního pojištění na jednoho pracovníka
//
// MAX_ANNUALS_BASIS     Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)
//
// LIM_MONTHLY_STATE     Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci)
//
// LIM_MONTHLY_DIS50     Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci)
//                      u zaměstnavatele zaměstnávajícího více než 50% osob OZP
// FACTOR_COMPOUND       složená sazba zdravotního pojištění (zaměstnace + zaměstnavatele)
//
// FACTOR_EMPLOYEE       podíl sazby zdravotního pojištění připadajícího na zaměstnace (1/FACTOR_EMPLOYEE)
//
// MARGIN_INCOME_EMP     hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru
//
// MARGIN_INCOME_AGR     hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu

object HistoryConstHealth2010 {
  val VERSION_CODE = 2010

  val MIN_MONTHLY_BASIS:Int = HistoryConstSalary2010.MIN_MONTHLY_WAGE
  val MAX_ANNUALS_BASIS:Int = 1707048
  val LIM_MONTHLY_STATE:Int = 0
  val LIM_MONTHLY_DIS50:Int = 5355
  val FACTOR_COMPOUND:BigDecimal = BigDecimal("13.5")
  val FACTOR_EMPLOYEE:BigDecimal = BigDecimal("3")
  val MARGIN_INCOME_EMP:Int = 2000
  val MARGIN_INCOME_AGR:Int = MARGIN_INCOME_EMP
}
