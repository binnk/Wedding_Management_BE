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
        
        Privilege READ_FEAST = privilageRepository.save( new Privilege("READ_FEAST", "Xem danh sách tiệc cưới"));
        Privilege UPDATE_FEAST = privilageRepository.save(new Privilege("UPDATE_FEAST","Thêm xóa sửa tiệc cưới"));
        Privilege READ_USER = privilageRepository.save(new Privilege("READ_USER", "Xem danh sách người dùng"));
        Privilege UPDATE_USER = privilageRepository.save(new Privilege("UPDATE_USER", "Chỉnh sửa người dùng"));
        Privilege UPDATE_PER = privilageRepository.save(new Privilege("UPDATE_PER", "Chỉnh sửa phân quyền"));
        Privilege READ_FOOD = privilageRepository.save(new Privilege("READ_FOOD", "Xem danh sách món ăn"));
        Privilege UPDATE_FOOD = privilageRepository.save(new Privilege("UPDATE_FOOD", "Thêm sửa xóa món ăn"));
        Privilege READ_SHIFT = privilageRepository.save(new Privilege("READ_SHIFT", "Xem danh sách ca"));
        Privilege UPDATE_SHIFT = privilageRepository.save(new Privilege("UPDATE_SHIFT", "Thêm sửa xóa ca"));
        Privilege READ_LOBBY = privilageRepository.save(new Privilege("READ_LOBBY", "Xem danh sách sảnh"));
        Privilege UPDATE_LOBBY = privilageRepository.save(new Privilege("UPDATE_LOBBY", "Thêm sửa xóa sảnh"));
        Privilege READ_LOBBYCATEGORY = privilageRepository.save(new Privilege("READ_LOBBYCATEGORY", "Xem danh sách loại sảnh"));
        Privilege UPDATE_LOBBYCATEGORY = privilageRepository.save(new Privilege("UPDATE_LOBBYCATEGORY", "Thêm sửa xóa loại sảnh"));
        Privilege READ_SERVICE = privilageRepository.save(new Privilege("READ_SERVICE", "Xem danh sách dịch vụ"));
        Privilege UPDATE_SERVICE = privilageRepository.save(new Privilege("UPDATE_SERVICE", "Thêm sửa xóa dịch vụ"));

        Role ROLE_ADMIN = roleRepository.save(new Role("ROLE_ADMIN",
                Arrays.asList(
                        	UPDATE_USER,
                        	READ_USER,
                        	UPDATE_PER,
                        	READ_SHIFT,
                        	UPDATE_SHIFT,
                        	UPDATE_FEAST,
                        	READ_FEAST,
                        	READ_FOOD,
                        	UPDATE_FOOD,                       	
                        	READ_LOBBY,
                        	UPDATE_LOBBY,
                        	READ_LOBBYCATEGORY,
                        	UPDATE_LOBBYCATEGORY,
                        	READ_SERVICE,
                        	UPDATE_SERVICE
                )));
        Role ROLE_MANAGER = roleRepository.save(new Role("ROLE_MANAGER",
                Arrays.asList(                      	
                        	READ_USER,                   
                        	READ_SHIFT,
                        	UPDATE_SHIFT,
                        	UPDATE_FEAST,
                        	READ_FEAST,
                        	READ_FOOD,
                        	UPDATE_FOOD,                       	
                        	READ_LOBBY,
                        	UPDATE_LOBBY,
                        	READ_LOBBYCATEGORY,
                        	UPDATE_LOBBYCATEGORY,
                        	READ_SERVICE,
                        	UPDATE_SERVICE
                )));
        Role ROLE_USER = roleRepository.save(new Role("ROLE_USER", Arrays.asList(
        		UPDATE_FEAST,
            	READ_FEAST,
            	READ_FOOD,
            	UPDATE_FOOD,                       	
            	READ_LOBBY,
            	UPDATE_LOBBY,
            	READ_LOBBYCATEGORY,
            	UPDATE_LOBBYCATEGORY,
            	READ_SERVICE,
            	UPDATE_SERVICE
                
        )));
        userRepository.save(new User(
                "admin",
                myBCryptPasswordEncoder.encode("0000"),
                Arrays.asList(ROLE_ADMIN)
        ));
        userRepository.save(new User(
                "manager",
                myBCryptPasswordEncoder.encode("0000"),
                Arrays.asList(ROLE_MANAGER)
        ));
        userRepository.save(new User(
                "user",
                myBCryptPasswordEncoder.encode("0000"),
                Arrays.asList(ROLE_USER)
        ));

    }
}