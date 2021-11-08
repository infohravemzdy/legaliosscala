package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.props.PropsTaxing
import org.hravemzdy.legalios.providers.IProviderTaxing
import org.hravemzdy.legalios.providers.period2022.{ProviderTaxing2022}

class FactoryTaxing extends ProviderFactory[IProviderTaxing, IPropsTaxing] with ITaxingFactory {
  override val defaultProvider: IProviderTaxing = new ProviderTaxing2022()

  override val emptyPeriodProps: IPropsTaxing = PropsTaxing.empty()

  override val versions: Map[VERSION, IProviderTaxing] = ProviderFactory.buildVersions[IProviderTaxing, IPropsTaxing]()
//    Map[VERSION, IProviderTaxing](
//    HistoryConstTaxing2011.VERSION_CODE -> new ProviderTaxing2011(),
//    HistoryConstTaxing2012.VERSION_CODE -> new ProviderTaxing2012(),
//    HistoryConstTaxing2013.VERSION_CODE -> new ProviderTaxing2013(),
//    HistoryConstTaxing2014.VERSION_CODE -> new ProviderTaxing2014(),
//    HistoryConstTaxing2015.VERSION_CODE -> new ProviderTaxing2015(),
//    HistoryConstTaxing2016.VERSION_CODE -> new ProviderTaxing2016(),
//    HistoryConstTaxing2017.VERSION_CODE -> new ProviderTaxing2017(),
//    HistoryConstTaxing2018.VERSION_CODE -> new ProviderTaxing2018(),
//    HistoryConstTaxing2019.VERSION_CODE -> new ProviderTaxing2019(),
//    HistoryConstTaxing2020.VERSION_CODE -> new ProviderTaxing2020(),
//    HistoryConstTaxing2021.VERSION_CODE -> new ProviderTaxing2021(),
//    HistoryConstTaxing2022.VERSION_CODE -> new ProviderTaxing2022(),
//  )
}
