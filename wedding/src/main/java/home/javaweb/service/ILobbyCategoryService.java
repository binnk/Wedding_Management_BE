package home.javaweb.service;

import java.util.List;

import home.javaweb.entity.LobbyCategoryEntity;
import home.javaweb.entity.LobbyEntity;

public interface ILobbyCategoryService {
        LobbyCategoryEntity getOne(Long id);
	    List<LobbyCategoryEntity> findAll();
	    LobbyCategoryEntity create(LobbyCategoryEntity lobby);
	    LobbyCategoryEntity update(LobbyCategoryEntity lobby);
	    void Delete(Long id);
}
