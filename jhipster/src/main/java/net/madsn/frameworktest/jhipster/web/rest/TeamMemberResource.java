package net.madsn.frameworktest.jhipster.web.rest;

import com.codahale.metrics.annotation.Timed;
import net.madsn.frameworktest.jhipster.domain.TeamMember;
import net.madsn.frameworktest.jhipster.repository.TeamMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing TeamMember.
 */
@RestController
@RequestMapping("/api")
public class TeamMemberResource {

    private final Logger log = LoggerFactory.getLogger(TeamMemberResource.class);

    @Inject
    private TeamMemberRepository teamMemberRepository;

    /**
     * POST  /teamMembers -> Create a new teamMember.
     */
    @RequestMapping(value = "/teamMembers",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public TeamMember create(@RequestBody TeamMember teamMember) {
        log.debug("REST request to save TeamMember : {}", teamMember);
        TeamMember saved = teamMemberRepository.save(teamMember);
        return saved;
    }

    /**
     * GET  /teamMembers -> get all the teamMembers.
     */
    @RequestMapping(value = "/teamMembers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<TeamMember> getAll() {
        log.debug("REST request to get all TeamMembers");
        return teamMemberRepository.findAll();
    }

    /**
     * GET  /teamMembers/:id -> get the "id" teamMember.
     */
    @RequestMapping(value = "/teamMembers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<TeamMember> get(@PathVariable Long id) {
        log.debug("REST request to get TeamMember : {}", id);
        return Optional.ofNullable(teamMemberRepository.findOne(id))
            .map(teamMember -> new ResponseEntity<>(
                teamMember,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /teamMembers/:id -> delete the "id" teamMember.
     */
    @RequestMapping(value = "/teamMembers/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete TeamMember : {}", id);
        teamMemberRepository.delete(id);
    }
    
    /**
     * Cycle  /teamMembers -> get the next teamMember in cycle
     */
    @RequestMapping(value = "/teamMembers/cycle",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public TeamMember next() {
        log.debug("REST request to get next TeamMember in cycle");
        return teamMemberRepository.findAll().get(0);
    }
}
