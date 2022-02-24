package org.hravemzdy.legalios.history

import org.hravemzdy.legalios.factories.{FactoryHealth, FactorySalary, FactorySocial, FactoryTaxing, IProviderFactory}
import org.hravemzdy.legalios.interfaces.{IPropsHealth, IPropsSalary, IPropsSocial, IPropsTaxing}
import org.hravemzdy.legalios.service.ServiceExampleBase.__test_examples_file__
import org.hravemzdy.legalios.service.types.Period
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import java.io.{File, FileWriter}
import java.nio.file.Paths
import scala.collection.mutable.ListBuffer

@RunWith(classOf[JUnitRunner])
class FactoriesHistoryTest extends AnyFunSpec {
  val HISTORY_TEST_FOLDER = "../../../test_history"
  val HISTORY_FOLDER_NAME = "test_history"
  val PARENT_HISTORY_FOLDER_NAME = "legalios"

  case class TestYearsScenario(minYear: Int, maxYear: Int)

  val _sutSalary : IProviderFactory[IPropsSalary] = new FactorySalary()
  val _sutHealth : IProviderFactory[IPropsHealth] = new FactoryHealth()
  val _sutSocial : IProviderFactory[IPropsSocial] = new FactorySocial()
  val _sutTaxing : IProviderFactory[IPropsTaxing] = new FactoryTaxing()

