package org.hravemzdy.legalios.protokols

import org.hravemzdy.legalios.TestYearsScenario
import org.hravemzdy.legalios.factories.FactoryTaxing
import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.providers.IProviderTaxing
import org.junit.runner.RunWith
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProtokolTaxingTest extends AnyFunSpec {
  // 04_Taxing_01_AllowancePayer
  describe("GetProps_ShouldExport_AllowancePayer") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_01_AllowancePayer.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowancePayer)
      }
    })
  }
  // 04_Taxing_02_AllowanceDisab1st
  describe("GetProps_ShouldExport_AllowanceDisab1st") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_02_AllowanceDisab1st.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowanceDisab1st)
      }
    })
  }
  // 04_Taxing_03_AllowanceDisab2nd
  describe("GetProps_ShouldExport_AllowanceDisab2nd") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_03_AllowanceDisab2nd.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowanceDisab2nd)
      }
    })
  }
  // 04_Taxing_04_AllowanceDisab3rd
  describe("GetProps_ShouldExport_AllowanceDisab3rd") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_04_AllowanceDisab3rd.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowanceDisab3rd)
      }
    })
  }
  // 04_Taxing_05_AllowanceStudy
  describe("GetProps_ShouldExport_AllowanceStudy") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_05_AllowanceStudy.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowanceStudy)
      }
    })
  }
  // 04_Taxing_06_AllowanceChild1st
  describe("GetProps_ShouldExport_AllowanceChild1st") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_06_AllowanceChild1st.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowanceChild1st)
      }
    })
  }
  // 04_Taxing_07_AllowanceChild2nd
  describe("GetProps_ShouldExport_AllowanceChild2nd") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_07_AllowanceChild2nd.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowanceChild2nd)
      }
    })
  }
  // 04_Taxing_08_AllowanceChild3rd
  describe("GetProps_ShouldExport_AllowanceChild3rd") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_08_AllowanceChild3rd.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.allowanceChild3rd)
      }
    })
  }
  // 04_Taxing_09_FactorAdvances
  describe("GetProps_ShouldExport_FactorAdvances") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsDecFile[IProviderTaxing, IPropsTaxing]("04_Taxing_09_FactorAdvances.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorAdvances)
      }
    })
  }
  // 04_Taxing_10_FactorWithhold
  describe("GetProps_ShouldExport_FactorWithhold") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsDecFile[IProviderTaxing, IPropsTaxing]("04_Taxing_10_FactorWithhold.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorWithhold)
      }
    })
  }
  // 04_Taxing_11_FactorSolidary
  describe("GetProps_ShouldExport_FactorSolidary") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsDecFile[IProviderTaxing, IPropsTaxing]("04_Taxing_11_FactorSolidary.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorSolidary)
      }
    })
  }
  // 04_Taxing_12_FactorTaxRate2
  describe("GetProps_ShouldExport_FactorTaxRate2") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsDecFile[IProviderTaxing, IPropsTaxing]("04_Taxing_12_FactorTaxRate2.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.factorTaxRate2)
      }
    })
  }
  // 04_Taxing_13_MinAmountOfTaxBonus
  describe("GetProps_ShouldExport_MinAmountOfTaxBonus") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_13_MinAmountOfTaxBonus.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.minAmountOfTaxBonus)
      }
    })
  }
  // 04_Taxing_14_MaxAmountOfTaxBonus
  describe("GetProps_ShouldExport_MaxAmountOfTaxBonus") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_14_MaxAmountOfTaxBonus.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.maxAmountOfTaxBonus)
      }
    })
  }
  // 04_Taxing_15_MarginIncomeOfTaxBonus
  describe("GetProps_ShouldExport_MarginIncomeOfTaxBonus") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_15_MarginIncomeOfTaxBonus.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeOfTaxBonus)
      }
    })
  }
  // 04_Taxing_16_MarginIncomeOfRounding
  describe("GetProps_ShouldExport_MarginIncomeOfRounding") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_16_MarginIncomeOfRounding.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeOfRounding)
      }
    })
  }
  // 04_Taxing_17_MarginIncomeOfWithhold
  describe("GetProps_ShouldExport_MarginIncomeOfWithhold") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_17_MarginIncomeOfWithhold.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeOfWithhold)
      }
    })
  }
  // 04_Taxing_18_MarginIncomeOfSolidary
  describe("GetProps_ShouldExport_MarginIncomeOfSolidary") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_18_MarginIncomeOfSolidary.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeOfSolidary)
      }
    })
  }
  // 04_Taxing_19_MarginIncomeOfTaxRate2
  describe("GetProps_ShouldExport_MarginIncomeOfTaxRate2") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_19_MarginIncomeOfTaxRate2.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeOfTaxRate2)
      }
    })
  }
  // 04_Taxing_20_MarginIncomeOfWthEmp
  describe("GetProps_ShouldExport_MarginIncomeOfWthEmp") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_20_MarginIncomeOfWthEmp.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeOfWthEmp)
      }
    })
  }
  // 04_Taxing_21_MarginIncomeOfWthAgr
  describe("GetProps_ShouldExport_MarginIncomeOfWthAgr") {
    List(TestYearsScenario(2010, 2022)).foreach(tt => {
      it("GetProps should export values") {
        val factory = new FactoryTaxing()

        ProtokolBaseTest.ExportPropsIntFile[IProviderTaxing, IPropsTaxing]("04_Taxing_21_MarginIncomeOfWthAgr.txt",
          tt.minYear, tt.maxYear, factory,
          prop => prop.marginIncomeOfWthAgr)
      }
    })
  }
}
