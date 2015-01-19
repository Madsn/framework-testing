package models

import play.api.db.slick.Profile

import scala.slick.ast.{Symbol, Node}
import scala.slick.lifted

case class Member(name: String, initials: String)

trait MemberComponent {
  this: Profile =>
  //<- step 1: you must add this "self-type"

  import profile.simple._

  //<- step 2: then import the correct Table, ... from the profile

  class MembersTable(tag: Tag) extends Table[Member](tag, "MEMBER") {

    def name = column[String]("name", O.PrimaryKey)

    def initials = column[String]("initials", O.NotNull)

    def * = (name, initials) <>(Member.tupled, Member.unapply _)

  }

}