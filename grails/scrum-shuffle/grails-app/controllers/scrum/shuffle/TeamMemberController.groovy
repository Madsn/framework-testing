package scrum.shuffle



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TeamMemberController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TeamMember.list(params), model:[teamMemberInstanceCount: TeamMember.count()]
    }

    def show(TeamMember teamMemberInstance) {
        respond teamMemberInstance
    }

    def create() {
        respond new TeamMember(params)
    }

    @Transactional
    def save(TeamMember teamMemberInstance) {
        if (teamMemberInstance == null) {
            notFound()
            return
        }

        if (teamMemberInstance.hasErrors()) {
            respond teamMemberInstance.errors, view:'create'
            return
        }

        teamMemberInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'teamMember.label', default: 'TeamMember'), teamMemberInstance.id])
                redirect teamMemberInstance
            }
            '*' { respond teamMemberInstance, [status: CREATED] }
        }
    }

    def edit(TeamMember teamMemberInstance) {
        respond teamMemberInstance
    }

    @Transactional
    def update(TeamMember teamMemberInstance) {
        if (teamMemberInstance == null) {
            notFound()
            return
        }

        if (teamMemberInstance.hasErrors()) {
            respond teamMemberInstance.errors, view:'edit'
            return
        }

        teamMemberInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TeamMember.label', default: 'TeamMember'), teamMemberInstance.id])
                redirect teamMemberInstance
            }
            '*'{ respond teamMemberInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TeamMember teamMemberInstance) {

        if (teamMemberInstance == null) {
            notFound()
            return
        }

        teamMemberInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TeamMember.label', default: 'TeamMember'), teamMemberInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'teamMember.label', default: 'TeamMember'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
