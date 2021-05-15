package home.javaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.entity.ShiftEntity;
import home.javaweb.repository.ShiftRepository;
import home.javaweb.service.IShiftService;
@Service("shiftService")
public class ShiftService implements IShiftService { 
   @Autowired
   private ShiftRepository shiftRepo;

@Override
public List<ShiftEntity> findAll() {
	return shiftRepo.findAll();
	}
}
