package com.droidcon.localizationcompose.ui

import java.text.NumberFormat
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Date

fun Date.toLocalizedString(): String {
    val zonedDateTime = ZonedDateTime.ofInstant(toInstant(), ZoneId.systemDefault())

    val dateFormatter: DateTimeFormatter =
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)

    return zonedDateTime.format(dateFormatter)
}

fun Double.toLocalizedString(): String {
    return NumberFormat.getInstance().format(this)
}

fun String.toLocalizedDouble(): Double? {
    return replace(",", ".").toDoubleOrNull()
}