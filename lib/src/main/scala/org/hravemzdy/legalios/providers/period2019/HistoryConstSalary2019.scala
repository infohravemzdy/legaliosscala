package org.hravemzdy.legalios.providers.period2019

import org.hravemzdy.legalios.providers.period2018.HistoryConstSalary2018

// WORKING_SHIFT_WEEK      Počet pracovních dnů v týdnu
//
// WORKING_SHIFT_TIME      Počet pracovních hodin denně
//
// MIN_MONTHLY_WAGE        Minimální mzda měsíční
//
// MIN_HOURLY_WAGE         Minimální mzda hodinová (100*Kč)

object HistoryConstSalary2019 {
    val VERSION_CODE = 2019

    val WORKING_SHIFT_WEEK:Int = HistoryConstSalary2018.WORKING_SHIFT_WEEK
    val WORKING_SHIFT_TIME:Int = HistoryConstSalary2018.WORKING_SHIFT_TIME
    val MIN_MONTHLY_WAGE:Int = 13350
    val MIN_HOURLY_WAGE:Int = 7980
}

