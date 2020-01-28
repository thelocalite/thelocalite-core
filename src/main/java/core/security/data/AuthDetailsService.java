package core.security.data;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("vatadepalli@hotmail.com".equals(username)) {
			return new User("vatadepalli@hotmail.com", "$2y$12$zdS8obL2KEjfvrEfUQMmAOt.VxWASbYjz9CTjuwW1qyCJN/WENaVy",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}