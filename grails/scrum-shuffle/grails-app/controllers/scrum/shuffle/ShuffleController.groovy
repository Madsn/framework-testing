package scrum.shuffle



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ShuffleController {
	
	def teamMemberService

    static allowedMethods = [cycle: "POST", skip: "POST"]

    def index() {
		def nextMember = teamMemberService.random()
		respond TeamMember.list(), model:[teamMemberInstanceCount: TeamMember.count(), randomMember: nextMember]
    }
	
	def cycle(){
		print("Cycling....")
		redirect(action: "index")
	}
	
	def skip(){
		print("Skipping...")
		redirect(action: "index")
	}
	
	def random(){
		TeamMember currentRandom = null
		if (params.currentRandomId.isLong()){
			currentRandom = TeamMember.get(params.currentRandomId.toLong())
		}
		def nextMember = teamMemberService.random(currentRandom)
		def instanceCount = TeamMember.count()
		render(view: "index", model:[teamMemberInstanceCount: instanceCount, randomMember: nextMember, teamMemberInstanceList: TeamMember.list()])
	}
	
}
