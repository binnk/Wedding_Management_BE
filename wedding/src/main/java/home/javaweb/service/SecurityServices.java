package home.javaweb.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.config.sercurity.MyBCryptPasswordEncoder;
import home.javaweb.entity.Privilege;
import home.javaweb.entity.Role;
import home.javaweb.entity.User;
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
        if (role == null)
            role = roleRepository.save(Role.valueOf("ROLE_USER"));

        Privilege privilege = privilageRepository.findByAuthority("READ_PROFILE");
        if (privilege == null)
            privilege = privilageRepository.save(new Privilege("READ_PROFILE"));
        role.getPrivileges().add(privilege);

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
        Privilege privilege = privilageRepository.findByAuthority("EDIT_PROFILE");
        if (privilege == null)
            privilege = privilageRepository.save(new Privilege("EDIT_PROFILE"));
        role.getPrivileges().add(privilege);
        privilege = privilageRepository.findByAuthority("READ_PROFILE");
        if (privilege == null)
            privilege = privilageRepository.save(new Privilege("READ_PROFILE"));
        role.getPrivileges().add(privilege);
        privilege = privilageRepository.findByAuthority("DELETE_PROFILE");
        if (privilege == null)
            privilege = privilageRepository.save(new Privilege("DELETE_PROFILE"));
        role.getPrivileges().add(privilege);
        user.getRoles().add(role);
        user.setPassword(myBCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

}