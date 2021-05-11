package home.javaweb.converter;

import org.springframework.stereotype.Component;

import home.javaweb.dto.UserDTO;
import home.javaweb.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setFullname(entity.getFullname());
		result.setUsername(entity.getUsername());
		result.setBirthday(entity.getBirthday());

		return result;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setId(dto.getId());
		result.setFullname(dto.getFullname());
		result.setUsername(dto.getUsername());
		result.setBirthday(dto.getBirthday());
		return result;
	}
}