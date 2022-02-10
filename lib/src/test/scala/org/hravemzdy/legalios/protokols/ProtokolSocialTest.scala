package org.hravemzdy.legalios.protokols

import org.hravemzdy.legalios.TestYearsScenario
import org.hravemzdy.legalios.factories.FactorySocial
import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.providers.IProviderSocial
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProtokolSocialTest extends AnyFunSpec {
  // 03_Social_01_MaxAnnualsBasis
  describe("GetProps_ShouldExport_MaxAnnualsBasis") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsIntFile[IProviderSocial, IPropsSocial]("03_Social_01_MaxAnnualsBasis.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.maxAnnualsBasis)
      }
    })
  }
  // 03_Social_02_FactorEmployer
  describe("GetProps_ShouldExport_FactorEmployer") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsDecFile[IProviderSocial, IPropsSocial]("03_Social_02_FactorEmployer.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorEmployer)
      }
    })
  }
  // 03_Social_03_FactorEmployerHigher
  describe("GetProps_ShouldExport_FactorEmployerHigher") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsDecFile[IProviderSocial, IPropsSocial]("03_Social_03_FactorEmployerHigher.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorEmployerHigher)
      }
    })
  }
  // 03_Social_04_FactorEmployee
  describe("GetProps_ShouldExport_FactorEmployee") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsDecFile[IProviderSocial, IPropsSocial]("03_Social_04_FactorEmployee.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorEmployee)
      }
    })
  }
  // 03_Social_05_FactorEmployeeGarant
  describe("GetProps_ShouldExport_FactorEmployeeGarant") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsDecFile[IProviderSocial, IPropsSocial]("03_Social_05_FactorEmployeeGarant.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorEmployeeGarant)
      }
    })
  }
  // 03_Social_06_FactorEmployeeReduce
  describe("GetProps_ShouldExport_FactorEmployeeReduce") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsDecFile[IProviderSocial, IPropsSocial]("03_Social_06_FactorEmployeeReduce.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorEmployeeReduce)
      }
    })
  }
  // 03_Social_07_MarginIncomeEmp
  describe("GetProps_ShouldExport_MarginIncomeEmp") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsIntFile[IProviderSocial, IPropsSocial]("03_Social_07_MarginIncomeEmp.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeEmp)
      }
    })
  }
  // 03_Social_08_MarginIncomeAgr
  describe("GetProps_ShouldExport_MarginIncomeAgr") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactorySocial()

        ProtokolBaseTest.ExportPropsIntFile[IProviderSocial, IPropsSocial]("03_Social_08_MarginIncomeAgr.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeAgr)
      }
    })
  }
}
