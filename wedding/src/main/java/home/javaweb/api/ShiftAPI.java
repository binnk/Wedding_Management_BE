package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import home.javaweb.entity.ShiftEntity;
import home.javaweb.service.IShiftService;

@RestController
public class ShiftAPI {
  @Autowired
  private IShiftService shiftser;
  @GetMapping(path = "/shift")
	public List<ShiftEntity> weddingPage() {
		return shiftser.findAll();		
	}
}
