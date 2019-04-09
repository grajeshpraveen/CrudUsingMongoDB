package guru.springframework.authentiation;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * <h1>CustomAuthenticationProvider</h1>
 * <p>
 * This class is used to authenticate id and password from the YAML
 * configuration and provides the access for the resource.
 * </p>
 * 
 * @version 0.1
 * @since 18 July ,2017
 * */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {  
	/**
	 * AuthenticationConfigProperties
	 */
	@Autowired
	private AuthenticationConfigProperties authenticationConfigProperties;

	/**
	 * This method is called by the spring boot to authenticate the user when
	 * resource is requested
	 * 
	 * @param authentication
	 *            Authentication object
	 * 
	 * @return Authentication Authentication object
	 * @throws AuthenticationException
	 *             AuthenticationException object
	 */
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		// This condition returns true if the both conditions are satisfied
		if (authenticationConfigProperties.getId().equals(username)
				&& authenticationConfigProperties.getPassword()
						.equals(password)) { 

			/**
			 * This constructor should only be used by AuthenticationManager or
			 * AuthenticationProvider implementations that are satisfied with
			 * producing a trusted (i.e. isAuthenticated() = true)
			 * authentication token
			 */
			return new UsernamePasswordAuthenticationToken(username, password,
					Collections.emptyList());
		} else {
 
			// It Constructs a BadCredentialsException with the specified
			// message.
			throw new BadCredentialsException("unauthorized");
		}
	}

	/**
	 * This class is called by the spring boot for authenticating user id and
	 * password
	 * 
	 * @param authClass
	 *            String object
	 * @return boolean value
	 * 
	 * 
	 */
	@Override
	public boolean supports(Class<?> authClass) {
		// It returns boolean value
		return authClass.equals(UsernamePasswordAuthenticationToken.class);
	}
}