package home.javaweb.controller.admin;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.converter.FeastConverter;
import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;
import home.javaweb.repository.FeastRepository;

@RestController
public class FeastController {
	
  @Autowired
  private FeastRepository  feastrepo;
  
	@GetMapping("/quan-tri/wedding")
	public List<FeastDTO> weddingPage() {
		List<FeastDTO> listDTO = new LinkedList<FeastDTO>();
		List<FeastEntity>  listsEntity =  feastrepo.findAll();
		for (FeastEntity item : listsEntity) {
			listDTO.add(FeastConverter.getIntance().EntityToDto(item));
		}
		return listDTO;
		
	}
//	@PostMapping("/api/create")
//	public FeastEntity createFeast (@RequestBody FeastEntity feast ) {
//		return feastrepo.save(feast);
//	}
}