package core.security.data;

/**
 * This is the service layer for Spring security module.
 * Primarily used to fetch user details from a database.
 * 
 * It overrides the loadUserByUsername for fetching user details from the database using the username.
 * 
 * Load user by username should return a valid username (in our case email),
 * 		without which the JWT token check will fail
 */

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import core.exception.ResourceNotFoundException;
import core.security.models.Auth;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
    AuthRepository authRepository;

	@Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    	// Login with email
        Auth auth = authRepository.findByUsername(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + email)
        );

        return auth;
	}
	
	@Transactional
    public UserDetails loadUserById(Long id) {
        Auth auth = authRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return auth;
    }
}