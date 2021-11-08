package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.{IPeriod, IProps}
import org.hravemzdy.legalios.providers.IPropsProvider

import org.reflections.Reflections
import java.lang.reflect.Modifier
import scala.reflect.ClassTag

abstract class ProviderFactory[FB <: IPropsProvider[FP], +FP <: IProps]() extends IProviderFactory[FP] {
  protected val defaultProvider: FB

  protected val emptyPeriodProps: FP

  protected val versions: Map[VERSION, FB]

  override def getProps(period: IPeriod): FP = {
    val maybeProvider: Option[FB] = getProvider(period, defaultProvider)

    return maybeProvider match {
      case Some(provider) => provider.getProps(period)
      case None => emptyPeriodProps
    }
  }

  private def getProvider(period: IPeriod, defProvider: FB): Option[FB] = {
    val maybeProvider: Option[FB] = versions.get(period.year)
    return maybeProvider match {
      case Some(provider) => {
        if (period.year != provider.version.value) {
          return None
        }
        return Some(provider)
      }
      case None => {
        if (period.year > defProvider.version.value) {
          return Some(defProvider)
        }
        return None
      }
    }
  }
}

object ProviderFactory {
  type VERSION = Int

  def buildVersions[B <: IPropsProvider[P], P <: IProps]()(implicit tag: ClassTag[B]): Map[VERSION, B] = {
    val providerType: Class[B] = tag.runtimeClass.asInstanceOf[Class[B]]

    val reflections = new Reflections("org.hravemzdy.legalios.providers")

    val definedTags = reflections.getSubTypesOf(providerType)
      .toArray.map(x => ClassTag(x.asInstanceOf[Class[_]]))

    definedTags.filter(x => isValidType[B,P](x) && hasValidConstructor[B,P](x))
      .map(x => x.runtimeClass.getDeclaredConstructor().newInstance().asInstanceOf[B])
      .map(p => (p.version.value, p)).toMap
  }

  def isValidType[B <: IPropsProvider[P], P <: IProps](classTag: ClassTag[_])(implicit ct: ClassTag[B]): Boolean = {
    val assignable = ct.runtimeClass.isAssignableFrom(classTag.runtimeClass)
    val nonInterface = classTag.runtimeClass.isInterface == false && Modifier.isAbstract(classTag.runtimeClass.getModifiers())==false
    (assignable && nonInterface)
  }
  def hasValidConstructor[B <: IPropsProvider[P], P <: IProps](classTag: ClassTag[_]): Boolean = {
    val parameterlessConstructor = classTag.runtimeClass.getConstructors()
      .find(constructor =>  constructor.getParameterCount() == 0)
    parameterlessConstructor != null
  }
}