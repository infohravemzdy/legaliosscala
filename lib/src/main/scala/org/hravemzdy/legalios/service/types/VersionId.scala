package org.hravemzdy.legalios.service.types

import org.hravemzdy.legalios.interfaces.IVersionId

case class VersionId(override val value: Int) extends IVersionId[Int] {
}

object VersionId {
  val VERSION_ZERO: Int = 0

  def getNew(): VersionId = VersionId(VERSION_ZERO)
  def get(value: Int): VersionId = VersionId(value)
}