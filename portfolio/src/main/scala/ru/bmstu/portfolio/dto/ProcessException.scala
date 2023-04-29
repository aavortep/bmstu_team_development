package ru.bmstu.portfolio.dto

sealed class ProcessException(s: String) extends RuntimeException(s) {}

class EmptyOptionException(s: String) extends ProcessException(s) {}