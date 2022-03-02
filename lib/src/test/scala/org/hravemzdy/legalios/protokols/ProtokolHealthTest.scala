package org.hravemzdy.legalios.protokols

import org.hravemzdy.legalios.TestYearsScenario
import org.hravemzdy.legalios.factories.{FactoryHealth}
import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.providers.IProviderHealth
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProtokolHealthTest extends AnyFunSpec {
  // 01_Health_01_MinMonthlyBasis
  describe("GetProps_ShouldExport_MinMonthlyBasis") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsIntFile[IProviderHealth, IPropsHealth]("01_Health_01_MinMonthlyBasis.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.minMonthlyBasis)
      }
    })
  }

  // 01_Health_02_MaxAnnualsBasis
  describe("GetProps_ShouldExport_MaxAnnualsBasis") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsIntFile[IProviderHealth, IPropsHealth]("01_Health_02_MaxAnnualsBasis.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.maxAnnualsBasis)
      }
    })
  }

  // 01_Health_03_LimMonthlyState
  describe("GetProps_ShouldExport_LimMonthlyState") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsIntFile[IProviderHealth, IPropsHealth]("01_Health_03_LimMonthlyState.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.limMonthlyState)
      }
    })
  }

  // 01_Health_04_LimMonthlyDis50
  describe("GetProps_ShouldExport_LimMonthlyDis50") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsIntFile[IProviderHealth, IPropsHealth]("01_Health_04_LimMonthlyDis50.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.limMonthlyDis50)
      }
    })
  }

  // 01_Health_05_FactorCompound
  describe("GetProps_ShouldExport_FactorCompound") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsDecFile[IProviderHealth, IPropsHealth]("01_Health_05_FactorCompound.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorCompound)
      }
    })
  }

  // 01_Health_06_FactorEmployee
  describe("GetProps_ShouldExport_FactorEmployee") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsDecFile[IProviderHealth, IPropsHealth]("01_Health_06_FactorEmployee.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorEmployee)
      }
    })
  }

  // 01_Health_07_MarginIncomeEmp
  describe("GetProps_ShouldExport_MarginIncomeEmp") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsIntFile[IProviderHealth, IPropsHealth]("01_Health_07_MarginIncomeEmp.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeEmp)
      }
    })
  }

  // 01_Health_08_MarginIncomeAgr
  describe("GetProps_ShouldExport_MarginIncomeAgr") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryHealth()

        ProtokolBaseTest.ExportPropsIntFile[IProviderHealth, IPropsHealth]("01_Health_08_MarginIncomeAgr.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeAgr)
      }
    })
  }
}
