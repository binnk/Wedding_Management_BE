package home.javaweb.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.config.sercurity.MyBCryptPasswordEncoder;
import home.javaweb.entity.Privilege;
import home.javaweb.entity.Role;
import home.javaweb.entity.User;
import home.javaweb.entity.UserRequest;
import home.javaweb.repository.PrivilageRepository;
import home.javaweb.repository.RoleRepository;
import home.javaweb.repository.UserRepository;

@Service
public class SecurityServices {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MyBCryptPasswordEncoder myBCryptPasswordEncoder;

    @Autowired
    private PrivilageRepository privilageRepository;

    public void createUser(User user) {
    	if(userRepository.findByUsername(user.getUsername()) != null)
    		return;
        Role role = roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);
        user.setPassword(myBCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void createAdmin(User user) {
    	if(userRepository.findByUsername(user.getUsername()) != null)
    		return;
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null)
            roleRepository.save(Role.valueOf("ROLE_ADMIN"));      
        user.getRoles().add(role);
        user.setPassword(myBCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public void createManager(User user) {
    	if(userRepository.findByUsername(user.getUsername()) != null)
    		return;
        Role role = roleRepository.findByName("ROLE_MANAGER");
        if (role == null)
            roleRepository.save(Role.valueOf("ROLE_MANAGER"));      
        user.getRoles().add(role);
        user.setPassword(myBCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public User update(UserRequest userReq) {
    	Role role;
    	User user = userRepository.findByUsername(userReq.getUsername());
        if (user == null) return null;
        if(userReq.getImage() != null ) user.setImage(userReq.getImage());
        if(userReq.getFullname() != null) user.setFullName(userReq.getFullname());
        if(userReq.getPassword() != null) user.setPassword(myBCryptPasswordEncoder.encode(userReq.getPassword()));
        if(userReq.getRole().equals("ROLE_ADMIN")) {
        	user.getRoles().clear();
        	user.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
        }
        if(userReq.getRole().equals("ROLE_MANAGER")) {
        	user.getRoles().clear();
        	user.getRoles().add(roleRepository.findByName("ROLE_MANAGER"));
        }
        if(userReq.getRole().equals("ROLE_USER")) {
        	user.getRoles().clear();
        	user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        }
        return userRepository.save(user);
    }
    public void deleteAll() {
        userRepository.deleteAll();
    }

}