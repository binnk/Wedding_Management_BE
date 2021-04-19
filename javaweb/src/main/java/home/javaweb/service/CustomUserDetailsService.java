package home.javaweb.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import home.javaweb.dto.MyUser;
import home.javaweb.entity.RoleEntity;
import home.javaweb.entity.UserEntity;
import home.javaweb.repository.UserRepository;





@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username);
		
		if(userEntity == null)
			throw new UsernameNotFoundException("User not found");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity roleEntity: userEntity.getRoles())
			authorities.add(new SimpleGrantedAuthority(roleEntity.getCode()));
		
		MyUser  myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(), true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullname());
		return myUser;
	}
	
}
