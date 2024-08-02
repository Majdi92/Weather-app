package com.majdi.weather.utils

import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


fun formatDate(timestamp: Int) : String {
    val sdf = SimpleDateFormat("EEE, MMM d", Locale.getDefault())
    val date = Date(timestamp.toLong() * 1000)
    return sdf.format(date)
}
fun formatDateDay(timestamp: Double) : String {
    val sdf = SimpleDateFormat("EEE", Locale.getDefault())
    val date = Date(timestamp.toLong() * 1000)
    return sdf.format(date)
}

fun formatTime(timestamp: Int) : String {
    val sdf = SimpleDateFormat("hh:mm:aa", Locale.getDefault())
    val date = Date(timestamp.toLong() * 1000)
    return sdf.format(date)
}

fun formatDecimals(item:Double): String {
    return "%.0f".format(item)
}




