package home.javaweb.controller.admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import home.javaweb.entity.FeastEntity;
import home.javaweb.repository.FeastRepository;

@RestController
public class FeastController {
	
  @Autowired
  private FeastRepository  feastrepo;
  
	@GetMapping("/quan-tri/wedding")
	public List<FeastEntity> weddingPage() {
		return feastrepo.findAll();
	}
	@PostMapping("/api/create")
	public FeastEntity createFeast (@RequestBody FeastEntity feast ) {
		return feastrepo.save(feast);
	}
}
