package home.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.dto.LobbyDTO;
import home.javaweb.entity.LobbyCategoryEntity;
import home.javaweb.entity.LobbyEntity;
import home.javaweb.repository.LobbyCategoryRepository;
import home.javaweb.repository.LobbyRepository;
import home.javaweb.service.ILobbyService;
@Service("lobbyService")
public class LobbyService  implements ILobbyService{
  
	@Autowired 
	 private LobbyRepository lobbyRepo;
	@Autowired
	private LobbyCategoryRepository lobbyCateRepo;
	@Override
	public List<LobbyEntity> findAll() {
	  List<LobbyEntity> list = new ArrayList<>();
		for(LobbyEntity item: lobbyRepo.findAll()) {
			if(item.getActive() == true)
            list.add(item);
		}
		return list;
	}
	@Override
	public LobbyDTO getOne(Long id) {
		LobbyDTO result =  new LobbyDTO();
		LobbyEntity lobby = lobbyRepo.findById(id).get();
		// TODO Auto-generated method stub
		if(lobby != null && lobby.getActive() == true)
		{
			result
			.id(lobby.getId())
			.name(lobby.getName())
			.image(lobby.getImage())
			.idLobbyCategory(lobby.getLobbyCategory().getId())
			.maxTable(lobby.getMaxTable())
			.LobbyCategory(lobby.getLobbyCategory().getName())
			.minUnitPriceTable(lobby.getMinUnitPriceTable());
			return result;
		}
		return null;
	}
	@Override
	public LobbyEntity create(LobbyDTO lobby) {
	
		LobbyEntity lobbyaction = new LobbyEntity() ;
		Optional<LobbyCategoryEntity> lobbycategory = lobbyCateRepo.findById(lobby.getIdLobbyCategory());
		if (lobbycategory == null) return null;
		try {
			lobbyaction
			.active(true)
			.name(lobby.getName())
			.image(lobby.getImage())
			.maxtable(lobby.getMaxtable())
			.minUnitPriceTable(lobby.getMinUnitPriceTable())
			.lobbyCategory(lobbycategory.get());			
			return lobbyRepo.save(lobbyaction);
		} catch(Exception e) {
			return null;
		}
		
	}
	@Override
	public LobbyEntity update(LobbyDTO lobby) {
		LobbyEntity lobbyaction = new LobbyEntity();
		Optional<LobbyCategoryEntity> lobbycategory = lobbyCateRepo.findById(lobby.getIdLobbyCategory());
		if (lobbycategory == null) return null;
		try {
			lobbyaction
			.id(lobby.getId())
			.active(true)
			.name(lobby.getName())
			.image(lobby.getImage())
			.maxtable(lobby.getMaxtable())
			.minUnitPriceTable(lobby.getMinUnitPriceTable())
			.lobbyCategory(lobbycategory.get());
			return lobbyRepo.save(lobbyaction);
		} catch(Exception e) {
			return null;
		}
	}
	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		LobbyEntity lobby = lobbyRepo.getOne(id);
		lobby.active(false);
		lobbyRepo.save(lobby);
	}

}
