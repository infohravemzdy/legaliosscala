package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.props.PropsHealth
import org.hravemzdy.legalios.providers.IProviderHealth
import org.hravemzdy.legalios.providers.period2022.{ProviderHealth2022}

class FactoryHealth extends ProviderFactory[IProviderHealth, IPropsHealth] with IHealthFactory {
  override val defaultProvider: IProviderHealth = new ProviderHealth2022()

  override val emptyPeriodProps: IPropsHealth = PropsHealth.empty()

  override val versions: Map[VERSION, IProviderHealth] = ProviderFactory.buildVersions[IProviderHealth, IPropsHealth]()
//    Map[VERSION, IProviderHealth](
//    HistoryConstHealth2011.VERSION_CODE -> new ProviderHealth2011(),
//    HistoryConstHealth2012.VERSION_CODE -> new ProviderHealth2012(),
//    HistoryConstHealth2013.VERSION_CODE -> new ProviderHealth2013(),
//    HistoryConstHealth2014.VERSION_CODE -> new ProviderHealth2014(),
//    HistoryConstHealth2015.VERSION_CODE -> new ProviderHealth2015(),
//    HistoryConstHealth2016.VERSION_CODE -> new ProviderHealth2016(),
//    HistoryConstHealth2017.VERSION_CODE -> new ProviderHealth2017(),
//    HistoryConstHealth2018.VERSION_CODE -> new ProviderHealth2018(),
//    HistoryConstHealth2019.VERSION_CODE -> new ProviderHealth2019(),
//    HistoryConstHealth2020.VERSION_CODE -> new ProviderHealth2020(),
//    HistoryConstHealth2021.VERSION_CODE -> new ProviderHealth2021(),
//    HistoryConstHealth2022.VERSION_CODE -> new ProviderHealth2022(),
//  )
}
