package home.javaweb.service;

import java.util.List;

import home.javaweb.entity.LobbyEntity;

public interface ILobbyService {
    List<LobbyEntity> findAll();
}
