package core.security.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import core.security.models.Auth;

/**
 * AuthRepository
 */
@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {

    Optional<Auth> findByUsername(String email);

    Boolean existsByUsername(String email);
}