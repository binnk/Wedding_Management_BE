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
        
        /* BILL */
        Privilege READ_BILL =  privilageRepository.save(new Privilege("READ_BILL", "Xem danh sách hoá đơn"));
        Privilege UPDATE_BILL =  privilageRepository.save(new Privilege("UPDATE_BILL", "Thêm sửa xoá hoá đơn"));
        
        /* REPORT */
        
        Privilege READ_REPORT =  privilageRepository.save(new Privilege("READ_REPORT", "Xem thống kê"));
        
        /* FINE */
        Privilege UPDATE_FINE =  privilageRepository.save(new Privilege("UPDATE_FINE", "Thay đổi % phạt"));
        

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
                        	UPDATE_SERVICE,
                        	READ_BILL,
                        	UPDATE_BILL,
                        	READ_REPORT,
                        	UPDATE_FINE
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
                        	UPDATE_SERVICE,
                        	READ_BILL,
                        	UPDATE_BILL,
                        	READ_REPORT,
                        	UPDATE_FINE
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
            	UPDATE_SERVICE,
            	READ_BILL
                
        )));
        userRepository.save(new User(
                "admin",
                myBCryptPasswordEncoder.encode("0000"),
                "Minn Nghi", "https://res.cloudinary.com/huong/image/upload/v1624291561/user_image/144395347_3880732475324427_3204797492735464393_n_usfgdf.jpg?fbclid=IwAR3Nkq5laTA2InL0Xqqm3meIYHHe7u-RLFZlY1v0XijY9nqgBlD3vAKRd-I",
                Arrays.asList(ROLE_ADMIN)
        ));
        userRepository.save(new User(
                "manager",
                myBCryptPasswordEncoder.encode("0000"),
                "Vũ", "https://res.cloudinary.com/huong/image/upload/v1624236464/user_image/131326991_237371631084463_7828732453456712998_n_xuiewg.jpg?fbclid=IwAR3AxbH4at7xSJh6H_ezzk-yiycQNs_5LMt70GzbXOyDR16DafrATmTidgU",
                Arrays.asList(ROLE_MANAGER)
        ));
        userRepository.save(new User(
                "user",
                myBCryptPasswordEncoder.encode("0000"),
                "Đen", "https://res.cloudinary.com/huong/image/upload/v1624236843/user_image/186472614_318126249670839_5974620561626302287_n_uakdth.jpg?fbclid=IwAR1KJ-KEjV_syrxY1MsEpDFkcw7VGSGX_qmHjIsfsjFThlSPB7nzXFz7xSI",
                Arrays.asList(ROLE_USER)
        ));

    }
}
