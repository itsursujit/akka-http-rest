package me.archdev.restapi.core.profiles

import me.archdev.restapi.core.UserProfile
import me.archdev.restapi.utils.db.DatabaseConnector

private[profiles] trait UserProfileTable {

  protected val databaseConnector: DatabaseConnector
  import databaseConnector.profile.api._

  class Profiles(tag: Tag) extends Table[UserProfile](tag, "profiles") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def firstName = column[String]("first_name")
    def lastName = column[String]("last_name")
    def uuid = column[String]("uuid")

    def * = (id, firstName, lastName, uuid) <> ((UserProfile.apply _).tupled, UserProfile.unapply)
  }

  protected val profiles = TableQuery[Profiles]

}