  describe("GetProps_ShouldExport_History") {
    List(
      TestYearsScenario(2010, 2022),
    ).foreach { tt =>
      it("GetProps should export values") {
        if (__test_examples_file__) {
          var testProtokol = createHistoryFile("history_${tt.minYear}_${tt.maxYear}.xls")

          try {
            var headerData: List[(Int, Boolean)] = List[(Int, Boolean)]()
            for (testYear <- tt.minYear to tt.maxYear) {
              var yearWithChanges = false

              val testPeriod = Period.getWithYearMonth(testYear, 1)

              var testSalaryProp = _sutSalary.getProps(testPeriod)
              var testHealthProp = _sutHealth.getProps(testPeriod)
              var testSocialProp = _sutSocial.getProps(testPeriod)
              var testTaxingProp = _sutTaxing.getProps(testPeriod)

              for (testMonth <- 2 to 12) {
                val nextPeriod = Period.getWithYearMonth(testYear, testMonth)

                val testSalaryNext = _sutSalary.getProps(nextPeriod)
                val testHealthNext = _sutHealth.getProps(nextPeriod)
                val testSocialNext = _sutSocial.getProps(nextPeriod)
                val testTaxingNext = _sutTaxing.getProps(nextPeriod)

                if (testSalaryNext.valueEquals(Some(testSalaryProp)) == false)
                {
                  yearWithChanges = true
                }
                if (testHealthNext.valueEquals(Some(testHealthProp)) == false)
                {
                  yearWithChanges = true
                }
                if (testSocialNext.valueEquals(Some(testSocialProp)) == false)
                {
                  yearWithChanges = true
                }
                if (testTaxingNext.valueEquals(Some(testTaxingProp)) == false)
                {
                  yearWithChanges = true
                }
                testSalaryProp = testSalaryNext
                testHealthProp = testHealthNext
                testSocialProp = testSocialNext
                testTaxingProp = testTaxingNext
              }
              headerData = headerData :+ (testYear, yearWithChanges)
            }
            exportHistoryStart(testProtokol, headerData)

            val VECT_HEALTH_MIN_MONTHLY_BASIS = ListBuffer[(Int, Int, String, String)]()
            val VECT_HEALTH_MAX_ANNUALS_BASIS = ListBuffer[(Int, Int, String, String)]()
            val VECT_HEALTH_LIM_MONTHLY_STATE = ListBuffer[(Int, Int, String, String)]()
            val VECT_HEALTH_LIM_MONTHLY_DIS50 = ListBuffer[(Int, Int, String, String)]()
            val VECT_HEALTH_FACTOR_COMPOUND = ListBuffer[(Int, Int, String, String)]()
            val VECT_HEALTH_FACTOR_EMPLOYEE = ListBuffer[(Int, Int, String, String)]()
            val VECT_HEALTH_MARGIN_INCOME_EMP = ListBuffer[(Int, Int, String, String)]()
            val VECT_HEALTH_MARGIN_INCOME_AGR = ListBuffer[(Int, Int, String, String)]()
            val VECT_SALARY_WORKING_SHIFT_WEEK = ListBuffer[(Int, Int, String, String)]()
            val VECT_SALARY_WORKING_SHIFT_TIME = ListBuffer[(Int, Int, String, String)]()
            val VECT_SALARY_MIN_MONTHLY_WAGE = ListBuffer[(Int, Int, String, String)]()
            val VECT_SALARY_MIN_HOURLY_WAGE = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_MAX_ANNUALS_BASIS = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_FACTOR_EMPLOYER = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_FACTOR_EMPLOYER_HIGHER = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_FACTOR_EMPLOYEE = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_FACTOR_EMPLOYEE_GARANT = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_FACTOR_EMPLOYEE_REDUCE = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_MARGIN_INCOME_EMP = ListBuffer[(Int, Int, String, String)]()
            val VECT_SOCIAL_MARGIN_INCOME_AGR = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_PAYER = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_DISAB_1ST = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_DISAB_2ND = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_DISAB_3RD = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_STUDY = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_CHILD_1ST = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_CHILD_2ND = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_ALLOWANCE_CHILD_3RD = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_FACTOR_ADVANCES = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_FACTOR_WITHHOLD = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_FACTOR_SOLIDARY = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_FACTOR_TAXRATE2 = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MIN_AMOUNT_OF_TAXBONUS = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MAX_AMOUNT_OF_TAXBONUS = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MARGIN_INCOME_OF_TAXBONUS = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MARGIN_INCOME_OF_ROUNDING = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MARGIN_INCOME_OF_WITHHOLD = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MARGIN_INCOME_OF_SOLIDARY = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MARGIN_INCOME_OF_TAXRATE2 = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MARGIN_INCOME_OF_WHT_EMP = ListBuffer[(Int, Int, String, String)]()
            val VECT_TAXING_MARGIN_INCOME_OF_WHT_AGR = ListBuffer[(Int, Int, String, String)]()

            for (testYear <- tt.minYear to tt.maxYear) {
              var MES_HEALTH_MIN_MONTHLY_BASIS         = 0
              var MES_HEALTH_MAX_ANNUALS_BASIS         = 0
              var MES_HEALTH_LIM_MONTHLY_STATE         = 0
              var MES_HEALTH_LIM_MONTHLY_DIS50         = 0
              var MES_HEALTH_FACTOR_COMPOUND           = 0
              var MES_HEALTH_FACTOR_EMPLOYEE           = 0
              var MES_HEALTH_MARGIN_INCOME_EMP         = 0
              var MES_HEALTH_MARGIN_INCOME_AGR         = 0
              var MES_SALARY_WORKING_SHIFT_WEEK        = 0
              var MES_SALARY_WORKING_SHIFT_TIME        = 0
              var MES_SALARY_MIN_MONTHLY_WAGE          = 0
              var MES_SALARY_MIN_HOURLY_WAGE           = 0
              var MES_SOCIAL_MAX_ANNUALS_BASIS         = 0
              var MES_SOCIAL_FACTOR_EMPLOYER           = 0
              var MES_SOCIAL_FACTOR_EMPLOYER_HIGHER    = 0
              var MES_SOCIAL_FACTOR_EMPLOYEE           = 0
              var MES_SOCIAL_FACTOR_EMPLOYEE_GARANT    = 0
              var MES_SOCIAL_FACTOR_EMPLOYEE_REDUCE    = 0
              var MES_SOCIAL_MARGIN_INCOME_EMP         = 0
              var MES_SOCIAL_MARGIN_INCOME_AGR         = 0
              var MES_TAXING_ALLOWANCE_PAYER           = 0
              var MES_TAXING_ALLOWANCE_DISAB_1ST       = 0
              var MES_TAXING_ALLOWANCE_DISAB_2ND       = 0
              var MES_TAXING_ALLOWANCE_DISAB_3RD       = 0
              var MES_TAXING_ALLOWANCE_STUDY           = 0
              var MES_TAXING_ALLOWANCE_CHILD_1ST       = 0
              var MES_TAXING_ALLOWANCE_CHILD_2ND       = 0
              var MES_TAXING_ALLOWANCE_CHILD_3RD       = 0
              var MES_TAXING_FACTOR_ADVANCES           = 0
              var MES_TAXING_FACTOR_WITHHOLD           = 0
              var MES_TAXING_FACTOR_SOLIDARY           = 0
              var MES_TAXING_FACTOR_TAXRATE2           = 0
              var MES_TAXING_MIN_AMOUNT_OF_TAXBONUS    = 0
              var MES_TAXING_MAX_AMOUNT_OF_TAXBONUS    = 0
              var MES_TAXING_MARGIN_INCOME_OF_TAXBONUS = 0
              var MES_TAXING_MARGIN_INCOME_OF_ROUNDING = 0
              var MES_TAXING_MARGIN_INCOME_OF_WITHHOLD = 0
              var MES_TAXING_MARGIN_INCOME_OF_SOLIDARY = 0
              var MES_TAXING_MARGIN_INCOME_OF_TAXRATE2 = 0
              var MES_TAXING_MARGIN_INCOME_OF_WHT_EMP  = 0
              var MES_TAXING_MARGIN_INCOME_OF_WHT_AGR  = 0

              val testPeriod = Period.getWithYearMonth(testYear, 1)

              var testSalaryProp = _sutSalary.getProps(testPeriod)
              var testHealthProp = _sutHealth.getProps(testPeriod)
              var testSocialProp = _sutSocial.getProps(testPeriod)
              var testTaxingProp = _sutTaxing.getProps(testPeriod)

              val JAN_HEALTH_MIN_MONTHLY_BASIS         = propsValueToString(testHealthProp.minMonthlyBasis)
              val JAN_HEALTH_MAX_ANNUALS_BASIS         = propsValueToString(testHealthProp.maxAnnualsBasis)
              val JAN_HEALTH_LIM_MONTHLY_STATE         = propsValueToString(testHealthProp.limMonthlyState)
              val JAN_HEALTH_LIM_MONTHLY_DIS50         = propsValueToString(testHealthProp.limMonthlyDis50)
              val JAN_HEALTH_FACTOR_COMPOUND           = propsValueToString(testHealthProp.factorCompound )
              val JAN_HEALTH_FACTOR_EMPLOYEE           = propsValueToString(testHealthProp.factorEmployee )
              val JAN_HEALTH_MARGIN_INCOME_EMP         = propsValueToString(testHealthProp.marginIncomeEmp)
              val JAN_HEALTH_MARGIN_INCOME_AGR         = propsValueToString(testHealthProp.marginIncomeAgr)
              val JAN_SALARY_WORKING_SHIFT_WEEK        = propsValueToString(testSalaryProp.workingShiftWeek)
              val JAN_SALARY_WORKING_SHIFT_TIME        = propsValueToString(testSalaryProp.workingShiftTime)
              val JAN_SALARY_MIN_MONTHLY_WAGE          = propsValueToString(testSalaryProp.minMonthlyWage)
              val JAN_SALARY_MIN_HOURLY_WAGE           = propsValueToString(testSalaryProp.minHourlyWage  )
              val JAN_SOCIAL_MAX_ANNUALS_BASIS         = propsValueToString(testSocialProp.maxAnnualsBasis)
              val JAN_SOCIAL_FACTOR_EMPLOYER           = propsValueToString(testSocialProp.factorEmployer)
              val JAN_SOCIAL_FACTOR_EMPLOYER_HIGHER    = propsValueToString(testSocialProp.factorEmployerHigher)
              val JAN_SOCIAL_FACTOR_EMPLOYEE           = propsValueToString(testSocialProp.factorEmployee)
              val JAN_SOCIAL_FACTOR_EMPLOYEE_GARANT    = propsValueToString(testSocialProp.factorEmployeeGarant)
              val JAN_SOCIAL_FACTOR_EMPLOYEE_REDUCE    = propsValueToString(testSocialProp.factorEmployeeReduce)
              val JAN_SOCIAL_MARGIN_INCOME_EMP         = propsValueToString(testSocialProp.marginIncomeEmp)
              val JAN_SOCIAL_MARGIN_INCOME_AGR         = propsValueToString(testSocialProp.marginIncomeAgr)
              val JAN_TAXING_ALLOWANCE_PAYER           = propsValueToString(testTaxingProp.allowancePayer)
              val JAN_TAXING_ALLOWANCE_DISAB_1ST       = propsValueToString(testTaxingProp.allowanceDisab1st )
              val JAN_TAXING_ALLOWANCE_DISAB_2ND       = propsValueToString(testTaxingProp.allowanceDisab2nd )
              val JAN_TAXING_ALLOWANCE_DISAB_3RD       = propsValueToString(testTaxingProp.allowanceDisab3rd )
              val JAN_TAXING_ALLOWANCE_STUDY           = propsValueToString(testTaxingProp.allowanceStudy )
              val JAN_TAXING_ALLOWANCE_CHILD_1ST       = propsValueToString(testTaxingProp.allowanceChild1st )
              val JAN_TAXING_ALLOWANCE_CHILD_2ND       = propsValueToString(testTaxingProp.allowanceChild2nd )
              val JAN_TAXING_ALLOWANCE_CHILD_3RD       = propsValueToString(testTaxingProp.allowanceChild3rd )
              val JAN_TAXING_FACTOR_ADVANCES           = propsValueToString(testTaxingProp.factorAdvances )
              val JAN_TAXING_FACTOR_WITHHOLD           = propsValueToString(testTaxingProp.factorWithhold )
              val JAN_TAXING_FACTOR_SOLIDARY           = propsValueToString(testTaxingProp.factorSolidary )
              val JAN_TAXING_FACTOR_TAXRATE2           = propsValueToString(testTaxingProp.factorTaxRate2 )
              val JAN_TAXING_MIN_AMOUNT_OF_TAXBONUS    = propsValueToString(testTaxingProp.minAmountOfTaxBonus )
              val JAN_TAXING_MAX_AMOUNT_OF_TAXBONUS    = propsValueToString(testTaxingProp.maxAmountOfTaxBonus )
              val JAN_TAXING_MARGIN_INCOME_OF_TAXBONUS = propsValueToString(testTaxingProp.marginIncomeOfTaxBonus )
              val JAN_TAXING_MARGIN_INCOME_OF_ROUNDING = propsValueToString(testTaxingProp.marginIncomeOfRounding )
              val JAN_TAXING_MARGIN_INCOME_OF_WITHHOLD = propsValueToString(testTaxingProp.marginIncomeOfWithhold )
              val JAN_TAXING_MARGIN_INCOME_OF_SOLIDARY = propsValueToString(testTaxingProp.marginIncomeOfSolidary )
              val JAN_TAXING_MARGIN_INCOME_OF_TAXRATE2 = propsValueToString(testTaxingProp.marginIncomeOfTaxRate2 )
              val JAN_TAXING_MARGIN_INCOME_OF_WHT_EMP  = propsValueToString(testTaxingProp.marginIncomeOfWthEmp )
              val JAN_TAXING_MARGIN_INCOME_OF_WHT_AGR  = propsValueToString(testTaxingProp.marginIncomeOfWthAgr )

              for (testMonth <- 2 to 12)
              {
                val nextPeriod = Period.getWithYearMonth(testYear, testMonth)

                val testSalaryNext = _sutSalary.getProps(nextPeriod)
                val testHealthNext = _sutHealth.getProps(nextPeriod)
                val testSocialNext = _sutSocial.getProps(nextPeriod)
                val testTaxingNext = _sutTaxing.getProps(nextPeriod)

                if (testHealthNext.minMonthlyBasis.equals(testHealthProp.minMonthlyBasis)==false) { MES_HEALTH_MIN_MONTHLY_BASIS = testMonth }
                if (testHealthNext.maxAnnualsBasis.equals(testHealthProp.maxAnnualsBasis)==false) { MES_HEALTH_MAX_ANNUALS_BASIS = testMonth }
                if (testHealthNext.limMonthlyState.equals(testHealthProp.limMonthlyState)==false) { MES_HEALTH_LIM_MONTHLY_STATE = testMonth }
                if (testHealthNext.limMonthlyDis50.equals(testHealthProp.limMonthlyDis50)==false) { MES_HEALTH_LIM_MONTHLY_DIS50 = testMonth }
                if (testHealthNext.factorCompound.equals(testHealthProp.factorCompound)==false) { MES_HEALTH_FACTOR_COMPOUND = testMonth }
                if (testHealthNext.factorEmployee.equals(testHealthProp.factorEmployee)==false) { MES_HEALTH_FACTOR_EMPLOYEE = testMonth }
                if (testHealthNext.marginIncomeEmp.equals(testHealthProp.marginIncomeEmp)==false) { MES_HEALTH_MARGIN_INCOME_EMP = testMonth }
                if (testHealthNext.marginIncomeAgr.equals(testHealthProp.marginIncomeAgr)==false) { MES_HEALTH_MARGIN_INCOME_AGR = testMonth }
                if (testSalaryNext.workingShiftWeek.equals(testSalaryProp.workingShiftWeek)==false) { MES_SALARY_WORKING_SHIFT_WEEK = testMonth }
                if (testSalaryNext.workingShiftTime.equals(testSalaryProp.workingShiftTime)==false) { MES_SALARY_WORKING_SHIFT_TIME = testMonth }
                if (testSalaryNext.minMonthlyWage.equals(testSalaryProp.minMonthlyWage)==false) { MES_SALARY_MIN_MONTHLY_WAGE = testMonth }
                if (testSalaryNext.minHourlyWage .equals(testSalaryProp.minHourlyWage)==false) { MES_SALARY_MIN_HOURLY_WAGE = testMonth }
                if (testSocialNext.maxAnnualsBasis.equals(testSocialProp.maxAnnualsBasis)==false) { MES_SOCIAL_MAX_ANNUALS_BASIS = testMonth }
                if (testSocialNext.factorEmployer.equals(testSocialProp.factorEmployer)==false) { MES_SOCIAL_FACTOR_EMPLOYER = testMonth }
                if (testSocialNext.factorEmployerHigher.equals(testSocialProp.factorEmployerHigher)==false) { MES_SOCIAL_FACTOR_EMPLOYER_HIGHER = testMonth }
                if (testSocialNext.factorEmployee.equals(testSocialProp.factorEmployee)==false) { MES_SOCIAL_FACTOR_EMPLOYEE = testMonth }
                if (testSocialNext.factorEmployeeReduce.equals(testSocialProp.factorEmployeeReduce) == false) { MES_SOCIAL_FACTOR_EMPLOYEE_REDUCE = testMonth }
                if (testSocialNext.factorEmployeeGarant.equals(testSocialProp.factorEmployeeGarant)==false) { MES_SOCIAL_FACTOR_EMPLOYEE_GARANT = testMonth }
                if (testSocialNext.marginIncomeEmp.equals(testSocialProp.marginIncomeEmp)==false) { MES_SOCIAL_MARGIN_INCOME_EMP = testMonth }
                if (testSocialNext.marginIncomeAgr.equals(testSocialProp.marginIncomeAgr)==false) { MES_SOCIAL_MARGIN_INCOME_AGR = testMonth }
                if (testTaxingNext.allowancePayer.equals(testTaxingProp.allowancePayer)==false) { MES_TAXING_ALLOWANCE_PAYER = testMonth }
                if (testTaxingNext.allowanceDisab1st.equals(testTaxingProp.allowanceDisab1st)==false) { MES_TAXING_ALLOWANCE_DISAB_1ST = testMonth }
                if (testTaxingNext.allowanceDisab2nd.equals(testTaxingProp.allowanceDisab2nd)==false) { MES_TAXING_ALLOWANCE_DISAB_2ND = testMonth }
                if (testTaxingNext.allowanceDisab3rd.equals(testTaxingProp.allowanceDisab3rd)==false) { MES_TAXING_ALLOWANCE_DISAB_3RD = testMonth }
                if (testTaxingNext.allowanceStudy.equals(testTaxingProp.allowanceStudy)==false) { MES_TAXING_ALLOWANCE_STUDY = testMonth }
                if (testTaxingNext.allowanceChild1st.equals(testTaxingProp.allowanceChild1st)==false) { MES_TAXING_ALLOWANCE_CHILD_1ST = testMonth }
                if (testTaxingNext.allowanceChild2nd.equals(testTaxingProp.allowanceChild2nd)==false) { MES_TAXING_ALLOWANCE_CHILD_2ND = testMonth }
                if (testTaxingNext.allowanceChild3rd.equals(testTaxingProp.allowanceChild3rd)==false) { MES_TAXING_ALLOWANCE_CHILD_3RD = testMonth }
                if (testTaxingNext.factorAdvances.equals(testTaxingProp.factorAdvances)==false) { MES_TAXING_FACTOR_ADVANCES = testMonth }
                if (testTaxingNext.factorWithhold.equals(testTaxingProp.factorWithhold)==false) { MES_TAXING_FACTOR_WITHHOLD = testMonth }
                if (testTaxingNext.factorSolidary.equals(testTaxingProp.factorSolidary)==false) { MES_TAXING_FACTOR_SOLIDARY = testMonth }
                if (testTaxingNext.factorTaxRate2.equals(testTaxingProp.factorTaxRate2)==false) { MES_TAXING_FACTOR_TAXRATE2 = testMonth }
                if (testTaxingNext.minAmountOfTaxBonus.equals(testTaxingProp.minAmountOfTaxBonus)==false) { MES_TAXING_MIN_AMOUNT_OF_TAXBONUS = testMonth }
                if (testTaxingNext.maxAmountOfTaxBonus.equals(testTaxingProp.maxAmountOfTaxBonus)==false) { MES_TAXING_MAX_AMOUNT_OF_TAXBONUS = testMonth }
                if (testTaxingNext.marginIncomeOfTaxBonus.equals(testTaxingProp.marginIncomeOfTaxBonus)==false) { MES_TAXING_MARGIN_INCOME_OF_TAXBONUS = testMonth }
                if (testTaxingNext.marginIncomeOfRounding.equals(testTaxingProp.marginIncomeOfRounding)==false) { MES_TAXING_MARGIN_INCOME_OF_ROUNDING = testMonth }
                if (testTaxingNext.marginIncomeOfWithhold.equals(testTaxingProp.marginIncomeOfWithhold)==false) { MES_TAXING_MARGIN_INCOME_OF_WITHHOLD = testMonth }
                if (testTaxingNext.marginIncomeOfSolidary.equals(testTaxingProp.marginIncomeOfSolidary)==false) { MES_TAXING_MARGIN_INCOME_OF_SOLIDARY = testMonth }
                if (testTaxingNext.marginIncomeOfTaxRate2.equals(testTaxingProp.marginIncomeOfTaxRate2)==false) { MES_TAXING_MARGIN_INCOME_OF_TAXRATE2 = testMonth }
                if (testTaxingNext.marginIncomeOfWthEmp.equals(testTaxingProp.marginIncomeOfWthEmp)==false) { MES_TAXING_MARGIN_INCOME_OF_WHT_EMP = testMonth }
                if (testTaxingNext.marginIncomeOfWthAgr.equals(testTaxingProp.marginIncomeOfWthAgr)==false) { MES_TAXING_MARGIN_INCOME_OF_WHT_AGR = testMonth }

                testSalaryProp = testSalaryNext
                testHealthProp = testHealthNext
                testSocialProp = testSocialNext
                testTaxingProp = testTaxingNext
              }

              VECT_HEALTH_MIN_MONTHLY_BASIS.addOne((testYear, MES_HEALTH_MIN_MONTHLY_BASIS, JAN_HEALTH_MIN_MONTHLY_BASIS, propsValueToString(testHealthProp.minMonthlyBasis)))
              VECT_HEALTH_MAX_ANNUALS_BASIS.addOne((testYear, MES_HEALTH_MAX_ANNUALS_BASIS, JAN_HEALTH_MAX_ANNUALS_BASIS, propsValueToString(testHealthProp.maxAnnualsBasis)))
              VECT_HEALTH_LIM_MONTHLY_STATE.addOne((testYear, MES_HEALTH_LIM_MONTHLY_STATE, JAN_HEALTH_LIM_MONTHLY_STATE, propsValueToString(testHealthProp.limMonthlyState)))
              VECT_HEALTH_LIM_MONTHLY_DIS50.addOne((testYear, MES_HEALTH_LIM_MONTHLY_DIS50, JAN_HEALTH_LIM_MONTHLY_DIS50, propsValueToString(testHealthProp.limMonthlyDis50)))
              VECT_HEALTH_FACTOR_COMPOUND.addOne((testYear, MES_HEALTH_FACTOR_COMPOUND, JAN_HEALTH_FACTOR_COMPOUND, propsValueToString(testHealthProp.factorCompound)))
              VECT_HEALTH_FACTOR_EMPLOYEE.addOne((testYear, MES_HEALTH_FACTOR_EMPLOYEE, JAN_HEALTH_FACTOR_EMPLOYEE, propsValueToString(testHealthProp.factorEmployee)))
              VECT_HEALTH_MARGIN_INCOME_EMP.addOne((testYear, MES_HEALTH_MARGIN_INCOME_EMP, JAN_HEALTH_MARGIN_INCOME_EMP, propsValueToString(testHealthProp.marginIncomeEmp)))
              VECT_HEALTH_MARGIN_INCOME_AGR.addOne((testYear, MES_HEALTH_MARGIN_INCOME_AGR, JAN_HEALTH_MARGIN_INCOME_AGR, propsValueToString(testHealthProp.marginIncomeAgr)))
              VECT_SALARY_WORKING_SHIFT_WEEK.addOne((testYear, MES_SALARY_WORKING_SHIFT_WEEK, JAN_SALARY_WORKING_SHIFT_WEEK, propsValueToString(testSalaryProp.workingShiftWeek)))
              VECT_SALARY_WORKING_SHIFT_TIME.addOne((testYear, MES_SALARY_WORKING_SHIFT_TIME, JAN_SALARY_WORKING_SHIFT_TIME, propsValueToString(testSalaryProp.workingShiftTime)))
              VECT_SALARY_MIN_MONTHLY_WAGE.addOne((testYear, MES_SALARY_MIN_MONTHLY_WAGE, JAN_SALARY_MIN_MONTHLY_WAGE, propsValueToString(testSalaryProp.minMonthlyWage)))
              VECT_SALARY_MIN_HOURLY_WAGE.addOne((testYear, MES_SALARY_MIN_HOURLY_WAGE, JAN_SALARY_MIN_HOURLY_WAGE, propsValueToString(testSalaryProp.minHourlyWage)))
              VECT_SOCIAL_MAX_ANNUALS_BASIS.addOne((testYear, MES_SOCIAL_MAX_ANNUALS_BASIS, JAN_SOCIAL_MAX_ANNUALS_BASIS, propsValueToString(testSocialProp.maxAnnualsBasis)))
              VECT_SOCIAL_FACTOR_EMPLOYER.addOne((testYear, MES_SOCIAL_FACTOR_EMPLOYER, JAN_SOCIAL_FACTOR_EMPLOYER, propsValueToString(testSocialProp.factorEmployer)))
              VECT_SOCIAL_FACTOR_EMPLOYER_HIGHER.addOne((testYear, MES_SOCIAL_FACTOR_EMPLOYER_HIGHER, JAN_SOCIAL_FACTOR_EMPLOYER_HIGHER, propsValueToString(testSocialProp.factorEmployerHigher)))
              VECT_SOCIAL_FACTOR_EMPLOYEE.addOne((testYear, MES_SOCIAL_FACTOR_EMPLOYEE, JAN_SOCIAL_FACTOR_EMPLOYEE, propsValueToString(testSocialProp.factorEmployee)))
              VECT_SOCIAL_FACTOR_EMPLOYEE_GARANT.addOne((testYear, MES_SOCIAL_FACTOR_EMPLOYEE_GARANT, JAN_SOCIAL_FACTOR_EMPLOYEE_GARANT, propsValueToString(testSocialProp.factorEmployeeGarant)))
              VECT_SOCIAL_FACTOR_EMPLOYEE_REDUCE.addOne((testYear, MES_SOCIAL_FACTOR_EMPLOYEE_REDUCE, JAN_SOCIAL_FACTOR_EMPLOYEE_REDUCE, propsValueToString(testSocialProp.factorEmployeeReduce)))
              VECT_SOCIAL_MARGIN_INCOME_EMP.addOne((testYear, MES_SOCIAL_MARGIN_INCOME_EMP, JAN_SOCIAL_MARGIN_INCOME_EMP, propsValueToString(testSocialProp.marginIncomeEmp)))
              VECT_SOCIAL_MARGIN_INCOME_AGR.addOne((testYear, MES_SOCIAL_MARGIN_INCOME_AGR, JAN_SOCIAL_MARGIN_INCOME_AGR, propsValueToString(testSocialProp.marginIncomeAgr)))
              VECT_TAXING_ALLOWANCE_PAYER.addOne((testYear, MES_TAXING_ALLOWANCE_PAYER, JAN_TAXING_ALLOWANCE_PAYER, propsValueToString(testTaxingProp.allowancePayer)))
              VECT_TAXING_ALLOWANCE_DISAB_1ST.addOne((testYear, MES_TAXING_ALLOWANCE_DISAB_1ST, JAN_TAXING_ALLOWANCE_DISAB_1ST, propsValueToString(testTaxingProp.allowanceDisab1st)))
              VECT_TAXING_ALLOWANCE_DISAB_2ND.addOne((testYear, MES_TAXING_ALLOWANCE_DISAB_2ND, JAN_TAXING_ALLOWANCE_DISAB_2ND, propsValueToString(testTaxingProp.allowanceDisab2nd)))
              VECT_TAXING_ALLOWANCE_DISAB_3RD.addOne((testYear, MES_TAXING_ALLOWANCE_DISAB_3RD, JAN_TAXING_ALLOWANCE_DISAB_3RD, propsValueToString(testTaxingProp.allowanceDisab3rd)))
              VECT_TAXING_ALLOWANCE_STUDY.addOne((testYear, MES_TAXING_ALLOWANCE_STUDY, JAN_TAXING_ALLOWANCE_STUDY, propsValueToString(testTaxingProp.allowanceStudy)))
              VECT_TAXING_ALLOWANCE_CHILD_1ST.addOne((testYear, MES_TAXING_ALLOWANCE_CHILD_1ST, JAN_TAXING_ALLOWANCE_CHILD_1ST, propsValueToString(testTaxingProp.allowanceChild1st)))
              VECT_TAXING_ALLOWANCE_CHILD_2ND.addOne((testYear, MES_TAXING_ALLOWANCE_CHILD_2ND, JAN_TAXING_ALLOWANCE_CHILD_2ND, propsValueToString(testTaxingProp.allowanceChild2nd)))
              VECT_TAXING_ALLOWANCE_CHILD_3RD.addOne((testYear, MES_TAXING_ALLOWANCE_CHILD_3RD, JAN_TAXING_ALLOWANCE_CHILD_3RD, propsValueToString(testTaxingProp.allowanceChild3rd)))
              VECT_TAXING_FACTOR_ADVANCES.addOne((testYear, MES_TAXING_FACTOR_ADVANCES, JAN_TAXING_FACTOR_ADVANCES, propsValueToString(testTaxingProp.factorAdvances)))
              VECT_TAXING_FACTOR_WITHHOLD.addOne((testYear, MES_TAXING_FACTOR_WITHHOLD, JAN_TAXING_FACTOR_WITHHOLD, propsValueToString(testTaxingProp.factorWithhold)))
              VECT_TAXING_FACTOR_SOLIDARY.addOne((testYear, MES_TAXING_FACTOR_SOLIDARY, JAN_TAXING_FACTOR_SOLIDARY, propsValueToString(testTaxingProp.factorSolidary)))
              VECT_TAXING_FACTOR_TAXRATE2.addOne((testYear, MES_TAXING_FACTOR_TAXRATE2, JAN_TAXING_FACTOR_TAXRATE2, propsValueToString(testTaxingProp.factorTaxRate2)))
              VECT_TAXING_MIN_AMOUNT_OF_TAXBONUS.addOne((testYear, MES_TAXING_MIN_AMOUNT_OF_TAXBONUS, JAN_TAXING_MIN_AMOUNT_OF_TAXBONUS, propsValueToString(testTaxingProp.minAmountOfTaxBonus)))
              VECT_TAXING_MAX_AMOUNT_OF_TAXBONUS.addOne((testYear, MES_TAXING_MAX_AMOUNT_OF_TAXBONUS, JAN_TAXING_MAX_AMOUNT_OF_TAXBONUS, propsValueToString(testTaxingProp.maxAmountOfTaxBonus)))
              VECT_TAXING_MARGIN_INCOME_OF_TAXBONUS.addOne((testYear, MES_TAXING_MARGIN_INCOME_OF_TAXBONUS, JAN_TAXING_MARGIN_INCOME_OF_TAXBONUS, propsValueToString(testTaxingProp.marginIncomeOfTaxBonus)))
              VECT_TAXING_MARGIN_INCOME_OF_ROUNDING.addOne((testYear, MES_TAXING_MARGIN_INCOME_OF_ROUNDING, JAN_TAXING_MARGIN_INCOME_OF_ROUNDING, propsValueToString(testTaxingProp.marginIncomeOfRounding)))
              VECT_TAXING_MARGIN_INCOME_OF_WITHHOLD.addOne((testYear, MES_TAXING_MARGIN_INCOME_OF_WITHHOLD, JAN_TAXING_MARGIN_INCOME_OF_WITHHOLD, propsValueToString(testTaxingProp.marginIncomeOfWithhold)))
              VECT_TAXING_MARGIN_INCOME_OF_SOLIDARY.addOne((testYear, MES_TAXING_MARGIN_INCOME_OF_SOLIDARY, JAN_TAXING_MARGIN_INCOME_OF_SOLIDARY, propsValueToString(testTaxingProp.marginIncomeOfSolidary)))
              VECT_TAXING_MARGIN_INCOME_OF_TAXRATE2.addOne((testYear, MES_TAXING_MARGIN_INCOME_OF_TAXRATE2, JAN_TAXING_MARGIN_INCOME_OF_TAXRATE2, propsValueToString(testTaxingProp.marginIncomeOfTaxRate2)))
              VECT_TAXING_MARGIN_INCOME_OF_WHT_EMP.addOne((testYear, MES_TAXING_MARGIN_INCOME_OF_WHT_EMP, JAN_TAXING_MARGIN_INCOME_OF_WHT_EMP, propsValueToString(testTaxingProp.marginIncomeOfWthEmp)))
              VECT_TAXING_MARGIN_INCOME_OF_WHT_AGR.addOne((testYear, MES_TAXING_MARGIN_INCOME_OF_WHT_AGR, JAN_TAXING_MARGIN_INCOME_OF_WHT_AGR, propsValueToString(testTaxingProp.marginIncomeOfWthAgr)))
            }

            val tableData = List(
              (HEALTH_MIN_MONTHLY_BASIS         , VECT_HEALTH_MIN_MONTHLY_BASIS),
              (HEALTH_MAX_ANNUALS_BASIS         , VECT_HEALTH_MAX_ANNUALS_BASIS),
              (HEALTH_LIM_MONTHLY_STATE         , VECT_HEALTH_LIM_MONTHLY_STATE),
              (HEALTH_LIM_MONTHLY_DIS50         , VECT_HEALTH_LIM_MONTHLY_DIS50),
              (HEALTH_FACTOR_COMPOUND           , VECT_HEALTH_FACTOR_COMPOUND),
              (HEALTH_FACTOR_EMPLOYEE           , VECT_HEALTH_FACTOR_EMPLOYEE),
              (HEALTH_MARGIN_INCOME_EMP         , VECT_HEALTH_MARGIN_INCOME_EMP),
              (HEALTH_MARGIN_INCOME_AGR         , VECT_HEALTH_MARGIN_INCOME_AGR),
              (SALARY_WORKING_SHIFT_WEEK        , VECT_SALARY_WORKING_SHIFT_WEEK),
              (SALARY_WORKING_SHIFT_TIME        , VECT_SALARY_WORKING_SHIFT_TIME),
              (SALARY_MIN_MONTHLY_WAGE          , VECT_SALARY_MIN_MONTHLY_WAGE),
              (SALARY_MIN_HOURLY_WAGE           , VECT_SALARY_MIN_HOURLY_WAGE),
              (SOCIAL_MAX_ANNUALS_BASIS         , VECT_SOCIAL_MAX_ANNUALS_BASIS),
              (SOCIAL_FACTOR_EMPLOYER           , VECT_SOCIAL_FACTOR_EMPLOYER),
              (SOCIAL_FACTOR_EMPLOYER_HIGHER    , VECT_SOCIAL_FACTOR_EMPLOYER_HIGHER),
              (SOCIAL_FACTOR_EMPLOYEE           , VECT_SOCIAL_FACTOR_EMPLOYEE),
              (SOCIAL_FACTOR_EMPLOYEE_GARANT    , VECT_SOCIAL_FACTOR_EMPLOYEE_GARANT),
              (SOCIAL_FACTOR_EMPLOYEE_REDUCE    , VECT_SOCIAL_FACTOR_EMPLOYEE_REDUCE),
              (SOCIAL_MARGIN_INCOME_EMP         , VECT_SOCIAL_MARGIN_INCOME_EMP),
              (SOCIAL_MARGIN_INCOME_AGR         , VECT_SOCIAL_MARGIN_INCOME_AGR),
              (TAXING_ALLOWANCE_PAYER           , VECT_TAXING_ALLOWANCE_PAYER),
              (TAXING_ALLOWANCE_DISAB_1ST       , VECT_TAXING_ALLOWANCE_DISAB_1ST),
              (TAXING_ALLOWANCE_DISAB_2ND       , VECT_TAXING_ALLOWANCE_DISAB_2ND),
              (TAXING_ALLOWANCE_DISAB_3RD       , VECT_TAXING_ALLOWANCE_DISAB_3RD),
              (TAXING_ALLOWANCE_STUDY           , VECT_TAXING_ALLOWANCE_STUDY),
              (TAXING_ALLOWANCE_CHILD_1ST       , VECT_TAXING_ALLOWANCE_CHILD_1ST),
              (TAXING_ALLOWANCE_CHILD_2ND       , VECT_TAXING_ALLOWANCE_CHILD_2ND),
              (TAXING_ALLOWANCE_CHILD_3RD       , VECT_TAXING_ALLOWANCE_CHILD_3RD),
              (TAXING_FACTOR_ADVANCES           , VECT_TAXING_FACTOR_ADVANCES),
              (TAXING_FACTOR_WITHHOLD           , VECT_TAXING_FACTOR_WITHHOLD),
              (TAXING_FACTOR_SOLIDARY           , VECT_TAXING_FACTOR_SOLIDARY),
              (TAXING_FACTOR_TAXRATE2           , VECT_TAXING_FACTOR_TAXRATE2),
              (TAXING_MIN_AMOUNT_OF_TAXBONUS    , VECT_TAXING_MIN_AMOUNT_OF_TAXBONUS),
              (TAXING_MAX_AMOUNT_OF_TAXBONUS    , VECT_TAXING_MAX_AMOUNT_OF_TAXBONUS),
              (TAXING_MARGIN_INCOME_OF_TAXBONUS , VECT_TAXING_MARGIN_INCOME_OF_TAXBONUS),
              (TAXING_MARGIN_INCOME_OF_ROUNDING , VECT_TAXING_MARGIN_INCOME_OF_ROUNDING),
              (TAXING_MARGIN_INCOME_OF_WITHHOLD , VECT_TAXING_MARGIN_INCOME_OF_WITHHOLD),
              (TAXING_MARGIN_INCOME_OF_SOLIDARY , VECT_TAXING_MARGIN_INCOME_OF_SOLIDARY),
              (TAXING_MARGIN_INCOME_OF_TAXRATE2 , VECT_TAXING_MARGIN_INCOME_OF_TAXRATE2),
              (TAXING_MARGIN_INCOME_OF_WHT_EMP  , VECT_TAXING_MARGIN_INCOME_OF_WHT_EMP),
              (TAXING_MARGIN_INCOME_OF_WHT_AGR  , VECT_TAXING_MARGIN_INCOME_OF_WHT_AGR),
            )

            tableData.foreach(data => {
              exportHistoryTerm(testProtokol, headerData, data)
            })
          } finally {
            closeHistoryFile(testProtokol)
          }
        }
      }
    }
  }


