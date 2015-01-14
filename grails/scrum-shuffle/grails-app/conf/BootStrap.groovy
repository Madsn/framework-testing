import org.joda.time.LocalDateTime
import scrum.shuffle.TeamMember

class BootStrap {

    def init = { servletContext ->
		
		for (int x = 0; x < 10; x++){
			TeamMember member = new TeamMember(initials: x, name: x, lastTurn: new LocalDateTime(2000, 1, 1, 0, 0), lastSkipped: new LocalDateTime(2000, 1, 1, 0, 0))
			member.save()
			print("Added member" + member.toString())
		}
    }
    def destroy = {
    }
}
