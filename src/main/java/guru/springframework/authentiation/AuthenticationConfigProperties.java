package guru.springframework.authentiation;

import java.util.Base64;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <h1>AuthenticationConfigProperties</h1>
 * <p>
 * This class is used to map properties inside the yaml file to member variables
 * declared inside this class.
 * </p>
 * 
 * @version 0.1
 * @since 18 July ,2017
 * */
@Component
@ConfigurationProperties(prefix = "authentication")
public class AuthenticationConfigProperties {

	private String id;
	private String password;

	/**
	 * @return id String object
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            String object
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return password String decoded object
	 */
	public String getPassword() {
		byte[] decodedBytes = Base64.getDecoder().decode(password);
		return new String(decodedBytes);
	}

	/**
	 * @param password
	 *            String object
	 * 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
