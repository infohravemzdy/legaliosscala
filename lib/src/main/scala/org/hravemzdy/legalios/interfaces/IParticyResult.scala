package org.hravemzdy.legalios.interfaces

trait IParticyResult {
  val particyCode: Int
  val resultBasis: Int
  val resultValue: Int
  def setResultValue(value: Int): Int

}
