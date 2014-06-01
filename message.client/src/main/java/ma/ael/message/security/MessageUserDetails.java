package ma.ael.message.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MessageUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5829448413488366902L;
	
	private Collection<GrantedAuthority> authorities;
	private String username;
	private String password;
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
		
	}
}