package controllers;

import models.Member;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Members extends Controller {

	public static Result list() {
		return ok(views.html.Members.list.render(Member.find.all()));
	}

	public static Result get(Long id) {
		return ok(views.html.index.render());
	}
	
	public static Result add() {
		Member m = new Member();
		m.setName("Mikkel Madsen");
		m.setInitials("MIKMA");
		m.save();
		return ok(views.html.Members.list.render(Member.find.all()));
	}
	
	public static Result edit(Long id){
		Member member = Member.find.byId(id);
		Form<Member> memberForm = Form.form(Member.class);
		return ok(views.html.Members.edit.render(memberForm, member));
	}
	
	public static Result update() {
		Form<Member> memberForm = Form.form(Member.class);
		Form<Member> filledForm = memberForm.bindFromRequest();
		Member m = filledForm.get();
		System.out.println(m);
		m.update();
		return ok(views.html.index.render());
	}
	
	public static Result put() {
		return ok(views.html.index.render());
	}
	
	public static Result delete(Long id) {
		return ok(views.html.index.render());
	}
}