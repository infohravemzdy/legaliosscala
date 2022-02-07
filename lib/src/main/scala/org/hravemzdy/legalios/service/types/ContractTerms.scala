package org.hravemzdy.legalios.service.types

object WorkContractTerms extends Enumeration {
  type WorkContractTerms = Value
  val WORKTERM_EMPLOYMENT_1 = Value(0)
  val WORKTERM_CONTRACTER_A = Value(1)
  val WORKTERM_CONTRACTER_T = Value(2)
  val WORKTERM_PARTNER_STAT = Value(3)
}

object WorkTaxingTerms extends Enumeration {
  type WorkTaxingTerms = Value
  val TAXING_TERM_BY_CONTRACT = Value(0)
  val TAXING_TERM_EMPLOYMENTS = Value(1)
  val TAXING_TERM_AGREEM_TASK = Value(2)
  val TAXING_TERM_STATUT_PART = Value(3)
}

object WorkHealthTerms extends Enumeration {
  type WorkHealthTerms = Value
  val HEALTH_TERM_BY_CONTRACT = Value(0)
  val HEALTH_TERM_EMPLOYMENTS = Value(1)
  val HEALTH_TERM_AGREEM_WORK = Value(2)
  val HEALTH_TERM_AGREEM_TASK = Value(3)
}

object WorkSocialTerms extends Enumeration {
  type WorkSocialTerms = Value
  val SOCIAL_TERM_BY_CONTRACT  = Value(0)
  val SOCIAL_TERM_EMPLOYMENTS  = Value(1)
  val SOCIAL_TERM_SMALLS_EMPL  = Value(2)
  val SOCIAL_TERM_SHORTS_MEET  = Value(3)
  val SOCIAL_TERM_SHORTS_DENY  = Value(4)
  val SOCIAL_TERM_AGREEM_TASK  = Value(5)
}

