package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.{IParticyResult, IProps}
import org.hravemzdy.legalios.service.types.VersionId

class PropsBase(override val version: VersionId) extends IProps {
  def this(versionId: Int) = {
    this(VersionId.get(versionId))
  }

  def isValid(): Boolean = {
    return version.value != PropsBase.VERSION_ZERO
  }

  def maximResultCut[T <: IParticyResult](particyList: Iterable[T], incomeList: Iterable[T], annuityBasis: Int, annualyMaxim: Int): (Int, Int, Iterable[T]) = {
    val annualsBasis = 0.max(annualyMaxim - annuityBasis)
    var resultInit = (annualyMaxim, annualsBasis, particyList)

    var resultList = incomeList.foldLeft(resultInit) ((agr, x) => {
      var cutAnnualsBasis: Int = 0
      val rawAnnualsBasis: Int = x.resultBasis
      var remAnnualsBasis: Int = agr._2

      if (x.particyCode != 0) {
        cutAnnualsBasis = rawAnnualsBasis
        if (agr._1 > 0)
        {
          val ovrAnnualsBasis = 0.max(rawAnnualsBasis - agr._2)
          cutAnnualsBasis = (rawAnnualsBasis - ovrAnnualsBasis)
        }
        remAnnualsBasis = 0.max(agr._2 - cutAnnualsBasis)
      }

      x.setResultValue(0.max(cutAnnualsBasis))
      return (agr._1, remAnnualsBasis, agr._3 ++ Seq(x))
    })

    return resultList
  }
}

object PropsBase {
  val VERSION_ZERO: Int = 0
}
