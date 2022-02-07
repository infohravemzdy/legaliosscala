package org.hravemzdy.legalios.providers.period2010

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

object HistoryConstTaxing2010 {
  val VERSION_CODE:Int = 2010

  val ALLOWANCE_PAYER:Int = 2070
  val ALLOWANCE_DISAB_1ST:Int = 210
  val ALLOWANCE_DISAB_2ND:Int = 420
  val ALLOWANCE_DISAB_3RD:Int = 1345
  val ALLOWANCE_STUDY:Int = 335
  val ALLOWANCE_CHILD_1ST:Int = 967
  val ALLOWANCE_CHILD_2ND:Int = 967
  val ALLOWANCE_CHILD_3RD:Int = 967
  val FACTOR_ADVANCES:BigDecimal = BigDecimal("15")
  val FACTOR_WITHHOLD:BigDecimal = BigDecimal("15")
  val FACTOR_SOLIDARY:BigDecimal = BigDecimal.valueOf(0)
  val FACTOR_TAXRATE2:BigDecimal = BigDecimal.valueOf(0)
  val MIN_AMOUNT_OF_TAXBONUS:Int = 50
  val MAX_AMOUNT_OF_TAXBONUS:Int = 4350
  val MARGIN_INCOME_OF_TAXBONUS:Int = (HistoryConstSalary2010.MIN_MONTHLY_WAGE / 2)
  val MARGIN_INCOME_OF_ROUNDING:Int = 100
  val MARGIN_INCOME_OF_WITHHOLD:Int = 5000
  val MARGIN_INCOME_OF_SOLIDARY:Int = 0
  val MARGIN_INCOME_OF_TAXRATE2:Int = 0
  val MARGIN_INCOME_OF_WHT_EMP:Int = 0
  val MARGIN_INCOME_OF_WHT_AGR:Int = 0
}