  val HEALTH_MIN_MONTHLY_BASIS        :Int = 101
  val HEALTH_MAX_ANNUALS_BASIS        :Int = 102
  val HEALTH_LIM_MONTHLY_STATE        :Int = 103
  val HEALTH_LIM_MONTHLY_DIS50        :Int = 104
  val HEALTH_FACTOR_COMPOUND          :Int = 105
  val HEALTH_FACTOR_EMPLOYEE          :Int = 106
  val HEALTH_MARGIN_INCOME_EMP        :Int = 107
  val HEALTH_MARGIN_INCOME_AGR        :Int = 108

  val SALARY_WORKING_SHIFT_WEEK       :Int = 201
  val SALARY_WORKING_SHIFT_TIME       :Int = 202
  val SALARY_MIN_MONTHLY_WAGE         :Int = 203
  val SALARY_MIN_HOURLY_WAGE          :Int = 204

  val SOCIAL_MAX_ANNUALS_BASIS        :Int = 301
  val SOCIAL_FACTOR_EMPLOYER          :Int = 302
  val SOCIAL_FACTOR_EMPLOYER_HIGHER   :Int = 303
  val SOCIAL_FACTOR_EMPLOYEE          :Int = 304
  val SOCIAL_FACTOR_EMPLOYEE_GARANT   :Int = 305
  val SOCIAL_FACTOR_EMPLOYEE_REDUCE   :Int = 306
  val SOCIAL_MARGIN_INCOME_EMP        :Int = 307
  val SOCIAL_MARGIN_INCOME_AGR        :Int = 308

