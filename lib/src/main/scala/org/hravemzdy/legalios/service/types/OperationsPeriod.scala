package org.hravemzdy.legalios.service.types

import org.hravemzdy.legalios.interfaces.IPeriod

import java.time.LocalDate

object OperationsPeriod {
  val TERM_BEG_FINISHED: Int = 32

  val TERM_END_FINISHED: Int = 0

  val WEEKSUN_SUNDAY: Int = 0

  val WEEKMON_SUNDAY: Int = 7

  val TIME_MULTIPLY_SIXTY: Int = 60

  val WEEKDAYS_COUNT: Int = 7

  def emptyMonthSchedule(): Array[Int] = {
    return Array[Int](0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  }

  def totalWeeksHours(template: Array[Int]): Int = {
    val result = template.take(7).fold(0)((agr, x) => agr + x )

    return result
  }
  def totalMonthHours(template: Array[Int]): Int = {
    val result = template.take(31).fold(0)((agr, x) => agr + x )

    return result
  }
  def daysInMonth(period: IPeriod): Int = {
    val date = LocalDate.of(period.year, period.month, 1)
    return date.lengthOfMonth()
  }
  def dateOfMonth(period: IPeriod, dayOrdinal: Int): LocalDate = {
      val periodDay: Int = 1.max(dayOrdinal).min(daysInMonth(period))

      return LocalDate.of(period.year, period.month, periodDay)
    }
  def dayOfWeekMonToSun(periodDateCwd: Int): Int = {
    // DayOfWeek Sunday = 0,
    // Monday = 1, Tuesday = 2, Wednesday = 3, Thursday = 4, Friday = 5, Saturday = 6,
    if (periodDateCwd == WEEKSUN_SUNDAY) {
      return WEEKMON_SUNDAY
    }
    return periodDateCwd
  }
  def dayOfWeekFromOrdinal(dayOrdinal: Int, periodBeginCwd: Int): Int = {
    // dayOrdinal 1..31
    // periodBeginCwd 1..7
    // dayOfWeek 1..7

    val dayOfWeek = (((dayOrdinal - 1) + (periodBeginCwd - 1)) % 7) + 1

    return dayOfWeek
  }

  def weekDayOfMonth(period: IPeriod, dayOrdinal: Int): Int = {
    val periodDate = dateOfMonth(period, dayOrdinal)

    val periodDateCwd = periodDate.getDayOfWeek.getValue

    return dayOfWeekMonToSun(periodDateCwd)
  }
  def dateFromInPeriod(period: IPeriod, dateFrom: Option[LocalDate]): Int = {
    var dayTermFrom = TERM_BEG_FINISHED

    val periodDateBeg = LocalDate.of(period.year, period.month, 1)

    dayTermFrom = dateFrom match {
      case Some(value) => {
        if (value.compareTo(periodDateBeg) < 0) {
          return 1
        }
        return value.getDayOfMonth
      }
      case None => 1
    }
    return dayTermFrom
  }

  def dateStopInPeriod(period: IPeriod, dateEnds: Option[LocalDate]): Int = {
    var dayTermEnd = TERM_END_FINISHED

    val daysPeriod = daysInMonth(period)

    val periodDateEnd = LocalDate.of(period.year, period.month, daysPeriod)

    dayTermEnd = dateEnds match {
      case Some(value) => {
        if (value.compareTo(periodDateEnd) > 0) {
          return daysPeriod
        }
        return value.getDayOfMonth
      }
      case None => daysPeriod
    }
    return dayTermEnd
  }
  def timesheetWeekSchedule(period: IPeriod, secondsWeekly: Int, workdaysWeekly: Int): Array[Int] = {
    val secondsDaily = (secondsWeekly / Math.min(workdaysWeekly, WEEKDAYS_COUNT))

    val secRemainder = secondsWeekly - (secondsDaily * workdaysWeekly)

    val weekSchedule = (1 to 7).map(x => weekDaySeconds(x, workdaysWeekly, secondsDaily, secRemainder)).toArray[Int]

    return weekSchedule
  }
  def weekDaySeconds(dayOrdinal: Int, daysOfWork: Int, secondsDaily: Int, secRemainder: Int): Int = {
    if (dayOrdinal < daysOfWork)
  {
    return secondsDaily
  }
    else if (dayOrdinal == daysOfWork)
  {
    return secondsDaily + secRemainder
  }
    return (0)
  }
  def timesheetFullSchedule(period: IPeriod, weekSchedule: Array[Int]): Array[Int] = {
    val periodDaysCount = daysInMonth(period)

    val periodBeginCwd = weekDayOfMonth(period, 1)

    val monthSchedule = (1 to periodDaysCount).map( x => secondsFromWeekSchedule(weekSchedule, x, periodBeginCwd)).toArray[Int]

    return monthSchedule
  }
  def timesheetWorkSchedule(monthSchedule: Array[Int], dayTermFrom: Int, dayTermStop: Int): Array[Int] = {
    val timeSheet = monthSchedule.zipWithIndex.map(x => hoursFromCalendar(dayTermFrom, dayTermStop, x._2, x._1)).toArray[Int]

    return timeSheet
  }
  def timesheetWorkContract(monthContract: Array[Int], monthPosition: Array[Int], dayTermFrom: Int, dayTermStop: Int): Array[Int] = {
    val idxFrom = (dayTermFrom - 1)
    val idxStop = (dayTermStop - 1)
    var zipedMonth = monthContract.zip(monthPosition)
    val result = zipedMonth.zipWithIndex.map(x => {
      var res: Int = 0
      if (x._2 >= idxFrom && x._2 <= idxStop) {
        res = (x._1._1 + x._1._2)
      }
      res
    }).toArray[Int]
    return result
  }
  def secondsFromPeriodWeekSchedule(period: IPeriod, weekSchedule: Array[Int], dayOrdinal: Int): Int = {
    val periodBeginCwd = weekDayOfMonth(period, 1)

    return secondsFromWeekSchedule(weekSchedule, dayOrdinal, periodBeginCwd)
  }
  def secondsFromWeekSchedule(weekSchedule: Array[Int], dayOrdinal: Int, periodBeginCwd: Int): Int = {
    val dayOfWeek = dayOfWeekFromOrdinal(dayOrdinal, periodBeginCwd)

    val indexWeek = (dayOfWeek - 1)

    if (indexWeek < 0 || indexWeek >= weekSchedule.length) {
      return 0
    }
    return weekSchedule(indexWeek)
  }

  def secondsFromScheduleSeq(timeTable: Array[Int], dayOrdinal: Int, dayFromOrd: Int, dayEndsOrd: Int): Int = {
    if (dayOrdinal < dayFromOrd || dayOrdinal > dayEndsOrd)
    {
      return 0
    }

    val indexTable = (dayOrdinal - dayFromOrd)

    if (indexTable < 0 || indexTable >= timeTable.length)
    {
      return 0
    }

    return timeTable(indexTable)
  }
  def scheduleBaseSubtract(template: Array[Int], subtract: Array[Int], dayFrom: Int, dayStop: Int): Array[Int] = {
    val idxFrom = (dayFrom - 1)
    val idxStop = (dayStop - 1)
    var zipedWorkAbsc = template.zip(subtract)
    val result = zipedWorkAbsc.zipWithIndex.map(x => {
      var res = 0
      if (x._2 >= idxFrom && x._2 <= idxStop) {
        res = Math.max(0, x._1._1 - x._1._2)
      }
      res
    }).toArray[Int]
    return result
  }
  def plusHoursFromCalendar(dayTermFrom: Int, dayTermStop: Int, dayIndex: Int, partSeconds: Int, workSeconds: Int): Int = {
    val dayOrdinal = (dayIndex + 1)

    var plusSeconds = workSeconds

    if (dayTermFrom > dayOrdinal) {
      plusSeconds = 0
    }
    if (dayTermStop < dayOrdinal) {
      plusSeconds = 0
    }
    return plusSeconds + partSeconds
  }
  def hoursFromCalendar(dayTermFrom: Int, dayTermStop: Int, dayIndex: Int, workSeconds: Int): Int = {
    val dayOrdinal = (dayIndex + 1)

    var workingDay = workSeconds

    if (dayTermFrom > dayOrdinal) {
      workingDay = 0
    }
    if (dayTermStop < dayOrdinal) {
      workingDay = 0
    }
    return workingDay
  }
}
