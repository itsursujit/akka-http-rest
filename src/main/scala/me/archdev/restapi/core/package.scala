package me.archdev.restapi

package object core {

  type UserId = String
  type AuthToken = String

  final case class AuthTokenContent(userId: UserId)

  final case class AuthData(id: Option[Long], username: String, email: String, password: String, uuid: UserId) {
    require(uuid.nonEmpty, "id.empty")
    require(username.nonEmpty, "username.empty")
    require(email.nonEmpty, "email.empty")
    require(password.nonEmpty, "password.empty")
  }

  final case class UserProfile(id: Option[Long], firstName: String, lastName: String, uuid: UserId) {
    require(uuid.toString.nonEmpty, "firstName.empty")
    require(firstName.nonEmpty, "firstName.empty")
    require(lastName.nonEmpty, "lastName.empty")
  }

  final case class UserProfileUpdate(firstName: Option[String] = None, lastName: Option[String] = None, uuid: String) {
    def merge(profile: UserProfile): UserProfile = {
      UserProfile(profile.id, firstName.getOrElse(profile.firstName), lastName.getOrElse(profile.lastName), profile.uuid)
    }
  }

}
