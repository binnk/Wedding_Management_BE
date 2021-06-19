package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.config.sercurity.AuthRequest;
import home.javaweb.config.sercurity.AuthResponse;
import home.javaweb.config.sercurity.JwtOutils;
import home.javaweb.config.sercurity.MyBCryptPasswordEncoder;
import home.javaweb.entity.User;
import home.javaweb.entity.UserRequest;
import home.javaweb.repository.UserRepository;
import home.javaweb.service.SecurityServices;
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserAuth {

    private home.javaweb.repository.UserRepository UserRepository;
    private MyBCryptPasswordEncoder myBCryptPasswordEncoder;
    @Autowired
    private home.javaweb.repository.UserRepository userRepository;
    @Autowired
    private JwtOutils jwtOutils;
    @Autowired SecurityServices authSer;
    public UserAuth(UserRepository UserRepository,
                          MyBCryptPasswordEncoder myBCryptPasswordEncoder) {
        this.UserRepository = UserRepository;
        this.myBCryptPasswordEncoder = myBCryptPasswordEncoder;
    }
    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_PER')")
    @GetMapping("/get-all") List<User> getAll () {
    	return userRepository.findAll();
    }
    @PostMapping("/sign-in")
    public AuthResponse signIn(@RequestBody AuthRequest authRequest) {
        User user = userRepository.findByUsername(authRequest.username);
        if (user != null && myBCryptPasswordEncoder.matches(authRequest.password, user.getPassword())) {
            return new AuthResponse(jwtOutils.create(user));
        }
        return null;
    }
    @CrossOrigin
    @PutMapping("/update")
    public User update(@RequestBody UserRequest userReq) {
    	      
      return  authSer.update(userReq);
      
    }
    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_USER')") 
    @PutMapping("/change-password") User changePassword(@RequestBody AuthRequest authRequest) {
    	User user = userRepository.findByUsername(authRequest.username);
    	if(user != null ) {
    		user.setPassword(myBCryptPasswordEncoder.encode(authRequest.password));
    		return userRepository.save(user);
    	}
		return null;
    	
    }
    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_USER')") 
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserRequest userReq) {
    	
    	
    	User usercreate =  new User(
    			userReq.getUsername(),
    			userReq.getPassword(),
    			userReq.getFullname(),
    			userReq.getImage()
    			);
    	System.out.println(userReq.getRole());
    	if(userReq.getRole().equals("ROLE_ADMIN")) {	
    		
    		 authSer.createAdmin(usercreate);
    	}
    	if(userReq.getRole().equals("ROLE_MANAGER")) {
    		authSer.createManager(usercreate);
    	}
    	if(userReq.getRole().equals("ROLE_USER")) {
    		 authSer.createUser(usercreate);
    	}     
      
        User  user = userRepository.findByUsername(userReq.getUsername());
        if (user != null && myBCryptPasswordEncoder.matches(userReq.getPassword(), user.getPassword())) {
            return new ResponseEntity<AuthResponse>( new AuthResponse(jwtOutils.create(user)),HttpStatus.OK);
        }
        return new ResponseEntity<String>("Invalued", HttpStatus.BAD_REQUEST);
    }
    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_USER')") 
    @DeleteMapping("/delete/{username}")
    public void delete(@PathVariable("username") String username) {
    	User user = userRepository.findByUsername(username);
    	if(user != null && user.getUsername() != "admin") userRepository.delete(user);
    }
    
}
