package home.javaweb.service;

import java.util.List;

import home.javaweb.dto.ShiftDTO;
import home.javaweb.entity.ShiftEntity;

public interface IShiftService {
    List<ShiftEntity> findAll();
    ShiftEntity create(ShiftDTO shift);
    ShiftEntity update(ShiftDTO shift);
    void delete (Long id);
}
