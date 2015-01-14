package net.madsn.frameworktest.jhipster.web.rest;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import net.madsn.frameworktest.jhipster.domain.TeamMember;
import net.madsn.frameworktest.jhipster.repository.TeamMemberRepository;
import net.madsn.frameworktest.jhipster.security.AuthoritiesConstants;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

/**
 * REST controller for managing TeamMember.
 */
@RestController
@RequestMapping("/api")
public class TeamMemberResource {

    private final Logger log = LoggerFactory.getLogger(TeamMemberResource.class);

    @Inject
    private TeamMemberRepository repository;
    
    /**
     * POST  /teamMembers -> Create a new teamMember.
     */
    @RequestMapping(value = "/teamMembers",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public TeamMember create(@RequestBody TeamMember teamMember) {
        log.debug("REST request to save TeamMember : {}", teamMember);
        TeamMember saved = repository.save(teamMember);
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
        return repository.findAll();
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
        return Optional.ofNullable(repository.findOne(id))
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
        repository.delete(id);
    }
    
    /**
     * Cycle  /teamMembers -> get the next teamMember in cycle
     */
    @RequestMapping(value = "/teamMembers/cycle/next",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public TeamMember cycle() {
        log.debug("REST request to progress the cycle and get next TeamMember");
        TeamMember member = repository.next();
        if (member == null) {
        	return repository.getRandom();
        }
        member.setLastTurn(LocalDateTime.now());
        repository.save(member);
        return repository.next();
    }
    
    /**
     * Cycle  /teamMembers -> get the next teamMember in cycle, without anybody taking a turn
     */
    @RequestMapping(value = "/teamMembers/cycle",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public TeamMember next() {
        log.debug("REST request to get next TeamMember in cycle");
        TeamMember member = repository.next();
        if (member == null){
        	return repository.getRandom();
        }
        return member;
    }
    
    /**
     * Cycle  /teamMembers -> get the next teamMember in cycle
     */
    @RequestMapping(value = "/teamMembers/cycle/skip",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public TeamMember skip() {
        log.debug("REST request to get next TeamMember in cycle");
        TeamMember member = repository.next();
        member.setSkipped(LocalDateTime.now());
        repository.save(member);
        return repository.next();
    }
}
