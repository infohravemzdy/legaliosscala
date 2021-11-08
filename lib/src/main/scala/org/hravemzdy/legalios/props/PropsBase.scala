package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IProps
import org.hravemzdy.legalios.service.types.VersionId

class PropsBase(override val version: VersionId) extends IProps {
  def this(versionId: Int) = {
    this(VersionId.get(versionId))
  }

  def isValid(): Boolean = {
    return version.value != PropsBase.VERSION_ZERO
  }
}

object PropsBase {
  val VERSION_ZERO: Int = 0
}
