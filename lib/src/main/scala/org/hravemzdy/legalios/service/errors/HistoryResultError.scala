package org.hravemzdy.legalios.service.errors

sealed trait HistoryResultError {val message: String}

object HistoryResultError {
  case object BundleNoneError extends HistoryResultError {val message = "service hasn't returned bundle"}
  case object BundleNullError extends HistoryResultError {val message = "service returned null bundle"}
  case object BundleEmptyError extends HistoryResultError {val message = "service returned empty bundle"}
  case object BundleInvalidError extends HistoryResultError {val message = "service returned invalid bundle"}
}