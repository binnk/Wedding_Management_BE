package home.javaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.config.sercurity.AuthRequest;
import home.javaweb.config.sercurity.AuthResponse;
import home.javaweb.config.sercurity.JwtOutils;
import home.javaweb.config.sercurity.MyBCryptPasswordEncoder;
import home.javaweb.entity.User;
import home.javaweb.repository.UserRepository;
import home.javaweb.service.SecurityServices;

@RestController
@RequestMapping("/api")
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

    @PostMapping("/sign-in")
    public AuthResponse signIn(@RequestBody AuthRequest authRequest) {
        User user = userRepository.findByUsername(authRequest.username);
        if (user != null && myBCryptPasswordEncoder.matches(authRequest.password, user.getPassword())) {
            return new AuthResponse(jwtOutils.create(user));
        }
        return null;
    }
    @PreAuthorize("hasAuthority('UPDATE_USER')") 
    @PostMapping("/sign-up")
    public AuthResponse signUp(@RequestBody AuthRequest authRequest) {
        User user = new User(authRequest.username, authRequest.password);
        authSer.createAdmin(user);
        user = userRepository.findByUsername(authRequest.username);
        if (user != null && myBCryptPasswordEncoder.matches(authRequest.password, user.getPassword())) {
            return new AuthResponse(jwtOutils.create(user));
        }
        return null;
    }
    @PreAuthorize("hasAuthority('UPDATE_USER')") 
    @DeleteMapping("/delete/{username}")
    public void delete(@PathVariable("username") String username) {
    	User user = userRepository.findByUsername(username);
    	if(user != null && user.getUsername() != "admin") userRepository.delete(user);
    }
    
}
