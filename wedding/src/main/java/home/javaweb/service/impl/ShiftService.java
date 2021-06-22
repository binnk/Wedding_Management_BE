package home.javaweb.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.dto.ShiftDTO;
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
public ShiftEntity create(ShiftDTO shift) {
	// TODO Auto-generated method stub
	ShiftEntity shiftE = new ShiftEntity();
	if(shift.getName() != null && shift.getTimeBegin() != null && shift.getTimeEnd() != null) {
//		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
//		Date dateBegin;
//		Date dateEnd;
		try {
//			dateBegin = formatter.parse(shift.getTimeBegin());
//			dateEnd = formatter.parse(shift.getTimeEnd());
			shiftE.name(shift.getName())
				  .timeBegin(java.sql.Time.valueOf(shift.getTimeBegin()))
				  .timeEnd(java.sql.Time.valueOf(shift.getTimeEnd()))
				  .setActive(true);
			return shiftRepo.save(shiftE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return null;
}

@Override
public ShiftEntity update(ShiftDTO shift) {
	ShiftEntity shiftE = new ShiftEntity();
	if(shift.getId() != null && shift.getName() != null && shift.getTimeBegin() != null && shift.getTimeEnd() != null) {
//		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
//		Date dateBegin;
//		Date dateEnd;
		try {
//			dateBegin = formatter.parse(shift.getTimeBegin());
//			dateEnd = formatter.parse(shift.getTimeEnd());
			shiftE.id(shift.getId())
			      .name(shift.getName())
				  .timeBegin(java.sql.Time.valueOf(shift.getTimeBegin()))
				  .timeEnd(java.sql.Time.valueOf(shift.getTimeEnd()))
				  .setActive(true);
			return shiftRepo.save(shiftE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return null;
	
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
