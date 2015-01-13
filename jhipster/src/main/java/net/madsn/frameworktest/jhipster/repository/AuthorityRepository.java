package net.madsn.frameworktest.jhipster.repository;

import net.madsn.frameworktest.jhipster.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
