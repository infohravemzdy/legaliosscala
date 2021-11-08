package org.hravemzdy.legalios.providers.period2013

import org.hravemzdy.legalios.providers.period2012.HistoryConstTaxing2012

// ALLOWANCE_PAYER                  Částka slevy na poplatníka
//
// ALLOWANCE_DISAB_1ST              Částka slevy na invaliditu 1.stupně poplatníka
//
// ALLOWANCE_DISAB_2ND              Částka slevy na invaliditu 2.stupně poplatníka
//
// ALLOWANCE_DISAB_3RD              Částka slevy na invaliditu 3.stupně poplatníka
//
// ALLOWANCE_STUDY                  Částka slevy na poplatníka studenta
//
// ALLOWANCE_CHILD_1ST              Částka slevy na dítě 1.pořadí
//
// ALLOWANCE_CHILD_2ND              Částka slevy na dítě 2.pořadí
//
// ALLOWANCE_CHILD_3RD              Částka slevy na dítě 3.pořadí
//
// FACTOR_ADVANCES                  Sazba daně na zálohový příjem
//
// FACTOR_WITHHOLD                  Sazba daně na srážkový příjem
//
// FACTOR_SOLITARY                  Sazba daně na solidární zvýšení
//
// MIN_AMOUNT_OF_TAXBONUS           Minimální částka pro daňový bonus
//
// MAX_AMOUNT_OF_TAXBONUS           Maximální částka pro daňový bonus
//
// MARGIN_INCOME_OF_TAXBONUS        Minimální výše příjmu pro nároku na daňový bonus
//
// MARGIN_INCOME_OF_ROUNDING        Maximální výše příjmu pro zaokrouhlování
//
// MARGIN_INCOME_OF_WITHHOLD        Maximální výše příjmu pro srážkový příjem
//
// MARGIN_INCOME_OF_SOLITARY        Minimální výše příjmu pro solidární zvýšení daně
//
// MARGIN_INCOME_OF_WHT_AGR         hranice příjmu pro srážkovou daň pro zaměstnace v pracovním poměru (nepodepsal prohlášení)
//
// MARGIN_INCOME_OF_WHT_EMP         hranice příjmu pro srážkovou daň pro zaměstnace na dohodu (nepodepsal prohlášení)

object HistoryConstTaxing2013 {
    val VERSION_CODE:Int = 2013

    val ALLOWANCE_PAYER:Int = HistoryConstTaxing2012.ALLOWANCE_PAYER
    val ALLOWANCE_DISAB_1ST:Int = HistoryConstTaxing2012.ALLOWANCE_DISAB_1ST
    val ALLOWANCE_DISAB_2ND:Int = HistoryConstTaxing2012.ALLOWANCE_DISAB_2ND
    val ALLOWANCE_DISAB_3RD:Int = HistoryConstTaxing2012.ALLOWANCE_DISAB_3RD
    val ALLOWANCE_STUDY:Int = HistoryConstTaxing2012.ALLOWANCE_STUDY
    val ALLOWANCE_CHILD_1ST:Int = HistoryConstTaxing2012.ALLOWANCE_CHILD_1ST
    val ALLOWANCE_CHILD_2ND:Int = HistoryConstTaxing2012.ALLOWANCE_CHILD_2ND
    val ALLOWANCE_CHILD_3RD:Int = HistoryConstTaxing2012.ALLOWANCE_CHILD_3RD
    val FACTOR_ADVANCES:BigDecimal = HistoryConstTaxing2012.FACTOR_ADVANCES
    val FACTOR_WITHHOLD:BigDecimal = HistoryConstTaxing2012.FACTOR_WITHHOLD
    val FACTOR_SOLITARY:BigDecimal = BigDecimal("7")
    val MIN_AMOUNT_OF_TAXBONUS:Int = HistoryConstTaxing2012.MIN_AMOUNT_OF_TAXBONUS
    val MAX_AMOUNT_OF_TAXBONUS:Int = HistoryConstTaxing2012.MAX_AMOUNT_OF_TAXBONUS
    val MARGIN_INCOME_OF_TAXBONUS:Int = (HistoryConstSalary2013.MIN_MONTHLY_WAGE / 2)
    val MARGIN_INCOME_OF_ROUNDING:Int = HistoryConstTaxing2012.MARGIN_INCOME_OF_ROUNDING
    val MARGIN_INCOME_OF_WITHHOLD:Int = HistoryConstTaxing2012.MARGIN_INCOME_OF_WITHHOLD
    val MARGIN_INCOME_OF_SOLITARY:Int = (4 * 25884)
    val MARGIN_INCOME_OF_WHT_EMP:Int = HistoryConstTaxing2012.MARGIN_INCOME_OF_WHT_EMP
    val MARGIN_INCOME_OF_WHT_AGR:Int = HistoryConstTaxing2012.MARGIN_INCOME_OF_WHT_AGR
}

