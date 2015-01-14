package net.madsn.frameworktest.jhipster.repository;

import net.madsn.frameworktest.jhipster.domain.TeamMember;

/**
 * Spring Data JPA repository for the TeamMember entity.
 */
public interface TeamMemberRepositoryCustom {

	TeamMember getRandom();

	TeamMember next();
}