  val TAXING_ALLOWANCE_PAYER          :Int = 401
  val TAXING_ALLOWANCE_DISAB_1ST      :Int = 402
  val TAXING_ALLOWANCE_DISAB_2ND      :Int = 403
  val TAXING_ALLOWANCE_DISAB_3RD      :Int = 404
  val TAXING_ALLOWANCE_STUDY          :Int = 405
  val TAXING_ALLOWANCE_CHILD_1ST      :Int = 406
  val TAXING_ALLOWANCE_CHILD_2ND      :Int = 407
  val TAXING_ALLOWANCE_CHILD_3RD      :Int = 408
  val TAXING_FACTOR_ADVANCES          :Int = 409
  val TAXING_FACTOR_WITHHOLD          :Int = 410
  val TAXING_FACTOR_SOLIDARY          :Int = 411
  val TAXING_FACTOR_TAXRATE2          :Int = 412
  val TAXING_MIN_AMOUNT_OF_TAXBONUS   :Int = 413
  val TAXING_MAX_AMOUNT_OF_TAXBONUS   :Int = 414
  val TAXING_MARGIN_INCOME_OF_TAXBONUS:Int = 415
  val TAXING_MARGIN_INCOME_OF_ROUNDING:Int = 416
  val TAXING_MARGIN_INCOME_OF_WITHHOLD:Int = 417
  val TAXING_MARGIN_INCOME_OF_SOLIDARY:Int = 418
  val TAXING_MARGIN_INCOME_OF_TAXRATE2:Int = 419
  val TAXING_MARGIN_INCOME_OF_WHT_EMP :Int = 420
  val TAXING_MARGIN_INCOME_OF_WHT_AGR :Int = 421

