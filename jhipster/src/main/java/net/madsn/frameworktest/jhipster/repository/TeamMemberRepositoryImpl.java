package net.madsn.frameworktest.jhipster.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.madsn.frameworktest.jhipster.domain.TeamMember;

import org.joda.time.LocalDateTime;

/**
 * Spring Data JPA repository for the TeamMember entity.
 */
public class TeamMemberRepositoryImpl implements TeamMemberRepositoryCustom {
	
	public static int SKIP_BUFFER_IN_MS = 0;
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public TeamMember next() {
		TypedQuery<TeamMember> query = entityManager.createNamedQuery(TeamMember.GET_NEXT_IN_CYCLE, TeamMember.class);
		query.setParameter("skip", LocalDateTime.now().minusMillis(SKIP_BUFFER_IN_MS)).setMaxResults(1);
		try {
			return query.getSingleResult();
		} catch (NoResultException e){
			return null;
		}
	}

	@Override
	public TeamMember getRandom() {
		TypedQuery<TeamMember> query = entityManager.createNamedQuery(TeamMember.GET_RANDOM, TeamMember.class);
		query.setMaxResults(1);
		try {
			return query.getSingleResult();
		} catch (NoResultException e){
			return null;
		}
	}
}
