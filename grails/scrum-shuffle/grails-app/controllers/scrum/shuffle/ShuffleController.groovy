package scrum.shuffle



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ShuffleController {
	
	TeamMemberService teamMemberService

    static allowedMethods = [cycle: "POST", skip: "POST"]

    def index() {
		def nextMember = teamMemberService.random()
		respond TeamMember.list(), model:[teamMemberInstanceCount: TeamMember.count(), randomMember: nextMember]
    }
	
	def cycleNext(){
		def nextMember = teamMemberService.cycleNext()
		render(view: "index", model:[nextMember: nextMember, teamMemberInstanceCount: TeamMember.count(), teamMemberInstanceList: TeamMember.list()])
	}
	
	def skip(){
		def nextMember = teamMemberService.skip()
		render(view: "index", model:[nextMember: nextMember, teamMemberInstanceCount: TeamMember.count(), teamMemberInstanceList: TeamMember.list()])
	}
	
	def random(){
		TeamMember currentRandom = null
		if (params.currentRandomId.isLong()){
			currentRandom = TeamMember.get(params.currentRandomId.toLong())
		}
		def nextMember = teamMemberService.random(currentRandom)
		render(view: "index", model:[teamMemberInstanceCount: TeamMember.count(), randomMember: nextMember, teamMemberInstanceList: TeamMember.list()])
	}
	
}
