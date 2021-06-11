package home.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.entity.LobbyCategoryEntity;
import home.javaweb.repository.LobbyCategoryRepository;
import home.javaweb.service.ILobbyCategoryService;
@Service("lobbyCategoryService")
public class LobbyCategoryService implements ILobbyCategoryService {

	@Autowired
	LobbyCategoryRepository lobbyCateSer;
	@Override
	public LobbyCategoryEntity getOne(Long id) {
		// TODO Auto-generated method stub
		LobbyCategoryEntity lobbyCate = lobbyCateSer.getOne(id);
		if(lobbyCate.getActive() == false) return null;
		return lobbyCate;
	}

	@Override
	public List<LobbyCategoryEntity> findAll() {
		// TODO Auto-generated method stub
		List<LobbyCategoryEntity> list = new ArrayList<>() ;
		for (LobbyCategoryEntity item : lobbyCateSer.findAll()) {
			if(item.getActive() == true)
				list.add(item);
		}
		return list;
	}

	@Override
	public LobbyCategoryEntity create(LobbyCategoryEntity lobby) {
		// TODO Auto-generated method stub
		lobby.setActive(true);
		return lobbyCateSer.save(lobby);
	}

	@Override
	public LobbyCategoryEntity update(LobbyCategoryEntity lobby) {
		// TODO Auto-generated method stub
		lobby.setActive(true);
		return lobbyCateSer.save(lobby);
	}

	@Override
	public void Delete(Long id) {
	    LobbyCategoryEntity temp = lobbyCateSer.getOne(id);
	    if(temp != null) {
	    	temp.setActive(false);
	    }
		lobbyCateSer.save(temp);
	}

}
