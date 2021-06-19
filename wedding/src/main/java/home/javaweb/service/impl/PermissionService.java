package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.entity.Privilege;
import home.javaweb.entity.Role;
import home.javaweb.repository.PrivilageRepository;
import home.javaweb.repository.RoleRepository;
import home.javaweb.service.IPermissionService;
@Service("permissionService")
public class PermissionService implements IPermissionService {
	
	@Autowired
	private RoleRepository ser_role;
	@Autowired
	private PrivilageRepository ser_permission;
	@Override
	public String removePermission(String roleName, String permission) {
		if(roleName != "ROLE_ADMIN" && permission != "UPDATE_PER") {
			   List<Privilege> listAuthor =	(List<Privilege>) ser_role.findByName(roleName).getPrivileges();
			   if(listAuthor.isEmpty()) return "RoleName doesn't exist!";
			   for (Privilege item : listAuthor) {
				   if(item.getAuthority() == permission)
					listAuthor.remove(item);
			   }
			   Role role = ser_role.findByName(roleName);
			   role.setPrivileges(listAuthor);
			   ser_role.save(role);
			   return "Update successful!";
			}
			return "Bad Request! You can't update permisson of ROLE_ADMIN.";
	}

	@Override
	public String addPermission(String roleName, String permission) {
		if(roleName != "ROLE_ADMIN" && permission != "UPDATE_PER") {
			   List<Privilege> listAuthor =	(List<Privilege>) ser_role.findByName(roleName).getPrivileges();
			   if(listAuthor.isEmpty()) return "RoleName doesn't exist!";
			   for (Privilege item : listAuthor) {
				   if(item.getAuthority() == permission)
					return "Already update!";
			   }
			   Privilege myPermission = null;
			   myPermission = ser_permission.findByAuthority(permission);
			   if(myPermission == null) {
				   return "Permisson doesn't exist!";
			   }
			   listAuthor.add(myPermission);
			   Role role = ser_role.findByName(roleName);
			   role.setPrivileges(listAuthor);
			   ser_role.save(role);
			   return "Update successful!";
			}
			return "Bad Request! You can't update permisson of ROLE_ADMIN.";
	}

	@Override
	public Role findByName(String roleName) {
		return ser_role.findByName(roleName);
	}

	
}
