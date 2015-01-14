package scrum.shuffle

import org.joda.time.LocalDateTime

class TeamMember {

	String initials;
	String name;
	LocalDateTime lastTurn = new LocalDateTime(1970, 1, 1, 0, 0)
	LocalDateTime lastSkipped = new LocalDateTime(1970, 1, 1, 0, 0)
	
    static constraints = {
    }
}
