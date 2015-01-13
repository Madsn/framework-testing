package net.madsn.frameworktest.jhipster.repository;

import net.madsn.frameworktest.jhipster.domain.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the TeamMember entity.
 */
public interface TeamMemberRepository extends JpaRepository<TeamMember,Long>{

}
