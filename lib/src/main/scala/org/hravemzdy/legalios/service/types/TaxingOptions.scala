package org.hravemzdy.legalios.service.types

object TaxDeclSignOption extends Enumeration {
  type TaxDeclSignOption = Value
  val DECL_TAX_NO_SIGNED = Value(0)
  val DECL_TAX_DO_SIGNED = Value(1)
}

object TaxNoneSignOption extends Enumeration {
  type TaxNoneSignOption = Value
  val NOSIGN_TAX_WITHHOLD = Value(0)
  val NOSIGN_TAX_ADVANCES = Value(1)
}

object TaxDeclBenfOption extends Enumeration {
  type TaxDeclBenfOption = Value
  val DECL_TAX_BENEF0 = Value(0)
  val DECL_TAX_BENEF1 = Value(1)
}

object TaxDeclDisabOption extends Enumeration {
  type TaxDeclDisabOption = Value
  val DECL_TAX_BENEF0 = Value(0)
  val DECL_TAX_DISAB1 = Value(1)
  val DECL_TAX_DISAB2 = Value(2)
  val DECL_TAX_DISAB3 = Value(3)
}
