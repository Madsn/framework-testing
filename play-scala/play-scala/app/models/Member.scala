package models

import play.api.db.slick.Config.driver.simple._

case class Member(name: String, initials: String)

class MembersTable(tag: Tag) extends Table[Member](tag, "MEMBER") {

  def name = column[String]("name", O.NotNull)

  def initials = column[String]("initials", O.PrimaryKey)

  def * = (name, initials) <>(Member.tupled, Member.unapply _)

}

