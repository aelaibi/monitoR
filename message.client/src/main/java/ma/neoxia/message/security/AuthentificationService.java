package ma.neoxia.message.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class AuthentificationService implements UserDetailsService {
	
	protected static Logger logger = LoggerFactory.getLogger(AuthentificationService.class);

//	@Autowired
//	RoleDao userDao;

	public AuthentificationService() {
		super();
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		MessageUserDetails user = new MessageUserDetails();
		user.setUsername( "test" );
		user.setPassword( "098f6bcd4621d373cade4e832627b4f6" );

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		user.setAuthorities(authList);
		
		//throw new UsernameNotFoundException("Error in retrieving user");
		
		return user;
	}
}
