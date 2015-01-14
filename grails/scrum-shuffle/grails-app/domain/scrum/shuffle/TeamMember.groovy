package scrum.shuffle

import org.joda.time.LocalDateTime

class TeamMember {

	String initials;
	String name;
	LocalDateTime lastTurn
	LocalDateTime lastSkipped
	
	public TeamMember(String initials, String name){
		this.initials = initials
		this.name = name
		def x = new LocalDateTime(2000, 1, 1, 0, 0)
		lastTurn = x
		lastSkipped = x
	}
	
    static constraints = {
    }
}
