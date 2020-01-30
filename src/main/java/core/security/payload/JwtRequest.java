package core.security.payload;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class JwtRequest implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

	public JwtRequest(String username, String password) {
		this.setEmail(username);
		this.setPassword(password);
	}
}