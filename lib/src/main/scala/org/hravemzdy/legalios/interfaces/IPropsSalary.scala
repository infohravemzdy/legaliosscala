package org.hravemzdy.legalios.interfaces

trait IPropsSalary extends IProps {
  val workingShiftWeek : Int
  val workingShiftTime : Int
  val minMonthlyWage : Int
  val minHourlyWage : Int
}
