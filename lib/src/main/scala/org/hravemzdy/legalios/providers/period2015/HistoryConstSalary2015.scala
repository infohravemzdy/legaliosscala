package org.hravemzdy.legalios.providers.period2015

import org.hravemzdy.legalios.providers.period2014.HistoryConstSalary2014

// WORKING_SHIFT_WEEK      Počet pracovních dnů v týdnu
//
// WORKING_SHIFT_TIME      Počet pracovních hodin denně
//
// MIN_MONTHLY_WAGE        Minimální mzda měsíční
//
// MIN_HOURLY_WAGE         Minimální mzda hodinová (100*Kč)

object HistoryConstSalary2015 {
    val VERSION_CODE = 2015

    val WORKING_SHIFT_WEEK:Int = HistoryConstSalary2014.WORKING_SHIFT_WEEK
    val WORKING_SHIFT_TIME:Int = HistoryConstSalary2014.WORKING_SHIFT_TIME
    val MIN_MONTHLY_WAGE:Int = 9200
    val MIN_HOURLY_WAGE:Int = 5500
}

