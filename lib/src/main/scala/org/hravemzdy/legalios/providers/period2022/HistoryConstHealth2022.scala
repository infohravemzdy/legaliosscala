package org.hravemzdy.legalios.providers.period2022

import org.hravemzdy.legalios.providers.period2021.HistoryConstHealth2021

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

object HistoryConstHealth2022 {
    val VERSION_CODE = 2022

    val MIN_MONTHLY_BASIS:Int = HistoryConstSalary2022.MIN_MONTHLY_WAGE
    val MAX_ANNUALS_BASIS:Int = HistoryConstHealth2021.MAX_ANNUALS_BASIS
    val LIM_MONTHLY_STATE:Int = HistoryConstHealth2021.LIM_MONTHLY_STATE
    val LIM_MONTHLY_DIS50:Int = 14570
    val FACTOR_COMPOUND:BigDecimal = HistoryConstHealth2021.FACTOR_COMPOUND
    val FACTOR_EMPLOYEE:BigDecimal = HistoryConstHealth2021.FACTOR_EMPLOYEE
    val MARGIN_INCOME_EMP:Int = HistoryConstHealth2021.MARGIN_INCOME_EMP
    val MARGIN_INCOME_AGR:Int = HistoryConstHealth2021.MARGIN_INCOME_AGR
}


