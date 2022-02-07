package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.{IBundleProps, IPeriod, IProps, IPropsHealth, IPropsSalary, IPropsSocial, IPropsTaxing}
import org.hravemzdy.legalios.service.types.BundleProps

class BundleBuilder(private val salaryFactory : ISalaryFactory,
                    private val healthFactory : IHealthFactory,
                    private val socialFactory : ISocialFactory,
                    private val taxingFactory : ITaxingFactory) extends IBundleBuilder {
  def this() = {
    this(
      new FactorySalary(),
      new FactoryHealth(),
      new FactorySocial(),
      new FactoryTaxing())
  }

  override def getBundle(period: IPeriod): IBundleProps = {
    val salary: IPropsSalary = getSalaryProps(period)
    val health: IPropsHealth = getHealthProps(period)
    val social: IPropsSocial = getSocialProps(period)
    val taxing: IPropsTaxing = getTaxingProps(period)

    if (BundleBuilder.isValidBundle(salary, health, social, taxing)) {
      return new BundleProps(period, salary, health, social, taxing)
    }
    return null
  }
  private def getSalaryProps(period: IPeriod): IPropsSalary = {
    return salaryFactory.getProps(period)
  }

  private def getHealthProps(period: IPeriod): IPropsHealth = {
    return healthFactory.getProps(period)
  }

  private def getSocialProps(period: IPeriod): IPropsSocial = {
    return socialFactory.getProps(period)
  }

  private def getTaxingProps(period: IPeriod): IPropsTaxing = {
    return taxingFactory.getProps(period)
  }
}

object BundleBuilder {
  private val MIN_VERSION: Int = 2010

  private def isNullOrEmpty(props: IProps): Boolean = {
    return (props.version.value < MIN_VERSION)
  }

  private def isValidBundle(
                             salary: IProps,
                             health: IProps,
                             social: IProps,
                             taxing: IProps): Boolean = {
    if (isNullOrEmpty(salary)) {
      return false
    }
    if (isNullOrEmpty(health)) {
      return false
    }
    if (isNullOrEmpty(social)) {
      return false
    }
    if (isNullOrEmpty(taxing)) {
      return false
    }
    return true
  }
}


