package org.hravemzdy.legalios.interfaces

trait IPropsTaxing extends IProps {
  val allowancePayer: Int
  val allowanceDisab1st: Int
  val allowanceDisab2nd : Int
  val allowanceDisab3rd: Int
  val allowanceStudy: Int
  val allowanceChild1st: Int
  val allowanceChild2nd: Int
  val allowanceChild3rd: Int
  val factorAdvances: BigDecimal
  val factorWithhold: BigDecimal
  val factorSolidary: BigDecimal
  val minAmountOfTaxBonus: Int
  val maxAmountOfTaxBonus: Int
  val marginIncomeOfTaxBonus: Int
  val marginIncomeOfRounding: Int
  val marginIncomeOfWithhold: Int
  val marginIncomeOfSolidary: Int
  val marginIncomeOfWthEmp: Int
  val marginIncomeOfWthAgr: Int
}
