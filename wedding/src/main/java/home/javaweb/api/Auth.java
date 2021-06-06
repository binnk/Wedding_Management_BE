package home.javaweb.api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.common.ERole;
import home.javaweb.common.JwtUtils;
import home.javaweb.dto.JwtResponse;
import home.javaweb.dto.LoginRequest;
import home.javaweb.dto.MessageResponse;
import home.javaweb.dto.SignupRequest;
import home.javaweb.entity.RoleEntity;
import home.javaweb.entity.UserEntity;
import home.javaweb.repository.RoleRepository;
import home.javaweb.repository.UserRepository;
import home.javaweb.service.impl.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class Auth {
  
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
   
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
						 loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);;

		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		if(userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
		if(userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Email is already use!"));
		}
		UserEntity user = new UserEntity(signUpRequest.getUsername(),
				                         encoder.encode(signUpRequest.getPassword()),
				        		         signUpRequest.getEmail(),
				        		         signUpRequest.getFullname(),
				        		         signUpRequest.getBirthday());
		Set<String> strRoles = signUpRequest.getRole();
		Set<RoleEntity> roles = new HashSet<>();
		if(strRoles == null) {
			RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
					                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);                   
		} else {
			strRoles.forEach(role -> {
				switch(role) {
				case "admin":
					RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					                               .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "mod":
					RoleEntity modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				default:
					RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
                    									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);   
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("user regisered successfully!"));
	}
	
}
