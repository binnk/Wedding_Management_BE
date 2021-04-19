package javaweb;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import home.javaweb.repository.UserRepository;
import home.javaweb.entity.UserEntity;

//@DataJpaTest
//@AutoConfigureTestDatabase (replace = Replace.NONE)
//@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		UserEntity user = new UserEntity();
		user.setFullname("Pham Khang");
		user.setUsername("ptk");

	     

	     
	
	     
	}
}

