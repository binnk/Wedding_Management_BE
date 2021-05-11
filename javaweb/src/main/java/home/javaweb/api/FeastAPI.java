package home.javaweb.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import home.javaweb.entity.FeastEntity;
import home.javaweb.repository.FeastRepository;

@RestController
public class FeastAPI {
  @Autowired
  private FeastRepository  feastrepo;
  
	@PostMapping("/api/create")
	public FeastEntity createFeast (@RequestBody FeastEntity feast ) {
		return feastrepo.save(feast);
	}
	@PutMapping("/api/update")
	public FeastEntity updateFeast (@RequestBody FeastEntity feast ) {
		return feastrepo.save(feast);
	}
	@DeleteMapping("/api/delete")
	public void deleteFeast (@RequestBody Long id ) {
		 feastrepo.delete(id);
	}
	
}
