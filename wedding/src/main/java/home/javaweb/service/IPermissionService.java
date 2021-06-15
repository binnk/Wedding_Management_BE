package home.javaweb.service;

import java.util.List;
import home.javaweb.entity.Role;

public interface IPermissionService {
    String  removePermission(String roleName, String permission );
    String addPermission(String roleName, String permission);
    Role findByName(String roleName);
       
}
