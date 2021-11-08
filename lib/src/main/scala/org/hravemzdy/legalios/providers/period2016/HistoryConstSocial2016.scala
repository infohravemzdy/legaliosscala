package org.hravemzdy.legalios.providers.period2016

import org.hravemzdy.legalios.providers.period2015.HistoryConstSocial2015

// MAX_ANNUALS_BASIS            Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)
//
// FACTOR_EMPLOYER              Sazba - standardní sociálního pojištění - zaměstnavatele
//
// FACTOR_EMPLOYER_HIGHER       Sazba - vyší sociálního pojištění - zaměstnavatele
//
// FACTOR_EMPLOYEE              Sazba sociálního pojištění - zaměstnance
//
// FACTOR_EMPLOYEE_REDUCE       Snížení sazby sociálního pojištění - zaměstnance - s důchodovým spořením
//
// FACTOR_EMPLOYEE_GARANT       Sazba důchodového spoření - zaměstnance - s důchodovým spořením
//
// MARGIN_INCOME_EMP            hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru
//
// MARGIN_INCOME_AGR            hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu

object HistoryConstSocial2016 {
    val VERSION_CODE:Int = 2016

    val MAX_ANNUALS_BASIS:Int = 1296288
    val FACTOR_EMPLOYER:BigDecimal = HistoryConstSocial2015.FACTOR_EMPLOYER
    val FACTOR_EMPLOYER_HIGHER:BigDecimal = HistoryConstSocial2015.FACTOR_EMPLOYER_HIGHER
    val FACTOR_EMPLOYEE:BigDecimal = HistoryConstSocial2015.FACTOR_EMPLOYEE
    val FACTOR_EMPLOYEE_REDUCE:BigDecimal = BigDecimal.valueOf(0)
    val FACTOR_EMPLOYEE_GARANT:BigDecimal = BigDecimal.valueOf(0)
    val MARGIN_INCOME_EMP:Int = HistoryConstSocial2015.MARGIN_INCOME_EMP
    val MARGIN_INCOME_AGR:Int = HistoryConstSocial2015.MARGIN_INCOME_AGR
}

