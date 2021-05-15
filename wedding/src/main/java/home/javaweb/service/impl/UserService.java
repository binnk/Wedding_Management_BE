package home.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.UserConverter;
import home.javaweb.dto.UserDTO;
import home.javaweb.entity.UserEntity;
import home.javaweb.repository.UserRepository;
import home.javaweb.service.IUserService;


@Service("userService")
public class UserService implements IUserService {	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<UserDTO>();
		List<UserEntity> userEntities = userRepository.findAll();
		for(UserEntity entity : userEntities) {
			UserDTO userDTO = userConverter.toDto(entity);
			result.add(userDTO);
		}
		return result;
	}
}
