package au.edu.qcif.xnat.auth.openid;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.nrg.xdat.entities.UserAuthI;
import org.nrg.xdat.security.XDATUser;
import org.nrg.xft.exception.MetaDataException;
import org.nrg.xft.security.UserI;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OpenIdConnectUserDetails extends XDATUser {

	private static final long serialVersionUID = 1L;
	private OAuth2AccessToken token;
	private String email;
	private Map<String, String> openIdUserInfo;
	private String name;
	private String picture;
	private String firstName;
	private String lastName;
	private String pw;
	private String username;
	private String providerId;

	public OpenIdConnectUserDetails(String providerId, Map<String, String> userInfo, OAuth2AccessToken token) {
		this.openIdUserInfo = userInfo;
		this.providerId = providerId;
		this.setUsername(providerId + "_" + userInfo.get("sub"));
		// this.username = userInfo.get("email");
		this.token = token;
		this.email = userInfo.get("email");
		this.setFirstname(userInfo.get("given_name"));
		this.setLastname(userInfo.get("family_name"));
		this.name = userInfo.get("name");
		this.picture = userInfo.get("picture");
	}

	public OAuth2AccessToken getToken() {
		return token;
	}

	public void setToken(OAuth2AccessToken token) {
		this.token = token;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

}
