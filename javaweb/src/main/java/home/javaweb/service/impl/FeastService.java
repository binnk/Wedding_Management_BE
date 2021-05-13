package home.javaweb.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.converter.FeastConverter;
import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;
import home.javaweb.repository.FeastRepository;
import home.javaweb.repository.LobbyRepository;
import home.javaweb.service.IFeastService;
import home.javaweb.service.OffsetBasedPageRequest;
@Service("feastService")
public class FeastService  implements IFeastService{
  @Autowired
    private FeastRepository feastRepo;
  @Autowired
  private LobbyRepository lobbyRepo;

@Override
public List<FeastDTO> findAll(int limit, int offset) {
	// TODO Auto-generated method stub
	List<FeastDTO> listDTO = new LinkedList<FeastDTO>();
	 Pageable pageable = new OffsetBasedPageRequest(limit, offset);
	List<FeastEntity>  listsEntity =  feastRepo.findAll( new PageRequest(offset, limit)).getContent();
	for (FeastEntity item : listsEntity) {
		listDTO.add(FeastConverter.getIntance().EntityToDto(item));
	}
	return listDTO;
}

@Override
public FeastDTO save(FeastDTO feast)  {
	FeastEntity result = null;
	FeastEntity entity = null;
	try {
	if(!feast.IsAnyNullOrEmty())
	{
	 entity = FeastConverter.getIntance().DtoToEntity(feast);
	 if( lobbyRepo.findOne(feast.getLobbyId()) != null) {
	  entity.setId_lobby(lobbyRepo.findOne(feast.getLobbyId()));
	  result = feastRepo.save(entity);
	  return FeastConverter.getIntance().EntityToDto(result);
	 }
	}
	} catch (Exception e)
	{
		System.out.println(e.toString());
	}
	return null;
}

@Override
public FeastDTO update(FeastDTO feast) {
	FeastEntity result = null;
	FeastEntity entity = null;
	try {
	if(!feast.IsAnyNullOrEmty() && feast.getId() != null)
	{
	 entity = FeastConverter.getIntance().DtoToEntity(feast);
	 if( lobbyRepo.findOne(feast.getLobbyId()) != null) {
	  entity.setId_lobby(lobbyRepo.findOne(feast.getLobbyId()));
	  if(feastRepo.findOne(feast.getId()) != null)
	  result = feastRepo.save(entity);
	  return FeastConverter.getIntance().EntityToDto(result);
	 }
	}
   } catch (Exception e) {
	   System.out.println(e.toString());
   }
	return null;
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	feastRepo.delete(id);
}
}
