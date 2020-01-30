package core.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.security.data.AuthService;
import core.security.utils.JwtTokenUtil;
import core.security.payload.JwtRequest;
import core.security.payload.JwtResponse;

/**
 * Expose a POST API /authenticate.
 * The POST API gets username and password in the body/
 * Using Spring Authentication Manager we authenticate the username and password.
 * If the credentials are valid, a JWT token is created using the JWTTokenUtil 
 * and provided to the client.
 * 
 * Note: This controller is not being used, as we are authenticating from NodeJS
 */

@RestController
@CrossOrigin
public class JwtAuth {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("****** GET: /authenticate");
		System.out.println(authenticationRequest.getUsername());
		System.out.println(authenticationRequest.getPassword());

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
				
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		System.out.println("****** Autenticating *********");
		System.out.println(username);
		System.out.println(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}