package lk.pasindu.oauth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lk.pasindu.oauth.modal.User;
import lk.pasindu.oauth.repository.UserDetailRrepository;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailRrepository userDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userDetailRepository.findByUsername(username);
	}

}
