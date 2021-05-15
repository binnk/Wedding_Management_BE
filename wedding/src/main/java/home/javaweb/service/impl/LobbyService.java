package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.entity.LobbyEntity;
import home.javaweb.repository.LobbyRepository;
import home.javaweb.service.ILobbyService;
@Service("lobbyService")
public class LobbyService  implements ILobbyService{
  
	@Autowired 
	 private LobbyRepository lobbyRepo;
	@Override
	public List<LobbyEntity> findAll() {
		return lobbyRepo.findAll();
	}

}
