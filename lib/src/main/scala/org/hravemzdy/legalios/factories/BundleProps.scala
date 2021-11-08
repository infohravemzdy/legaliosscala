package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.{IBundleProps, IPeriod, IPropsHealth, IPropsSalary, IPropsSocial, IPropsTaxing}
import org.hravemzdy.legalios.props.{PropsHealth, PropsSalary, PropsSocial, PropsTaxing}
import org.hravemzdy.legalios.service.types.Period

class BundleProps(
  override val periodProps: IPeriod,
  override val salaryProps: IPropsSalary,
  override val healthProps: IPropsHealth,
  override val socialProps: IPropsSocial,
  override val taxingProps: IPropsTaxing) extends IBundleProps {

  override def getPeriodYear(): Int = {
    return periodProps.year
  }

  override def getPeriodMonth(): Int = {
    return periodProps.month
  }

  override def getPeriodCode(): Int = {
    return periodProps.code
  }
}

object BundleProps {
  def empty(period: IPeriod): IBundleProps = {
    return new BundleProps(period,
      PropsSalary.empty(),
      PropsHealth.empty(),
      PropsSocial.empty(),
      PropsTaxing.empty())
  }
}