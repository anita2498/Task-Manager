
package com.hcl.model.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L; // private User user;
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;

	public UserPrincipal(User user) { // super(); // this.user = user;
		this.userName = user.getUsername();
		this.password = user.getPwd();
		this.authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;

		// return Collections.singleton(new SimpleGrantedAuthority("USER"));

	}

	@Override
	public String getPassword() { // TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() { // TODO Auto-generated method stub
		return userName;
	}

	@Override public boolean isAccountNonExpired() { // TODO Auto-generatemethod stub 
		return true; }


	@Override public boolean isAccountNonLocked() { // TODO Auto-generated method stub 
		return true; }

	@Override public boolean isCredentialsNonExpired() { // TODO Auto-generatedmethod stub 
		return true; }

	@Override
	public boolean isEnabled() { // TODO Auto-generated method stub
		return true;
	}

}
