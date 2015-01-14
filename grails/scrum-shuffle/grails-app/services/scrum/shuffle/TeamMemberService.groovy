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
		def m = getNext()
		if (m == null) return getNext()
		def now = new LocalDateTime().now()
		m.setLastTurn(now)
		m.save(flush: true, failOnError: true)
		return getNext()
	}
	
	private TeamMember getNext(){
		def skipBuffer = new LocalDateTime().now().minusSeconds(60)
		def query = TeamMember.where{
			lastSkipped < skipBuffer
		}
		def member = query.list(sort: "lastTurn", order: "ASC", max: 50) 
		print member.size()
		if (member.size() > 0){
			return member.get(0)
		}
		return null
	}
	
	public TeamMember skip(){
		TeamMember nextMember = getNext()
		if (m == null) return getNext()
		nextMember.setLastSkipped(new LocalDateTime().now())
		nextMember.save(flush: true, failOnError: true)
		return getNext()
	}
}
