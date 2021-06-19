package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.dto.ServiceDTO;
import home.javaweb.service.IServiceService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ServiceAPI {
	
	@Autowired
	private IServiceService _service;
	@PreAuthorize("hasAuthority('READ_SERVICE')") 
	@GetMapping("/service")
	public List<ServiceDTO> getAllServices(){
		return _service.findAll();
	}
	@PreAuthorize("hasAuthority('UPDATE_SERVICE')") 
	@PostMapping("/service")
	public ServiceDTO createService(@RequestBody ServiceDTO dto) {
		return _service.save(dto);
	}
	@PreAuthorize("hasAuthority('UPDATE_SERVICE')") 
	@PutMapping("/service")
	public ServiceDTO updateService(@RequestBody ServiceDTO dto) {
		return _service.save(dto);
	}
	@PreAuthorize("hasAuthority('UPDATE_SERVICE')") 
	@DeleteMapping("/service")
	public void deleteServices(@RequestBody Long[] ids) {
		_service.deleteById(ids);
	}
}
