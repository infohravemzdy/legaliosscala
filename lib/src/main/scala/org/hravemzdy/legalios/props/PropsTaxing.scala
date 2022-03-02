package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.TaxDeclSignOption.TaxDeclSignOption
import org.hravemzdy.legalios.service.types.TaxNoneSignOption.TaxNoneSignOption
import org.hravemzdy.legalios.service.types.{OperationsDec, TaxDeclSignOption, TaxNoneSignOption, VersionId, WorkTaxingTerms}
import org.hravemzdy.legalios.service.types.WorkTaxingTerms.WorkTaxingTerms

class PropsTaxing(version: VersionId,
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
    else if (termOpt == WorkTaxingTerms.TAXING_TERM_EMPLOYMENTS)
    {
      if (marginIncomeOfWthEmp == 0 || incomeSum <= marginIncomeOfWthEmp)
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
    val factorTaxRate2 = OperationsDec.divide(this.factorTaxRate2, BigDecimal.valueOf(100))

    var taxRate1Basis: Int = basisResult
    var taxRate2Basis: Int = 0
    if (marginIncomeOfTaxRate2 != 0)
    {
      taxRate1Basis = basisResult.min(marginIncomeOfTaxRate2)
      taxRate2Basis = 0.max(basisResult - marginIncomeOfTaxRate2)
    }
    var taxRate1Taxing: BigDecimal = BigDecimal.valueOf(0)
    if (basisResult <= marginIncomeOfRounding)
    {
      taxRate1Taxing = OperationsDec.multiply(BigDecimal.valueOf(taxRate1Basis), factorAdvances)
    }
    else
    {
      taxRate1Taxing = OperationsDec.multiply(BigDecimal.valueOf(taxRate1Basis), factorAdvances)
    }
    var taxRate2Taxing: BigDecimal = BigDecimal.valueOf(0)
    if (marginIncomeOfTaxRate2 != 0)
    {
      taxRate2Taxing = OperationsDec.multiply(BigDecimal.valueOf(taxRate2Basis), factorTaxRate2)
    }
    return intTaxRoundUp(taxRate1Taxing + taxRate2Taxing)
  }
}

object PropsTaxing {
  def empty(): IPropsTaxing = {
    return new PropsTaxing(PropsBase.VERSION_ZERO)
  }
}
