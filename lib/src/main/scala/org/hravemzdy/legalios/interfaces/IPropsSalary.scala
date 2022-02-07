package org.hravemzdy.legalios.interfaces

trait IPropsSalary extends IProps {
  val workingShiftWeek : Int
  val workingShiftTime : Int
  val minMonthlyWage : Int
  val minHourlyWage : Int

  def valueEquals(other: Option[IPropsSalary]): Boolean
  def coeffWithPartAndFullHours(fullWorkHours: BigDecimal, partWorkHours: BigDecimal): BigDecimal
  def paymentWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
    fullWeekHours: Int, partWeekHours: Int,
    fullWorkHours: Int, partWorkHours: Int): BigDecimal
  def paymentRoundUpWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
    fullWeekHours: Int, partWeekHours: Int,
    fullWorkHours: Int, partWorkHours: Int): BigDecimal
  def paymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal,
    monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal
  def paymentRoundUpWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal,
    monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal
  def paymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal,
    monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def paymentRoundUpWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal,
    monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def relativeTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def relativePaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def reverzedTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def reverzedPaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
  def paymentWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal
  def paymentRoundUpWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal
  def tariffWithPaymentAndHours(amountHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal
  def paymentWithAmountFixed(amountFixed: BigDecimal): BigDecimal
  def paymentRoundUpWithAmountFixed(amountFixed: BigDecimal): BigDecimal
  def hoursToHalfHoursUp(hoursValue: BigDecimal): BigDecimal
  def hoursToQuartHoursUp(hoursValue: BigDecimal): BigDecimal
  def hoursToHalfHoursDown(hoursValue: BigDecimal): BigDecimal
  def hoursToQuartHoursDown(hoursValue: BigDecimal): BigDecimal
  def hoursToHalfHoursNorm(hoursValue: BigDecimal): BigDecimal
  def hoursToQuartHoursNorm(hoursValue: BigDecimal): BigDecimal
  def moneyToRoundDown(moneyValue: BigDecimal): BigDecimal
  def moneyToRoundUp(moneyValue: BigDecimal): BigDecimal
  def moneyToRoundNorm(moneyValue: BigDecimal): BigDecimal
}
