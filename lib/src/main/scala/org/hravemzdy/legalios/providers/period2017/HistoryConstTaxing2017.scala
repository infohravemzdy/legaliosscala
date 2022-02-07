package org.hravemzdy.legalios.providers.period2017

import org.hravemzdy.legalios.providers.period2016.HistoryConstTaxing2016
import org.hravemzdy.legalios.providers.period2016.HistoryConstTaxing2016var05

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
// FACTOR_SOLIDARY                  Sazba daně na solidární zvýšení
//
// FACTOR_TAXRATE2                  Sazba daně na druhé pásmo daně
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
// MARGIN_INCOME_OF_SOLIDARY        Minimální výše příjmu pro solidární zvýšení daně
//
// MARGIN_INCOME_OF_TAXRATE2        Minimální výše příjmu pro druhé pásmo daně
//
// MARGIN_INCOME_OF_WHT_AGR         hranice příjmu pro srážkovou daň pro zaměstnace v pracovním poměru (nepodepsal prohlášení)
//
// MARGIN_INCOME_OF_WHT_EMP         hranice příjmu pro srážkovou daň pro zaměstnace na dohodu (nepodepsal prohlášení)

object HistoryConstTaxing2017var07 {
    val ALLOWANCE_CHILD_2ND:Int = 1617
    val ALLOWANCE_CHILD_3RD:Int = 2017
}

object HistoryConstTaxing2017 {
    val VERSION_CODE:Int = 2017

    val ALLOWANCE_PAYER:Int = HistoryConstTaxing2016.ALLOWANCE_PAYER
    val ALLOWANCE_DISAB_1ST:Int = HistoryConstTaxing2016.ALLOWANCE_DISAB_1ST
    val ALLOWANCE_DISAB_2ND:Int = HistoryConstTaxing2016.ALLOWANCE_DISAB_2ND
    val ALLOWANCE_DISAB_3RD:Int = HistoryConstTaxing2016.ALLOWANCE_DISAB_3RD
    val ALLOWANCE_STUDY:Int = HistoryConstTaxing2016.ALLOWANCE_STUDY
    val ALLOWANCE_CHILD_1ST:Int = HistoryConstTaxing2016.ALLOWANCE_CHILD_1ST
    val ALLOWANCE_CHILD_2ND:Int = HistoryConstTaxing2016var05.ALLOWANCE_CHILD_2ND
    val ALLOWANCE_CHILD_3RD:Int = HistoryConstTaxing2016var05.ALLOWANCE_CHILD_3RD
    val FACTOR_ADVANCES:BigDecimal = HistoryConstTaxing2016.FACTOR_ADVANCES
    val FACTOR_WITHHOLD:BigDecimal = HistoryConstTaxing2016.FACTOR_WITHHOLD
    val FACTOR_SOLIDARY:BigDecimal = HistoryConstTaxing2016.FACTOR_SOLIDARY
    val FACTOR_TAXRATE2:BigDecimal = HistoryConstTaxing2016.FACTOR_TAXRATE2
    val MIN_AMOUNT_OF_TAXBONUS:Int = HistoryConstTaxing2016.MIN_AMOUNT_OF_TAXBONUS
    val MAX_AMOUNT_OF_TAXBONUS:Int = HistoryConstTaxing2016.MAX_AMOUNT_OF_TAXBONUS
    val MARGIN_INCOME_OF_TAXBONUS:Int = (HistoryConstSalary2017.MIN_MONTHLY_WAGE / 2)
    val MARGIN_INCOME_OF_ROUNDING:Int = HistoryConstTaxing2016.MARGIN_INCOME_OF_ROUNDING
    val MARGIN_INCOME_OF_WITHHOLD:Int = HistoryConstTaxing2016.MARGIN_INCOME_OF_WITHHOLD
    val MARGIN_INCOME_OF_SOLIDARY:Int = (4 * 28232)
    val MARGIN_INCOME_OF_TAXRATE2:Int = HistoryConstTaxing2016.MARGIN_INCOME_OF_TAXRATE2
    val MARGIN_INCOME_OF_WHT_EMP:Int = HistoryConstTaxing2016.MARGIN_INCOME_OF_WHT_EMP
    val MARGIN_INCOME_OF_WHT_AGR:Int = HistoryConstTaxing2016.MARGIN_INCOME_OF_WHT_AGR
}

