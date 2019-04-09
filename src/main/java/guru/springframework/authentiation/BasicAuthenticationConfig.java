package guru.springframework.authentiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * This Class is responsible to Authenticate the application using Spring Security Basic Authentication
 */

/**
 * <h1>BasicAuthenticationConfig</h1>
 * <p>
 * This Class is responsible to Authenticate the application using Spring
 * Security Basic Authentication
 * </p>
 * 
 * @version 0.1
 * @since 20 May,2017
 */
@Component
@EnableWebSecurity
public class BasicAuthenticationConfig extends WebSecurityConfigurerAdapter {

	/**
	 * CustomAuthenticationProvider
	 */
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	/**
	 * This method is called by the spring boot application for authenticating the
	 * id and password
	 * 
	 * @param authenticationManagerBuilder
	 *            AuthenticationManagerBuilder Object
	 * 
	 * @throws Exception
	 *             exception object
	 */
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder.eraseCredentials(false).authenticationProvider(customAuthenticationProvider);
	}

	/**
	 * This method is called by the Spring boot for configuring HttpSecurity
	 * 
	 * @param httpSecurity
	 *            HttpSecurity Object
	 * 
	 *            * @throws Exception exception object
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// This method is used to Allows restricting access based upon the
		// HttpServletRequest
		httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated();
		// This method is used to Configures HTTP Basic authentication
		httpSecurity.httpBasic();
		/**
		 * Adds CSRF support. This is activated by default when using
		 * WebSecurityConfigurerAdapter's default constructor. You can disable it
		 */
		httpSecurity.csrf().disable();
	}

}
