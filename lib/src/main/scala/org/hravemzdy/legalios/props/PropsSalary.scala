package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.service.types.{OperationsDec, OperationsRound, VersionId}

class PropsSalary(version: VersionId,
                  override val workingShiftWeek: Int,
                  override val workingShiftTime: Int,
                  override val minMonthlyWage: Int,
                  override val minHourlyWage: Int) extends PropsBase(version) with IPropsSalary {

  def this(version: Int) = {
    this(VersionId.get(version), 0,0,0,0)
  }

  private def totalHoursWithFullAndPartHours(fullWorkHours: Int, partWorkHours: Int): Int = {
    val totalsHours = 0.max(partWorkHours)

    val resultHours = fullWorkHours.min(totalsHours)

    return resultHours
  }
  private def decPaymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal = {
    val coeffAmount = factorizeValue(amountMonthly, monthlyCoeff)

    val payment = decPaymentWithMonthlyAndFullAndWorkHours(coeffAmount, fullWorkHours, partWorkHours)

    return payment
  }
  private def decPaymentWithMonthlyAndFullAndWorkHours(amountMonthly: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal = {
    val paymWorkHours = totalHoursWithFullAndPartHours(fullWorkHours, partWorkHours)

    val payment = OperationsDec.multiplyAndDivide(amountMonthly, paymWorkHours, fullWorkHours)

    return payment
  }
  private def decPaymentWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal = {
    val totalHours = BigDecimal.valueOf(0).max(workingsHours)

    val payment = OperationsDec.multiply(totalHours, tariffHourly)

    return payment
  }
  private def decTariffWithPaymentAndHours(amountHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal = {
    val totalHours = BigDecimal.valueOf(0).max(workingsHours)

    val tariff = OperationsDec.divide(amountHourly, totalHours)

    return tariff
  }
  private def decPaymentWithAmountFixed(amountFixed: BigDecimal): BigDecimal = {
    val payment = amountFixed

    return payment
  }

  override def coeffWithPartAndFullHours(fullWorkHours: BigDecimal, partWorkHours: BigDecimal): BigDecimal = {
    val coeffWorking = BigDecimal.valueOf(1).min(OperationsDec.divide(partWorkHours, fullWorkHours))

    return coeffWorking
  }

  override def relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val amountCoeffs = factorizeValue(amountMonthly, monthlyCoeff)

    val relativeAmount = factorizeValue(amountCoeffs, workingCoeff)

    return relativeAmount
  }

  override def reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val amountCoeffs = reverzedFactorizeValue(amountMonthly, monthlyCoeff)

    val reverzedAmount = reverzedFactorizeValue(amountCoeffs, workingCoeff)

    return reverzedAmount
  }

  override def relativeTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val paymentValue = relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

    return OperationsRound.decRoundNorm01(paymentValue)
  }

  override def reverzedTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val paymentValue = reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

    return OperationsRound.decRoundNorm01(paymentValue)
  }

  override def relativePaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val paymentValue = relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

    return OperationsRound.decRoundNorm(paymentValue)
  }

  override def reverzedPaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val paymentValue = reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

    return OperationsRound.decRoundNorm(paymentValue)
  }


  override def paymentWithAmountFixed(amountFixed: BigDecimal): BigDecimal = {
    val paymentValue = decPaymentWithAmountFixed(amountFixed)

    return OperationsRound.decRoundNorm(paymentValue)
  }
  override def paymentRoundUpWithAmountFixed(amountFixed: BigDecimal): BigDecimal = {
    val paymentValue = decPaymentWithAmountFixed(amountFixed)

    return OperationsRound.decRoundUp(paymentValue)
  }
  override def paymentWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal = {
    val paymentValue = decPaymentWithTariffAndHours(tariffHourly, workingsHours)

    return OperationsRound.decRoundNorm(paymentValue)
  }
  override def paymentRoundUpWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal = {
    val paymentValue = decPaymentWithTariffAndHours(tariffHourly, workingsHours)

    return OperationsRound.decRoundUp(paymentValue)
  }
  override def tariffWithPaymentAndHours(amountHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal = {
    val tariffValue = decTariffWithPaymentAndHours(amountHourly, workingsHours)

    return moneyToRoundNorm(tariffValue)
  }

  override def paymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal = {
    val amountCoeffs = factorizeValue(amountMonthly, monthlyCoeff)

    val paymentValue = decPaymentWithMonthlyAndFullAndWorkHours(amountCoeffs, fullWorkHours, partWorkHours)

    return OperationsRound.decRoundNorm(paymentValue)
  }
  override def paymentRoundUpWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal = {
    val amountCoeffs = factorizeValue(amountMonthly, monthlyCoeff)

    val paymentValue = decPaymentWithMonthlyAndFullAndWorkHours(amountCoeffs, fullWorkHours, partWorkHours)

    return OperationsRound.decRoundUp(paymentValue)
  }
  override def paymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val amountFactor = factorizeValue(amountMonthly, monthlyCoeff)

    val paymentValue = factorizeValue(amountFactor, workingCoeff)

    return OperationsRound.decRoundNorm(paymentValue)
  }
  override def paymentRoundUpWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal = {
    val amountFactor = factorizeValue(amountMonthly, monthlyCoeff)

    val paymentValue = factorizeValue(amountFactor, workingCoeff)

    return OperationsRound.decRoundUp(paymentValue)
  }
  override def paymentWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
    fullWeekHours: Int, partWeekHours: Int,
    fullWorkHours: Int, partWorkHours: Int): BigDecimal = {
    val coeffSalary = coeffWithPartAndFullHours(partWeekHours, fullWeekHours)

    val salaryValue = paymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly, coeffSalary, fullWorkHours, partWorkHours)

    return salaryValue
  }
  override def paymentRoundUpWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
    fullWeekHours: Int, partWeekHours: Int,
    fullWorkHours: Int, partWorkHours: Int): BigDecimal = {
    val coeffSalary = coeffWithPartAndFullHours(partWeekHours, fullWeekHours)

    val salaryValue = paymentRoundUpWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly, coeffSalary, fullWorkHours, partWorkHours)

    return salaryValue
  }
  override def hoursToHalfHoursUp(hoursValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundUp50(hoursValue)
  }
  override def hoursToQuartHoursUp(hoursValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundUp25(hoursValue)
  }
  override def hoursToHalfHoursDown(hoursValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundDown50(hoursValue)
  }
  override def hoursToQuartHoursDown(hoursValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundDown25(hoursValue)
  }
  override def hoursToHalfHoursNorm(hoursValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundNorm50(hoursValue)
  }
  override def hoursToQuartHoursNorm(hoursValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundNorm25(hoursValue)
  }
  override def moneyToRoundDown(moneyValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundDown01(moneyValue)
  }
  override def moneyToRoundUp(moneyValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundUp01(moneyValue)
  }
  override def moneyToRoundNorm(moneyValue: BigDecimal): BigDecimal = {
    return OperationsRound.decRoundNorm01(moneyValue)
  }

  def factorizeValue(baseValue: BigDecimal, factor: BigDecimal): BigDecimal = {
    val result = OperationsDec.multiply(baseValue, factor)

    return result
  }
  def reverzedFactorizeValue(baseValue: BigDecimal, factor: BigDecimal): BigDecimal = {
    val result = OperationsDec.multiply(baseValue, OperationsDec.divide(BigDecimal.valueOf(1), factor))

    return result
  }

  override def valueEquals(other: Option[IPropsSalary]): Boolean = {
    return other match {
      case Some(otherVal) =>
        (this.workingShiftWeek == otherVal.workingShiftWeek &&
          this.workingShiftTime == otherVal.workingShiftTime &&
          this.minMonthlyWage == otherVal.minMonthlyWage &&
          this.minHourlyWage == otherVal.minHourlyWage)
      case _ => false
    }
  }
}

object PropsSalary {
  def empty(): IPropsSalary = {
    return new PropsSalary(PropsBase.VERSION_ZERO)
  }
}
