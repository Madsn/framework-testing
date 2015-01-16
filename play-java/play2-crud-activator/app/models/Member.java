package models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

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

	@DateTimeFormat
	private DateTime lastTurn;

	@DateTimeFormat
	private DateTime lastSkipped;

	public DateTime getLastSkipped() {
		return lastSkipped;
	}

	public void setLastSkipped(DateTime lastSkipped) {
		this.lastSkipped = lastSkipped;
	}

	public DateTime getLastTurn() {
		return lastTurn;
	}

	public void setLastTurn(DateTime lastTurn) {
		this.lastTurn = lastTurn;
	}

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
		return "Member [key=" + key + ", name=" + name + "]";
	}

	public static Finder<Long, Member> find = new Finder<Long, Member>(Long.class, Member.class);
}
