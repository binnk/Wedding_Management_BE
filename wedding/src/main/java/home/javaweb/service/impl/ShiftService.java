package home.javaweb.service.impl;
import java.util.ArrayList;
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
	List<ShiftEntity> list = new ArrayList<>();
	for (ShiftEntity item : shiftRepo.findAll()) {
		if(item.getActive()) {
			list.add(item);
		}
	}
	return list;
	}

@Override
public ShiftEntity create(ShiftEntity shift) {
	// TODO Auto-generated method stub
	shift.setActive(true);
	return shiftRepo.save(shift);
}

@Override
public ShiftEntity update(ShiftEntity shift) {
	// TODO Auto-generated method stub
	shift.setActive(true);
	return shiftRepo.save(shift);
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	ShiftEntity shift = shiftRepo.getOne(id);
	if (shift != null) {
		shift.setActive(false);
	}
	shiftRepo.save(shift);
}
}
