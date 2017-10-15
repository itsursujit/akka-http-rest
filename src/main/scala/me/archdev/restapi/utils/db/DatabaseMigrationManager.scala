package me.archdev.restapi.utils.db

import org.flywaydb.core.Flyway
import org.flywaydb.core.api.FlywayException

class DatabaseMigrationManager(jdbcUrl: String, dbUser: String, dbPassword: String) {

  private val flyway = new Flyway()
  flyway.setDataSource(jdbcUrl, dbUser, dbPassword)

  flyway.setBaselineOnMigrate(true)

  def migrateDatabaseSchema() : Unit = {
    try {
      flyway.migrate()
    } catch {
      case e:FlywayException =>
        flyway.repair()
        flyway.migrate()
    }
  }

  def dropDatabase() : Unit = flyway.clean()

}
