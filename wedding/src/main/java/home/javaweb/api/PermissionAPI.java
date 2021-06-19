package home.javaweb.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.entity.Role;
import home.javaweb.repository.RoleRepository;
import home.javaweb.service.IPermissionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PermissionAPI {

	@Autowired
	private IPermissionService permission_ser;
	@Autowired
    private RoleRepository roleRepository;
	@CrossOrigin
	@PutMapping("/permission/add")
	@PreAuthorize("hasAuthority('UPDATE_PER')")
	public ResponseEntity<?> addPermission(@RequestParam String rolename, @RequestParam String permission){
		rolename = rolename.toUpperCase();
		permission = permission.toUpperCase();
		String result = permission_ser.addPermission(rolename, permission);
		if(result =="Update successful!")
			return new ResponseEntity<String>(result, HttpStatus.OK);
		else 
			return new ResponseEntity<String>(result,HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@PutMapping("/permission/remove")
	@PreAuthorize("hasAuthority('UPDATE_PER')")
	public ResponseEntity<?> removePermission(@RequestParam String rolename, @RequestParam String permission){
		rolename = rolename.toUpperCase();
		permission = permission.toUpperCase();
		String result = permission_ser.removePermission(rolename, permission);
		if(result =="Update successful!")
			return new ResponseEntity<String>(result, HttpStatus.OK);
		else 
			return new ResponseEntity<String>(result,HttpStatus.NO_CONTENT);
	}
	@GetMapping("/permission/{rolename}")
	@PreAuthorize("hasAuthority('UPDATE_PER')")
	public ResponseEntity<?> viewPermissionUser(@PathVariable("rolename") String rolename) {
		rolename = rolename.toUpperCase();
		Role role = roleRepository.findByName(rolename);
		return new ResponseEntity<Role>(role,HttpStatus.OK);
	}
	
}
