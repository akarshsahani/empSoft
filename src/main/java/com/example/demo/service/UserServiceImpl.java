package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{
	
	public String email;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void registerDefaultUser(User user) {
        Role roleUser = roleRepository.findByRoleName("USER");
        user.addRole(roleUser);
 
        userRepository.save(user);
    }
	
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		User user = new User( 
				userRegistrationDto.getUserEmail(),
				passwordEncoder.encode(userRegistrationDto.getUserPassword()),
				userRegistrationDto.getUserFirstName(),
				userRegistrationDto.getUserLastName(),
				userRegistrationDto.getUserGender(),
				userRegistrationDto.getUserAge(),
				userRegistrationDto.getUserPhoneNumber(),
				userRegistrationDto.getUserAddress(), null
				
//				Arrays.asList( roleRepository.findByRoleName("ROLE_USER"))
				
	//			Arrays.asList(new Role("ROLE_USER"))
				);
		userRepository.save(user);
		registerDefaultUser(user);
		return userRepository.save(user);
	}
	
	public List<User> listAll() {
	    return userRepository.findAll();
	}
	
	public User get(Long id) {
	    return userRepository.findById(id).get();
	}
	 
	public List<Role> listRoles() {
	    return roleRepository.findAll();
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserEmail(username);
		System.out.println(user);
		System.out.println("username is : " + username);
		email=username;
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		System.out.println("user demail from user's is:" + user.getUserEmail());
		System.out.println("user granted authorities are: " + mapRolesToAuthorities(user.getRoles()));
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName())).collect(Collectors.toList());
	
	}

}