  def createHistoryFile(fileName : String): FileWriter = {
    var currPath = Paths.get(".").toAbsolutePath()
    while (!currPath.endsWith(PARENT_HISTORY_FOLDER_NAME) || currPath.getNameCount()==1) {
    currPath = currPath.getParent()
  }
    val basePath = Paths.get(currPath.toString(), HISTORY_FOLDER_NAME)
    val path = Paths.get(basePath.toString(), fileName).toAbsolutePath().toString()
    return new FileWriter(new File(path))
  }

  def closeHistoryFile(protokol: FileWriter): Unit = {
    protokol.flush()
    protokol.close()
  }

  def exportHistoryStart(protokol: FileWriter, data: Iterable[(Int, Boolean)]) = {
    protokol.write("History Term")
    data.foreach(col => {
      if (col._2)
      {
        protokol.write(s"\t${col._1} Begin Value")
        protokol.write(s"\t${col._1} Change Month")
        protokol.write(s"\t${col._1} End Value")
      }
      else
      {
        protokol.write(s"\t${col._1} Value")
      }
    })
    protokol.write("\n")
  }

  def exportHistoryTerm(protokol: FileWriter, head: Iterable[(Int, Boolean)], data: (Int, Iterable[(Int, Int, String, String)])): Unit = {
    protokol.write(historyTermName(data._1))
    data._2.foreach(col => {
      val maybeHeader = head.find(x => (x._1 == col._2))
      var yearOfChange: Boolean = maybeHeader match {
        case Some(x) => x._2
        case _ => false
      }

      protokol.write(s"\t${col._3}")
      if (yearOfChange)
      {
        if (col._2 == 0)
        {
          protokol.write("\t")
        }
        else
        {
          protokol.write(s"\t${col._2}")
        }
        protokol.write(s"\t${col._4}")
      }
    })
    protokol.write("\n")
  }

