package ru.bmstu.portfolio.db

import java.sql.{Connection, DriverManager, ResultSet}

object Database {
  val driver = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost:5432/postgres?user=postgres"
  val username = "postgres"
  val password = "123"
  Class.forName(driver) // Load the driver
  val conn = DriverManager.getConnection(url, username, password) // Make the connection

  def execute(query: String): Unit = {
    try {
      val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

      val rs = stm.executeQuery(query)

      while (rs.next) {
        println(rs.getString("quote"))
      }
    } finally {
      conn.close()
    }
  }
}
