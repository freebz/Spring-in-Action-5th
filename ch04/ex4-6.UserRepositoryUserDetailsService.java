// Listing 4.6  Defining a custom user details service

package tacos.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.
                                              UserdetailsService;
import org.springframework.security.core.userdetails.
                                       UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tacos.User;
import tacos.data.UserRepository;

@Service
public class UserRepositoryUserDetailsService
        implements UserDetailsService {
    
    private UserRepository userRepo;
    
    @Autowired
    public UserRepositoryUserDetailService(UserRepository userRepo) {
      this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException {
	User user = userRepo.findByUsername(username);
	if (user != null) {
	    return user;
	}
	throw new UsernameNotFoundException(
	    "User '" + username + "' not found");
    }

}
