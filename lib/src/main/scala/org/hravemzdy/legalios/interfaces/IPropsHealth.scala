package org.hravemzdy.legalios.interfaces

trait IPropsHealth extends IProps {
  val minMonthlyBasis: Int
  val maxAnnualsBasis: Int
  val limMonthlyState: Int
  val limMonthlyDis50: Int
  val factorCompound: BigDecimal
  val factorEmployee: BigDecimal
  val marginIncomeEmp: Int
  val marginIncomeAgr: Int
}
