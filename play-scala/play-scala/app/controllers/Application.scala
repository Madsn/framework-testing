package controllers

import models._
import play.api._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.Play.current
import play.api.mvc.BodyParsers._
import play.api.libs.json.Json
import play.api.libs.json.Json._

//stable imports to use play.api.Play.current outside of objects:

object Application extends Controller {

  val Members = TableQuery[MembersTable]

  val memberForm = Form(
    mapping(
      "name" -> text(),
      "initials" -> text()
    )(Member.apply)(Member.unapply)
  )

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def members = DBAction { implicit rs =>
    Ok(views.html.members(Members.list))
  }

  def memberAdd = DBAction { implicit rs =>
    val member = new Member("Mikkel", "MIKMA")
    Members.insert(member)
    Redirect(routes.Application.members)
  }

  def memberModify(id: Long) = Action {
    Ok("TODO")
  }

  def memberDelete(id: Long) = Action {
    Ok("TODO")
  }

}