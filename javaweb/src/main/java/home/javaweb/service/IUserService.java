package home.javaweb.service;


import java.util.List;

import home.javaweb.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();
}
