package controllers;

import models.Member;
import play.mvc.Controller;
import play.mvc.Result;

public class Members extends Controller {

	public static Result list() {
		Member member = new Member();
		member.setInitials("MIKMA");
		member.setName("Mikkel Madsen");
		member.save();
		return ok(views.html.Members.list.render(Member.find.all()));
	}

	public static Result get(Long id) {
		return ok(views.html.index.render());
	}
	
	public static Result update(Long id) {
		return ok(views.html.index.render());
	}
	
	public static Result put() {
		return ok(views.html.index.render());
	}
	
	public static Result delete(Long id) {
		return ok(views.html.index.render());
	}
}