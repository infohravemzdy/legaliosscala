package org.hravemzdy.legalios.service.types

import scala.math.BigDecimal.RoundingMode

object OperationsRound {
  private val INT_ROUNDING_CONST = BigDecimal("0.5")

  def roundToInt(valueDec: BigDecimal): Int = {
    val roundRet = (valueDec.abs + INT_ROUNDING_CONST).setScale(0, RoundingMode.FLOOR)

    if (valueDec < BigDecimal.valueOf(0)) {
      return (-roundRet).toInt
    }
    return roundRet.toInt
  }
  def roundUp(valueDec: BigDecimal): Int = {
    val roundRet = valueDec.abs.setScale(0, RoundingMode.CEILING)

    if (valueDec < BigDecimal.valueOf(0)) {
      return (-roundRet).toInt
    }
    return roundRet.toInt
  }

  def roundDown(valueDec: BigDecimal): Int = {
    val roundRet = valueDec.abs.setScale(0, RoundingMode.FLOOR)

    if (valueDec < BigDecimal.valueOf(0)) {
      return (-roundRet).toInt
    }
    return roundRet.toInt
  }
  def roundNorm(valueDec: BigDecimal): Int = {
    val roundRet = (valueDec.abs + INT_ROUNDING_CONST).setScale(0, RoundingMode.DOWN)

    if (valueDec < BigDecimal.valueOf(0)) {
      return (-roundRet).toInt
    }
    return roundRet.toInt
  }

  def nearRoundUp(valueDec: BigDecimal, nearest: Int = 100): Int = {
    val nearestBig = BigDecimal.valueOf(nearest)
    val dividRet = OperationsDec.divide(valueDec, nearestBig)

    val multiRet = OperationsDec.multiply(decRoundUp(dividRet), nearestBig)

    return roundToInt(multiRet)
  }

  def nearRoundDown(valueDec: BigDecimal, nearest: Int = 100): Int = {
    val nearestBig = BigDecimal.valueOf(nearest)
    val dividRet = OperationsDec.divide(valueDec, nearestBig)

    val multiRet = OperationsDec.multiply(decRoundDown(dividRet), nearestBig)

    return roundToInt(multiRet)
  }
  def roundUp50(valueDec: BigDecimal): Int = {
    val divider = BigDecimal.valueOf(2)
    val dividRet = OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
    return roundToInt(dividRet)
  }
  def roundUp25(valueDec: BigDecimal): Int = {
    val divider = BigDecimal.valueOf(4)
    val dividRet = OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
    return roundToInt(dividRet)
  }

  def decRoundUp(valueDec: BigDecimal): BigDecimal = {
    val roundRet = valueDec.abs.setScale(0, RoundingMode.CEILING)

    if (valueDec < BigDecimal.valueOf(0)) {
      return -roundRet
    }
    return roundRet
  }

  def decRoundDown(valueDec: BigDecimal): BigDecimal = {
    val roundRet = valueDec.abs.setScale(0, RoundingMode.FLOOR)

    if (valueDec < BigDecimal.valueOf(0)) {
      return -roundRet
    }
    return roundRet
  }
  def decRoundNorm(valueDec: BigDecimal): BigDecimal = {
    val roundRet = (valueDec.abs + INT_ROUNDING_CONST).setScale(0, RoundingMode.DOWN)

    if (valueDec < BigDecimal.valueOf(0)) {
      return -roundRet
    }
    return roundRet
  }

  def decNearRoundUp(valueDec: BigDecimal, nearest: Int = 100): BigDecimal = {
    val nearestBig = BigDecimal.valueOf(nearest)
    val dividRet = OperationsDec.divide(valueDec, nearestBig)

    val multiRet = OperationsDec.multiply(decRoundUp(dividRet), nearestBig)

    return multiRet
  }

  def decNearRoundDown(valueDec: BigDecimal, nearest: Int = 100): BigDecimal = {
    val nearestBig = BigDecimal.valueOf(nearest)
    val dividRet = OperationsDec.divide(valueDec, nearestBig)

    val multiRet = OperationsDec.multiply(decRoundDown(dividRet), nearestBig)

    return multiRet
  }
  def decRoundUp50(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(2)
    return OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundUp25(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(4)
    return OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundUp01(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(100)
    return OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundDown50(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(2)
    return OperationsDec.divide(decRoundDown(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundDown25(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(4)
    return OperationsDec.divide(decRoundDown(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundDown01(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(100)
    return OperationsDec.divide(decRoundDown(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundNorm50(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(2)
    return OperationsDec.divide(decRoundNorm(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundNorm25(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(4)
    return OperationsDec.divide(decRoundNorm(OperationsDec.multiply(valueDec, divider)), divider)
  }
  def decRoundNorm01(valueDec: BigDecimal): BigDecimal = {
    val divider = BigDecimal.valueOf(100)
    return OperationsDec.divide(decRoundNorm(OperationsDec.multiply(valueDec, divider)), divider)
  }
}
