package models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.utils.dao.BasicModel;

@Entity
@SuppressWarnings("serial")
public class Member extends Model implements BasicModel<Long> {

	@Id
	private Long key;

	@Basic
	@Required
	private String name;

	@Basic
	@Required
	private String initials;

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials.toUpperCase();
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return key + " - " + initials + " - " + name;
	}

	public static Finder<Long, Member> find = new Finder<Long, Member>(Long.class, Member.class);

	public static void create(Member member) {
		member.save();
	}
}
