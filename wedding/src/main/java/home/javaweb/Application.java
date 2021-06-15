package home.javaweb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import home.javaweb.config.sercurity.MyBCryptPasswordEncoder;
import home.javaweb.entity.Privilege;
import home.javaweb.entity.Role;
import home.javaweb.entity.User;
import home.javaweb.repository.PrivilageRepository;
import home.javaweb.repository.RoleRepository;
import home.javaweb.repository.UserRepository;

@SpringBootApplication(scanBasePackages = {"home.javaweb"})

public class Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilageRepository privilageRepository;
    @Autowired
    private MyBCryptPasswordEncoder myBCryptPasswordEncoder;

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
    	userRepository.deleteAll();
        roleRepository.deleteAll();
        privilageRepository.deleteAll();
        

        Privilege UPDATE_FEAST = privilageRepository.save(new Privilege("UPDATE_FEAST"));
        Privilege READ_FEAST = privilageRepository.save(new Privilege("READ_FEAST"));
        Privilege UPDATE_PER = privilageRepository.save(new Privilege("UPDATE_PER"));

        Privilege UPDATE_USER = privilageRepository.save(new Privilege("UPDATE_USER"));
        Privilege READ_USER = privilageRepository.save(new Privilege("READ_USER"));
    

        Role ROLE_ADMIN = roleRepository.save(new Role("ROLE_ADMIN",
                Arrays.asList(
                        	UPDATE_USER,
                        	READ_USER,
                        	UPDATE_FEAST,
                        	READ_FEAST,
                        	UPDATE_PER
                )));
        Role ROLE_USER = roleRepository.save(new Role("ROLE_USER", Arrays.asList(
                READ_FEAST
        )));
        userRepository.save(new User(
                "admin",
                myBCryptPasswordEncoder.encode("0000"),
                Arrays.asList(ROLE_ADMIN, ROLE_USER)
        ));
        userRepository.save(new User(
                "user",
                myBCryptPasswordEncoder.encode("0000"),
                Arrays.asList(ROLE_USER)
        ));

    }
}