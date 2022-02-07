package org.hravemzdy.legalios.service.types

object OperationsDec {
  def multiply(op1: BigDecimal, op2: BigDecimal): BigDecimal = {
    return op1.*(op2)
  }

  def divide(op1: BigDecimal, div: BigDecimal) : BigDecimal = {
    if (div == BigDecimal.valueOf(0))
  {
    return BigDecimal.valueOf(0)
  }
    return op1./(div)
  }

  def multiplyAndDivide(op1: BigDecimal, op2: BigDecimal, div: BigDecimal) : BigDecimal = {
    if (div == BigDecimal.valueOf(0))
  {
    return BigDecimal.valueOf(0)
  }
    val multiRet = op1.*(op2)

    val dividRet = multiRet./(div)

    return dividRet
  }

  def decimalCast(number: Int) : BigDecimal = {
    return BigDecimal(number)
  }

  def minIncMaxDecValue(valueToMinMax: BigDecimal, accValueToMax: BigDecimal, minLimitTo: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal = {
    val minBase = minIncValue(valueToMinMax, minLimitTo)

    val maxBase = maxDecAccumValue(minBase, accValueToMax, maxLimitTo)

    return maxBase
  }

  def maxDecAccumValue(valueToMax: BigDecimal, accumToMax: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal = {
    if (maxLimitTo > BigDecimal.valueOf(0))
  {
    val valueToReduce = valueToMax.+(accumToMax).max(maxLimitTo)

    return BigDecimal.valueOf(0).max(valueToReduce.-(accumToMax))
  }
    return valueToMax
  }

  def maxDecAccumAbove(valueToMax: BigDecimal, accumToMax: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal = {
    if (maxLimitTo > BigDecimal.valueOf(0))
  {
    val underToLimits = maxDecAccumValue(valueToMax, accumToMax, maxLimitTo)

    return BigDecimal.valueOf(0).max(valueToMax - underToLimits)
  }
    return BigDecimal.valueOf(0)
  }

  def minIncValue(valueToMin: BigDecimal, minLimitTo: BigDecimal) : BigDecimal = {
    if (minLimitTo > BigDecimal.valueOf(0))
  {
    if (minLimitTo > valueToMin)
  {
    return minLimitTo
  }
  }
    return valueToMin
  }

  def maxDecValue(valueToMax: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal = {
    if (maxLimitTo > BigDecimal.valueOf(0))
  {
    return valueToMax.min(maxLimitTo)
  }
    return valueToMax
  }

  def suppressNegative(suppress: Boolean, valueDec: BigDecimal) : BigDecimal = {
    if (suppress && valueDec < BigDecimal.valueOf(0))
  {
    return BigDecimal.valueOf(0)
  }
    return valueDec
  }
}