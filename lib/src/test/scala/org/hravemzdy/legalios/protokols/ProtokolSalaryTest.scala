package org.hravemzdy.legalios.protokols

import org.hravemzdy.legalios.TestYearsScenario
import org.hravemzdy.legalios.factories.FactorySalary
import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.providers.IProviderSalary
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProtokolSalaryTest extends AnyFunSpec {
  // 02_Salary_01_WorkingShiftWeek
  describe("GetProps_ShouldExport_WorkingShiftWeek") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySalary()

        ProtokolBaseTest.ExportPropsIntFile[IProviderSalary, IPropsSalary]("02_Salary_01_WorkingShiftWeek.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.workingShiftWeek)
      }
    })
  }
  // 02_Salary_02_WorkingShiftTime
  describe("GetProps_ShouldExport_WorkingShiftTime") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySalary()

        ProtokolBaseTest.ExportPropsIntFile[IProviderSalary, IPropsSalary]("02_Salary_02_WorkingShiftTime.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.workingShiftTime)
      }
    })
  }
  // 02_Salary_03_MinMonthlyWage
  describe("GetProps_ShouldExport_MinMonthlyWage") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySalary()

        ProtokolBaseTest.ExportPropsIntFile[IProviderSalary, IPropsSalary]("02_Salary_03_MinMonthlyWage.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.minMonthlyWage)
      }
    })
  }
  // 02_Salary_04_MinHourlyWage
  describe("GetProps_ShouldExport_MinHourlyWage") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySalary()

        ProtokolBaseTest.ExportPropsIntFile[IProviderSalary, IPropsSalary]("02_Salary_04_MinHourlyWage.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.minHourlyWage)
      }
    })
  }
}
