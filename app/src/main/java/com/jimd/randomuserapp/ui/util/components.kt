package com.jimd.randomuserapp.ui.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Converts a date string from ISO 8601 format to a custom, readable format.
 *
 * @param isoDateString The input date string in ISO 8601 format (e.g., "2007-02-17T19:52:34.751Z").
 * @param outputLocale The locale to use for formatting the output string (e.g., month name).
 *                     Defaults to English.
 * @return A formatted date string (e.g., "February 17, 2007") or null if parsing fails.
 */
@RequiresApi(Build.VERSION_CODES.O)
fun formatIsoDateString(isoDateString: String, outputLocale: Locale = Locale.ENGLISH): String? {
    return try {
        val zonedDateTime = ZonedDateTime.parse(isoDateString)
        val outputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", outputLocale)
        zonedDateTime.format(outputFormatter)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}