  def historyTermName(termId: Int): String = {
    return termId match {
      case HEALTH_MIN_MONTHLY_BASIS => "01_Health_01_MinMonthlyBasis"
      case HEALTH_MAX_ANNUALS_BASIS => "01_Health_02_MaxAnnualsBasis"
      case HEALTH_LIM_MONTHLY_STATE => "01_Health_03_LimMonthlyState"
      case HEALTH_LIM_MONTHLY_DIS50 => "01_Health_04_LimMonthlyDis50"
      case HEALTH_FACTOR_COMPOUND => "01_Health_05_FactorCompound"
      case HEALTH_FACTOR_EMPLOYEE => "01_Health_06_FactorEmployee"
      case HEALTH_MARGIN_INCOME_EMP => "01_Health_07_MarginIncomeEmp"
      case HEALTH_MARGIN_INCOME_AGR => "01_Health_08_MarginIncomeAgr"
      case SALARY_WORKING_SHIFT_WEEK => "02_Salary_01_WorkingShiftWeek"
      case SALARY_WORKING_SHIFT_TIME => "02_Salary_02_WorkingShiftTime"
      case SALARY_MIN_MONTHLY_WAGE => "02_Salary_03_MinMonthlyWage"
      case SALARY_MIN_HOURLY_WAGE => "02_Salary_04_MinHourlyWage"
      case SOCIAL_MAX_ANNUALS_BASIS => "03_Social_01_MaxAnnualsBasis"
      case SOCIAL_FACTOR_EMPLOYER => "03_Social_02_FactorEmployer"
      case SOCIAL_FACTOR_EMPLOYER_HIGHER => "03_Social_03_FactorEmployerHigher"
      case SOCIAL_FACTOR_EMPLOYEE => "03_Social_04_FactorEmployee"
      case SOCIAL_FACTOR_EMPLOYEE_GARANT => "03_Social_05_FactorEmployeeGarant"
      case SOCIAL_FACTOR_EMPLOYEE_REDUCE => "03_Social_06_FactorEmployeeReduce"
      case SOCIAL_MARGIN_INCOME_EMP => "03_Social_07_MarginIncomeEmp"
      case SOCIAL_MARGIN_INCOME_AGR => "03_Social_08_MarginIncomeAgr"
      case TAXING_ALLOWANCE_PAYER => "04_Taxing_01_AllowancePayer"
      case TAXING_ALLOWANCE_DISAB_1ST => "04_Taxing_02_AllowanceDisab1st"
      case TAXING_ALLOWANCE_DISAB_2ND => "04_Taxing_03_AllowanceDisab2nd"
      case TAXING_ALLOWANCE_DISAB_3RD => "04_Taxing_04_AllowanceDisab3rd"
      case TAXING_ALLOWANCE_STUDY => "04_Taxing_05_AllowanceStudy"
      case TAXING_ALLOWANCE_CHILD_1ST => "04_Taxing_06_AllowanceChild1st"
      case TAXING_ALLOWANCE_CHILD_2ND => "04_Taxing_07_AllowanceChild2nd"
      case TAXING_ALLOWANCE_CHILD_3RD => "04_Taxing_08_AllowanceChild3rd"
      case TAXING_FACTOR_ADVANCES => "04_Taxing_09_FactorAdvances"
      case TAXING_FACTOR_WITHHOLD => "04_Taxing_10_FactorWithhold"
      case TAXING_FACTOR_SOLIDARY => "04_Taxing_11_FactorSolidary"
      case TAXING_FACTOR_TAXRATE2 => "04_Taxing_12_FactorTaxRate2"
      case TAXING_MIN_AMOUNT_OF_TAXBONUS => "04_Taxing_13_MinAmountOfTaxBonus"
      case TAXING_MAX_AMOUNT_OF_TAXBONUS => "04_Taxing_14_MaxAmountOfTaxBonus"
      case TAXING_MARGIN_INCOME_OF_TAXBONUS => "04_Taxing_15_MarginIncomeOfTaxBonus"
      case TAXING_MARGIN_INCOME_OF_ROUNDING => "04_Taxing_16_MarginIncomeOfRounding"
      case TAXING_MARGIN_INCOME_OF_WITHHOLD => "04_Taxing_17_MarginIncomeOfWithhold"
      case TAXING_MARGIN_INCOME_OF_SOLIDARY => "04_Taxing_18_MarginIncomeOfSolidary"
      case TAXING_MARGIN_INCOME_OF_TAXRATE2 => "04_Taxing_18_MarginIncomeOfTaxRate2"
      case TAXING_MARGIN_INCOME_OF_WHT_EMP => "04_Taxing_20_MarginIncomeOfWthEmp"
      case TAXING_MARGIN_INCOME_OF_WHT_AGR => "04_Taxing_21_MarginIncomeOfWthAgr"
      case _ => "Unknown Term"
    }
  }

