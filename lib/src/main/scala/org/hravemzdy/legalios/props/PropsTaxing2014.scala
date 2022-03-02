package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.TaxDeclSignOption.TaxDeclSignOption
import org.hravemzdy.legalios.service.types.TaxNoneSignOption.TaxNoneSignOption
import org.hravemzdy.legalios.service.types.{OperationsDec, TaxDeclSignOption, TaxNoneSignOption, VersionId, WorkTaxingTerms}
import org.hravemzdy.legalios.service.types.WorkTaxingTerms.WorkTaxingTerms

class PropsTaxing2014(version: VersionId,
                      _allowancePayer: Int,
                      _allowanceDisab1st: Int,
                      _allowanceDisab2nd: Int,
                      _allowanceDisab3rd: Int,
                      _allowanceStudy: Int,
                      _allowanceChild1st: Int,
                      _allowanceChild2nd: Int,
                      _allowanceChild3rd: Int,
                      _factorAdvances: BigDecimal,
                      _factorWithhold: BigDecimal,
                      _factorSolidary: BigDecimal,
                      _factorTaxRate2: BigDecimal,
                      _minAmountOfTaxBonus: Int,
                      _maxAmountOfTaxBonus: Int,
                      _marginIncomeOfTaxBonus: Int,
                      _marginIncomeOfRounding: Int,
                      _marginIncomeOfWithhold: Int,
                      _marginIncomeOfSolidary: Int,
                      _marginIncomeOfTaxRate2: Int,
                      _marginIncomeOfWthEmp: Int,
                      _marginIncomeOfWthAgr: Int)
  extends PropsTaxingBase(version,
    _allowancePayer,
    _allowanceDisab1st,
    _allowanceDisab2nd,
    _allowanceDisab3rd,
    _allowanceStudy,
    _allowanceChild1st,
    _allowanceChild2nd,
    _allowanceChild3rd,
    _factorAdvances,
    _factorWithhold,
    _factorSolidary,
    _factorTaxRate2,
    _minAmountOfTaxBonus,
    _maxAmountOfTaxBonus,
    _marginIncomeOfTaxBonus,
    _marginIncomeOfRounding,
    _marginIncomeOfWithhold,
    _marginIncomeOfSolidary,
    _marginIncomeOfTaxRate2,
    _marginIncomeOfWthEmp,
    _marginIncomeOfWthAgr) with IPropsTaxing{

  def this(version: Int) = {
    this(VersionId.get(version),
      0,0,0,0,0,0,0,0,
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      BigDecimal.valueOf(0),
      0,0,0,0,0,0,0,0,0)
  }
  override def hasWithholdIncome(termOpt: WorkTaxingTerms, signOpt: TaxDeclSignOption, noneOpt: TaxNoneSignOption, incomeSum: Int): Boolean = {
    //*****************************************************************************
    // Tax income for advance from Year 2008 to Year 2013
    //*****************************************************************************
    // - withhold tax (non-signed declaration) and income is less than X CZK
    //*****************************************************************************

    var withholdIncome: Boolean = false
    if (signOpt != TaxDeclSignOption.DECL_TAX_NO_SIGNED)
    {
      return false
    }
    if (noneOpt != TaxNoneSignOption.NOSIGN_TAX_WITHHOLD)
    {
      return false
    }
    if (termOpt == WorkTaxingTerms.TAXING_TERM_AGREEM_TASK)
    {
      if (marginIncomeOfWthAgr == 0 || incomeSum <= marginIncomeOfWthAgr)
      {
        if (incomeSum > 0)
        {
          withholdIncome = true
        }
      }
    }
    else if (termOpt == WorkTaxingTerms.TAXING_TERM_STATUT_PART)
    {
      if (incomeSum > 0)
      {
        withholdIncome = true
      }
    }
    return withholdIncome
  }
  override def roundedAdvancesPaym(supersResult: Int, basisResult: Int): Int = {
    val factorAdvances = OperationsDec.divide(this.factorAdvances, BigDecimal.valueOf(100))

    var advanceTaxing: Int = 0
    if (basisResult <= marginIncomeOfRounding)
    {
      advanceTaxing = intTaxRoundUp(OperationsDec.multiply(BigDecimal.valueOf(supersResult), factorAdvances))
    }
    else
    {
      advanceTaxing = intTaxRoundUp(OperationsDec.multiply(BigDecimal.valueOf(supersResult), factorAdvances))
    }
    return advanceTaxing
  }
}

object PropsTaxing2014 {
  def empty(): IPropsTaxing = {
    return new PropsTaxing2014(PropsBase.VERSION_ZERO)
  }
}
