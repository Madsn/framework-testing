package net.madsn.frameworktest.jhipster.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.LocalDateTime;

/**
 * A TeamMember.
 */
@Entity
@Table(name = "T_TEAMMEMBER")
@NamedQueries({
		@NamedQuery(name = TeamMember.GET_NEXT_IN_CYCLE, query = "select t from TeamMember t "
				+ "where t.skipped > :skip order by t.lastTurn ASC"),
		@NamedQuery(name = TeamMember.GET_RANDOM, query = "SELECT t FROM TeamMember t ORDER BY random()")
})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TeamMember implements Serializable {

	public static final String GET_NEXT_IN_CYCLE = "TeamMember.getNextInCycle";

	public static final String GET_RANDOM = "TeamMember.getRandom";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "initials")
	private String initials;

	@Column(name = "name")
	private String name;

	@Column(name = "last_turn", nullable = true)
	private LocalDateTime lastTurn;

	@Column(name = "skipped", nullable = true)
	private LocalDateTime skipped;

	public LocalDateTime getSkipped() {
		return skipped;
	}

	public void setSkipped(LocalDateTime skipped) {
		this.skipped = skipped;
	}

	public LocalDateTime getLastTurn() {
		return lastTurn;
	}

	public void setLastTurn(LocalDateTime lastTurn) {
		this.lastTurn = lastTurn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TeamMember teamMember = (TeamMember) o;

		if (id != null ? !id.equals(teamMember.id) : teamMember.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	@Override
	public String toString() {
		return "TeamMember{" + "id=" + id + ", initials='" + initials + "'"
				+ ", name='" + name + "'" + '}';
	}
}
