package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.LobbyDTO;
import home.javaweb.entity.LobbyEntity;

public interface ILobbyService {
    List<LobbyEntity> findAll();
    LobbyDTO getOne(Long id);
    LobbyEntity create(LobbyDTO lobby);
    LobbyEntity update(LobbyDTO lobby);
    void Delete(Long id);
}
