package org.hravemzdy.legalios.service.types

import org.hravemzdy.legalios.interfaces.IPeriod

case class Period(override val code: Int) extends IPeriod {
  override val year: Int  = (code / 100)
  override val month: Int = (code % 100)

  def this(year: Int, month: Int) = {
    this(year * 100 + month)
  }
}

object Period {
  val ZeroCode: Int = 0
  val zero: Period = getNew()

  def getNew(): Period = Period(Period.ZeroCode)
  def get(code: Int): Period = Period(code)
  def getWithYearMonth(year: Int, month: Int): Period = new Period(year, month)
}