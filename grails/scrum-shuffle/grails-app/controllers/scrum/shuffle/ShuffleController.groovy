package scrum.shuffle



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ShuffleController {

    static allowedMethods = [cycle: "POST", skip: "POST"]

    def index() {
		respond TeamMember.list(), model:[teamMemberInstanceCount: TeamMember.count(), nextMember: next()]
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
		print("Random...")
		redirect(action: "index")
	}
	
	private TeamMember next(){
		// TODO
		return TeamMember.list().get(0)
	}
}
