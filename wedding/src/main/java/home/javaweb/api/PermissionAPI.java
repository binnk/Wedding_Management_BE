package home.javaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.entity.Privilege;
import home.javaweb.entity.Role;
import home.javaweb.repository.PrivilageRepository;
import home.javaweb.repository.RoleRepository;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class PermissionAPI {

	@Autowired
	private RoleRepository ser_role;
	@Autowired
	private PrivilageRepository ser_permission;
	@PutMapping("/permission")
	@PreAuthorize("hasAuthority('UPDATE_PER')")
	public ResponseEntity<?> updatepermission(@RequestParam String rolename, @RequestParam String permission){
		rolename = rolename.toUpperCase();
		permission = permission.toUpperCase();
		if(rolename != "ROLE_ADMIN" && permission != "UPDATE_PER") {
		   List<Privilege> listAuthor =	(List<Privilege>) ser_role.findByName(rolename).getPrivileges();
		   if(listAuthor.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		   for (Privilege item : listAuthor) {
			   if(item.getAuthority() == permission)
				 return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		   }
		   Privilege myPermission = null;
		   myPermission = ser_permission.findByAuthority(permission);
		   if(myPermission == null) {
			   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		   }
		   listAuthor.add(myPermission);
		   Role role = ser_role.findByName(rolename);
		   role.setPrivileges(listAuthor);
		   ser_role.save(role);
		   return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/permission/user")
	@PreAuthorize("hasAuthority('UPDATE_PER')")
	public ResponseEntity<?> viewPermissionUser() {
		List<Privilege> listAuthor = (List<Privilege>) ser_role.findByName("ROLE_USER").getPrivileges();
		List<String> permissions =  new ArrayList<String>();
		for (Privilege item : listAuthor) {
			permissions.add(item.getAuthority());
		}
		return new ResponseEntity<List<String>>(permissions, HttpStatus.OK);
	}
	@GetMapping("/permission/manager")
	@PreAuthorize("hasAuthority('UPDATE_PER')")
	public ResponseEntity<?> viewPermissionManager() {
		List<Privilege> listAuthor = (List<Privilege>) ser_role.findByName("ROLE_MANAGER").getPrivileges();
		List<String> permissions =  new ArrayList<String>();
		for (Privilege item : listAuthor) {
			permissions.add(item.getAuthority());
		}
		return new ResponseEntity<List<String>>(permissions, HttpStatus.OK);
	}
	
}
