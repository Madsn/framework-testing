package scrum.shuffle

import grails.transaction.Transactional
import org.joda.time.LocalDateTime

@Transactional
class TeamMemberService {
	
	public TeamMember random(TeamMember prev){
		def member = null
		if (prev == null){
			member = TeamMember.executeQuery("from TeamMember order by rand()", [max: 1])
		} else {
			member = TeamMember.executeQuery("select m from TeamMember as m where m.id != " + prev.id + " order by rand()", [max: 1])
		}
		if (member.size() > 0){
			return member.get(0)
		}
		return new TeamMember()
	}
	
	public TeamMember cycleNext(){
		print("This is cyclenext")
		def member = TeamMember.find(sort: "lastTurn", order:"asc", max:1)
		if (member.count > 0){
			return member.get(0)
		}
		return new TeamMember()
	}
	
	public TeamMember skip(){
		TeamMember nextMember = cycleNext()
		nextMember.setLastSkipped(new LocalDateTime().now())
		nextMember.save()
		return cycleNext()
	}
}
