package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.props.PropsSalary
import org.hravemzdy.legalios.providers.IProviderSalary
import org.hravemzdy.legalios.providers.period2022.{ProviderSalary2022}

class FactorySalary extends ProviderFactory[IProviderSalary, IPropsSalary] with ISalaryFactory {
  override val defaultProvider: IProviderSalary = new ProviderSalary2022()

  override val emptyPeriodProps: IPropsSalary = PropsSalary.empty()

  override val versions: Map[VERSION, IProviderSalary] = ProviderFactory.buildVersions[IProviderSalary, IPropsSalary]()
//    Map[VERSION, IProviderSalary](
//    HistoryConstSalary2011.VERSION_CODE -> new ProviderSalary2011(),
//    HistoryConstSalary2012.VERSION_CODE -> new ProviderSalary2012(),
//    HistoryConstSalary2013.VERSION_CODE -> new ProviderSalary2013(),
//    HistoryConstSalary2014.VERSION_CODE -> new ProviderSalary2014(),
//    HistoryConstSalary2015.VERSION_CODE -> new ProviderSalary2015(),
//    HistoryConstSalary2016.VERSION_CODE -> new ProviderSalary2016(),
//    HistoryConstSalary2017.VERSION_CODE -> new ProviderSalary2017(),
//    HistoryConstSalary2018.VERSION_CODE -> new ProviderSalary2018(),
//    HistoryConstSalary2019.VERSION_CODE -> new ProviderSalary2019(),
//    HistoryConstSalary2020.VERSION_CODE -> new ProviderSalary2020(),
//    HistoryConstSalary2021.VERSION_CODE -> new ProviderSalary2021(),
//    HistoryConstSalary2022.VERSION_CODE -> new ProviderSalary2022(),
//  )
}
