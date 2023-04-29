package ru.bmstu.portfolio.dto

sealed class ProcessException(s: String) extends RuntimeException(s) {}
