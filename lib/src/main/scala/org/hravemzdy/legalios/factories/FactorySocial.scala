package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.props.PropsSocial
import org.hravemzdy.legalios.providers.IProviderSocial
import org.hravemzdy.legalios.providers.period2022.{ProviderSocial2022}

class FactorySocial extends ProviderFactory[IProviderSocial, IPropsSocial] with ISocialFactory {
  override val defaultProvider: IProviderSocial = new ProviderSocial2022()

  override val emptyPeriodProps: IPropsSocial = PropsSocial.empty()

  override val versions: Map[VERSION, IProviderSocial] = ProviderFactory.buildVersions[IProviderSocial, IPropsSocial]()
//    Map[VERSION, IProviderSocial](
//    HistoryConstSocial2011.VERSION_CODE -> new ProviderSocial2011(),
//    HistoryConstSocial2012.VERSION_CODE -> new ProviderSocial2012(),
//    HistoryConstSocial2013.VERSION_CODE -> new ProviderSocial2013(),
//    HistoryConstSocial2014.VERSION_CODE -> new ProviderSocial2014(),
//    HistoryConstSocial2015.VERSION_CODE -> new ProviderSocial2015(),
//    HistoryConstSocial2016.VERSION_CODE -> new ProviderSocial2016(),
//    HistoryConstSocial2017.VERSION_CODE -> new ProviderSocial2017(),
//    HistoryConstSocial2018.VERSION_CODE -> new ProviderSocial2018(),
//    HistoryConstSocial2019.VERSION_CODE -> new ProviderSocial2019(),
//    HistoryConstSocial2020.VERSION_CODE -> new ProviderSocial2020(),
//    HistoryConstSocial2021.VERSION_CODE -> new ProviderSocial2021(),
//    HistoryConstSocial2022.VERSION_CODE -> new ProviderSocial2022(),
//  )
}