  def historyTermNameCZ(termId: Int): String = {
    return termId match {
      case HEALTH_MIN_MONTHLY_BASIS => "01_Health_01 Minimální základ zdravotního pojištění na jednoho pracovníka"
      case HEALTH_MAX_ANNUALS_BASIS => "01_Health_02 Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)"
      case HEALTH_LIM_MONTHLY_STATE => "01_Health_03 Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci)"
      case HEALTH_LIM_MONTHLY_DIS50 => "01_Health_04 Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci) u zaměstnavatele zaměstnávajícího více než 50% osob OZP"
      case HEALTH_FACTOR_COMPOUND => "01_Health_05 složená sazba zdravotního pojištění (zaměstnace + zaměstnavatele)"
      case HEALTH_FACTOR_EMPLOYEE => "01_Health_06 podíl sazby zdravotního pojištění připadajícího na zaměstnace (1/FACTOR_EMPLOYEE)"
      case HEALTH_MARGIN_INCOME_EMP => "01_Health_07 hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru"
      case HEALTH_MARGIN_INCOME_AGR => "01_Health_08 hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu"
      case SALARY_WORKING_SHIFT_WEEK => "02_Salary_01 Počet pracovních dnů v týdnu"
      case SALARY_WORKING_SHIFT_TIME => "02_Salary_02 Počet pracovních hodin denně"
      case SALARY_MIN_MONTHLY_WAGE => "02_Salary_03 Minimální mzda měsíční"
      case SALARY_MIN_HOURLY_WAGE => "02_Salary_04 Minimální mzda hodinová (100*Kč)"
      case SOCIAL_MAX_ANNUALS_BASIS => "03_Social_01 Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)"
      case SOCIAL_FACTOR_EMPLOYER => "03_Social_02 Sazba - standardní sociálního pojištění - zaměstnavatele"
      case SOCIAL_FACTOR_EMPLOYER_HIGHER => "03_Social_03 Sazba - vyší sociálního pojištění - zaměstnavatele"
      case SOCIAL_FACTOR_EMPLOYEE => "03_Social_04 Sazba sociálního pojištění - zaměstnance"
      case SOCIAL_FACTOR_EMPLOYEE_GARANT => "03_Social_05 Sazba důchodového spoření - zaměstnance - s důchodovým spořením"
      case SOCIAL_FACTOR_EMPLOYEE_REDUCE => "03_Social_06 Snížení sazby sociálního pojištění - zaměstnance - s důchodovým spořením"
      case SOCIAL_MARGIN_INCOME_EMP => "03_Social_07 hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru"
      case SOCIAL_MARGIN_INCOME_AGR => "03_Social_08 hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu"
      case TAXING_ALLOWANCE_PAYER => "04_Taxing_01 Částka slevy na poplatníka"
      case TAXING_ALLOWANCE_DISAB_1ST => "04_Taxing_02 Částka slevy na invaliditu 1.stupně poplatníka"
      case TAXING_ALLOWANCE_DISAB_2ND => "04_Taxing_03 Částka slevy na invaliditu 2.stupně poplatníka"
      case TAXING_ALLOWANCE_DISAB_3RD => "04_Taxing_04 Částka slevy na invaliditu 3.stupně poplatníka"
      case TAXING_ALLOWANCE_STUDY => "04_Taxing_05 Částka slevy na poplatníka studenta"
      case TAXING_ALLOWANCE_CHILD_1ST => "04_Taxing_06 Částka slevy na dítě 1.pořadí"
      case TAXING_ALLOWANCE_CHILD_2ND => "04_Taxing_07 Částka slevy na dítě 2.pořadí"
      case TAXING_ALLOWANCE_CHILD_3RD => "04_Taxing_08 Částka slevy na dítě 3.pořadí"
      case TAXING_FACTOR_ADVANCES => "04_Taxing_09 Sazba daně na zálohový příjem"
      case TAXING_FACTOR_WITHHOLD => "04_Taxing_10 Sazba daně na srážkový příjem"
      case TAXING_FACTOR_SOLIDARY => "04_Taxing_11 Sazba daně na solidární zvýšení"
      case TAXING_FACTOR_TAXRATE2 => "04_Taxing_12 Sazba daně pro druhé pásmo daně"
      case TAXING_MIN_AMOUNT_OF_TAXBONUS => "04_Taxing_13 Minimální částka pro daňový bonus"
      case TAXING_MAX_AMOUNT_OF_TAXBONUS => "04_Taxing_14 Maximální částka pro daňový bonus"
      case TAXING_MARGIN_INCOME_OF_TAXBONUS => "04_Taxing_15 Minimální výše příjmu pro nároku na daňový bonus"
      case TAXING_MARGIN_INCOME_OF_ROUNDING => "04_Taxing_16 Maximální výše příjmu pro zaokrouhlování"
      case TAXING_MARGIN_INCOME_OF_WITHHOLD => "04_Taxing_17 Maximální výše příjmu pro srážkový příjem"
      case TAXING_MARGIN_INCOME_OF_SOLIDARY => "04_Taxing_18 Minimální výše příjmu pro solidární zvýšení daně"
      case TAXING_MARGIN_INCOME_OF_TAXRATE2 => "04_Taxing_18 Minimální výše příjmu pro druhé pásmo daně"
      case TAXING_MARGIN_INCOME_OF_WHT_EMP => "04_Taxing_20 hranice příjmu pro srážkovou daň pro zaměstnace v pracovním poměru (nepodepsal prohlášení)"
      case TAXING_MARGIN_INCOME_OF_WHT_AGR => "04_Taxing_21 hranice příjmu pro srážkovou daň pro zaměstnace na dohodu (nepodepsal prohlášení)"
      case _ => "Neznámý Termín"
    }
  }
  def propsValueToString(value: Int): String = {
    return "$value"
  }

  def propsValueToString(value: BigDecimal): String = {
    val intValue: Int = (value*BigDecimal.valueOf(100)).toInt
    return "$intValue"
  }

}
