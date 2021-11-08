package org.hravemzdy.legalios.providers.period2021

import org.hravemzdy.legalios.providers.period2020.HistoryConstHealth2020

// MIN_MONTHLY_BASIS     Minimální základ zdravotního pojištění na jednoho pracovníka
//
// MAX_ANNUALS_BASIS     Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)
//
// LIM_MONTHLY_STATE     Vyměřovací základ ze kterého platí pojistnéé stát za státní pojištěnce (mateřská, studenti, důchodci)
//
// LIM_MONTHLY_DIS50     Vyměřovací základ ze kterého platí pojistnéé stát za státní pojištěnce (mateřská, studenti, důchodci)
//                      u zaměstnavatele zaměstnávajícího více než 50% osob OZP
// FACTOR_COMPOUND       složená sazba zdravotního pojištění (zaměstnace + zaměstnavatele)
//
// FACTOR_EMPLOYEE       podíl sazby zdravotního pojištění připadajícího na zaměstnace (1/FACTOR_EMPLOYEE)
//
// MARGIN_INCOME_EMP     hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru
//
// MARGIN_INCOME_AGR     hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu

object HistoryConstHealth2021 {
    val VERSION_CODE = 2021

    val MIN_MONTHLY_BASIS:Int = HistoryConstSalary2021.MIN_MONTHLY_WAGE
    val MAX_ANNUALS_BASIS:Int = HistoryConstHealth2020.MAX_ANNUALS_BASIS
    val LIM_MONTHLY_STATE:Int = HistoryConstHealth2020.LIM_MONTHLY_STATE
    val LIM_MONTHLY_DIS50:Int = 13088
    val FACTOR_COMPOUND:BigDecimal = HistoryConstHealth2020.FACTOR_COMPOUND
    val FACTOR_EMPLOYEE:BigDecimal = HistoryConstHealth2020.FACTOR_EMPLOYEE
    val MARGIN_INCOME_EMP:Int = 3500
    val MARGIN_INCOME_AGR:Int = HistoryConstHealth2020.MARGIN_INCOME_AGR
}

