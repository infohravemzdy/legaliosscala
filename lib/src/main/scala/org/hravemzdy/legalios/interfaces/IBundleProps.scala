package org.hravemzdy.legalios.interfaces

trait IBundleProps {
  val periodProps: IPeriod
  val salaryProps: IPropsSalary
  val healthProps: IPropsHealth
  val socialProps: IPropsSocial
  val taxingProps: IPropsTaxing

  def getPeriodYear(): Int
  def getPeriodMonth(): Int
  def getPeriodCode(): Int
}
