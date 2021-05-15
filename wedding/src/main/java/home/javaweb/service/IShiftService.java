package home.javaweb.service;

import java.util.List;

import home.javaweb.entity.ShiftEntity;

public interface IShiftService {
    List<ShiftEntity> findAll();
}
