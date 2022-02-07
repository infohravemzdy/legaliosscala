package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.TaxDeclBenfOption.TaxDeclBenfOption
import org.hravemzdy.legalios.service.types.TaxDeclDisabOption.TaxDeclDisabOption
import org.hravemzdy.legalios.service.types.TaxDeclSignOption.TaxDeclSignOption
import org.hravemzdy.legalios.service.types.TaxNoneSignOption.TaxNoneSignOption
import org.hravemzdy.legalios.service.types.WorkTaxingTerms.WorkTaxingTerms
import org.hravemzdy.legalios.service.types.{OperationsDec, OperationsRound, TaxDeclBenfOption, TaxDeclDisabOption, TaxDeclSignOption, VersionId}

abstract class PropsTaxingBase(version: VersionId,
                           override val allowancePayer: Int,
                           override val allowanceDisab1st: Int,
                           override val allowanceDisab2nd: Int,
                           override val allowanceDisab3rd: Int,
                           override val allowanceStudy: Int,
                           override val allowanceChild1st: Int,
                           override val allowanceChild2nd: Int,
                           override val allowanceChild3rd: Int,
                           override val factorAdvances: BigDecimal,
                           override val factorWithhold: BigDecimal,
                           override val factorSolidary: BigDecimal,
                           override val factorTaxRate2: BigDecimal,
                           override val minAmountOfTaxBonus: Int,
                           override val maxAmountOfTaxBonus: Int,
                           override val marginIncomeOfTaxBonus: Int,
                           override val marginIncomeOfRounding: Int,
                           override val marginIncomeOfWithhold: Int,
                           override val marginIncomeOfSolidary: Int,
                           override val marginIncomeOfTaxRate2: Int,
                           override val marginIncomeOfWthEmp: Int,
                           override val marginIncomeOfWthAgr: Int) extends PropsBase(version) with IPropsTaxing{

  def this(version: Int) = {
    this(VersionId.get(version),
      0,0,0,0,0,0,0,0,
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      0,0,0,0,0,0,0,0,0)
  }
  override def valueEquals(other: Option[IPropsTaxing]): Boolean = {
    return other match {
      case Some(otherVal) =>
        (this.allowancePayer == otherVal.allowancePayer &&
          this.allowanceDisab1st == otherVal.allowanceDisab1st &&
          this.allowanceDisab2nd == otherVal.allowanceDisab2nd &&
          this.allowanceDisab3rd == otherVal.allowanceDisab3rd &&
          this.allowanceStudy == otherVal.allowanceStudy &&
          this.allowanceChild1st == otherVal.allowanceChild1st &&
          this.allowanceChild2nd == otherVal.allowanceChild2nd &&
          this.allowanceChild3rd == otherVal.allowanceChild3rd &&
          this.factorAdvances == otherVal.factorAdvances &&
          this.factorWithhold == otherVal.factorWithhold &&
          this.factorSolidary == otherVal.factorSolidary &&
          this.factorTaxRate2 == otherVal.factorTaxRate2 &&
          this.minAmountOfTaxBonus == otherVal.minAmountOfTaxBonus &&
          this.maxAmountOfTaxBonus == otherVal.maxAmountOfTaxBonus &&
          this.marginIncomeOfTaxBonus == otherVal.marginIncomeOfTaxBonus &&
          this.marginIncomeOfRounding == otherVal.marginIncomeOfRounding &&
          this.marginIncomeOfWithhold == otherVal.marginIncomeOfWithhold &&
          this.marginIncomeOfSolidary == otherVal.marginIncomeOfSolidary &&
          this.marginIncomeOfTaxRate2 == otherVal.marginIncomeOfTaxRate2 &&
          this.marginIncomeOfWthEmp == otherVal.marginIncomeOfWthEmp &&
          this.marginIncomeOfWthAgr == otherVal.marginIncomeOfWthAgr)
      case _ => false
    }
  }

  def intTaxRoundUp(valueDec: BigDecimal): Int = {
    return OperationsRound.roundUp(valueDec)
  }
  def intTaxRoundNearUp(valueDec: BigDecimal, nearest: Int = 100): Int  = {
    return OperationsRound.nearRoundUp(valueDec, nearest)
  }
  def intTaxRoundDown(valueDec: BigDecimal): Int = {
    return OperationsRound.roundDown(valueDec)
  }
  def intTaxRoundNearDown(valueDec: BigDecimal, nearest: Int = 100): Int  = {
    return OperationsRound.nearRoundDown(valueDec, nearest)
  }

  def decTaxRoundUp(valueDec: BigDecimal): BigDecimal  = {
    return OperationsRound.decRoundUp(valueDec)
  }

  def decTaxRoundNearUp(valueDec: BigDecimal, nearest: Int = 100): BigDecimal  = {
    return OperationsRound.decNearRoundUp(valueDec, nearest)
  }
  def decTaxRoundDown(valueDec: BigDecimal): BigDecimal  = {
    return OperationsRound.decRoundDown(valueDec)
  }
  def decTaxRoundNearDown(valueDec: BigDecimal, nearest: Int = 100): BigDecimal  = {
    return OperationsRound.decNearRoundDown(valueDec, nearest)
  }

  override def hasWithholdIncome(termOpt: WorkTaxingTerms, signOpt: TaxDeclSignOption, noneOpt: TaxNoneSignOption, incomeSum: Int): Boolean

  override def benefitAllowancePayer(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int = {
    var benefitValue: Int = 0
    if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
    {
      if (benefitOpts == TaxDeclBenfOption.DECL_TAX_BENEF1)
      {
        benefitValue = allowancePayer
      }
    }
    return benefitValue
  }
  override def benefitAllowanceDisab(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclDisabOption): Int = {
    var benefitValue: Int = 0
    if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
    {
      benefitValue = benefitOpts match {
        case TaxDeclDisabOption.DECL_TAX_DISAB1 => allowanceDisab1st
        case TaxDeclDisabOption.DECL_TAX_DISAB2 => allowanceDisab2nd
        case TaxDeclDisabOption.DECL_TAX_DISAB3 => allowanceDisab3rd
        case _ => 0
      }
    }
    return benefitValue
  }
  override def benefitAllowanceStudy(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int = {
    var benefitValue: Int = 0

    if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
    {
      if (benefitOpts == TaxDeclBenfOption.DECL_TAX_BENEF1)
      {
        benefitValue = allowanceStudy
      }
    }
    return benefitValue
  }
  override def benefitAllowanceChild(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption, benefitOrds: Int, disabelOpts: Int): Int = {
    var benefitValue: Int = 0
    if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
    {
      val benefitUnits: Int = benefitOrds match {
        case 0 => allowanceChild1st
        case 1 => allowanceChild2nd
        case 2 => allowanceChild3rd
        case _ => 0
      }
      if (benefitOpts == TaxDeclBenfOption.DECL_TAX_BENEF1)
      {
        if (disabelOpts == 1)
        {
          benefitValue = benefitUnits * 2
        }
        else
        {
          benefitValue = benefitUnits
        }
      }
    }
    return benefitValue
  }
  override def bonusChildRaw(income: Int, benefit: Int, rebated: Int): Int = {
    var bonusForChild: BigDecimal = -0.min(rebated - benefit)

    if (marginIncomeOfTaxBonus > 0)
    {
      if (income < marginIncomeOfTaxBonus)
      {
        bonusForChild = BigDecimal.valueOf(0)
      }
    }
    return OperationsRound.roundToInt(bonusForChild)
  }
  override def bonusChildFix(income: Int, benefit: Int, rebated: Int): Int = {
    var childBonus = bonusChildRaw(income, benefit, rebated)

    if (minAmountOfTaxBonus > 0)
    {
      if (childBonus < minAmountOfTaxBonus)
      {
        return 0
      }
    }
    if (maxAmountOfTaxBonus > 0)
    {
      if (childBonus > maxAmountOfTaxBonus)
      {
        return maxAmountOfTaxBonus
      }
    }
    return childBonus
  }

  override def taxableIncomeSupers(incomeResult: Int, healthResult: Int, socialResult: Int): Int = {
    return taxableIncomeBasis(incomeResult + healthResult + socialResult)
  }

  override def taxableIncomeBasis(incomeResult: Int): Int = {
    val taxableSuper: Int = 0.max(incomeResult)
    return taxableSuper
  }

  override def roundedBaseAdvances(incomeResult: Int, healthResult: Int, socialResult: Int): Int = {
    val advanceBase = roundedBaseAdvances(incomeResult + healthResult + socialResult)

    return advanceBase
  }

  override def roundedBaseAdvances(incomeResult: Int): Int = {
    val amountForCalc: Int = taxableIncomeBasis(incomeResult)

    var advanceBase: Int = 0
    if (amountForCalc <= marginIncomeOfRounding)
  {
    advanceBase = intTaxRoundUp(BigDecimal.valueOf(amountForCalc))
  }
    else
  {
    advanceBase = intTaxRoundNearUp(BigDecimal.valueOf(amountForCalc), 100)
  }
    return advanceBase
  }

  override def roundedBaseSolidary(incomeResult: Int): Int = {
    var solidaryBase: Int = 0

    val taxableIncome: Int = 0.max(incomeResult)
    if (marginIncomeOfSolidary != 0)
    {
      solidaryBase = 0.max(taxableIncome - marginIncomeOfSolidary)
    }
    return solidaryBase
  }
  override def roundedAdvancesPaym(supersResult: Int, basisResult: Int): Int

  override def roundedSolidaryPaym(basisResult: Int): Int = {
    val factorSolidary = OperationsDec.divide(this.factorSolidary, BigDecimal.valueOf(100))

    var solidaryTaxing: Int = 0
    if (marginIncomeOfSolidary != 0)
    {
      solidaryTaxing = intTaxRoundUp(OperationsDec.multiply(BigDecimal.valueOf(basisResult), factorSolidary))
    }
    return solidaryTaxing
  }
  override def roundedBaseWithhold(incomeResult: Int): Int = {
    val amountForCalc: Int = 0.max(incomeResult)
    val withholdBase: Int = intTaxRoundDown(BigDecimal.valueOf(amountForCalc))

    return withholdBase
  }
  override def roundedWithholdPaym(supersResult: Int, basisResult: Int): Int = {
    val factorWithhold = OperationsDec.divide(this.factorWithhold, BigDecimal.valueOf(100))

    var withholdTaxing: Int = 0.max(supersResult)
    if (withholdTaxing > 0)
    {
      withholdTaxing = intTaxRoundDown(OperationsDec.multiply(BigDecimal.valueOf(supersResult), factorWithhold))
    }
    return withholdTaxing
  }
}
