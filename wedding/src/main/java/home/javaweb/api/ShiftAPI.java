package home.javaweb.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.javaweb.dto.LobbyDTO;
import home.javaweb.dto.ShiftDTO;
import home.javaweb.entity.LobbyEntity;
import home.javaweb.entity.ShiftEntity;
import home.javaweb.service.IShiftService;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class ShiftAPI {
  @Autowired
  private IShiftService shiftSer;
  @PreAuthorize("hasAuthority('READ_SHIFT')") 
  @GetMapping(path = "/shift")
	public List<ShiftEntity> weddingPage() {
		return shiftSer.findAll();		
	}
  @PreAuthorize("hasAuthority('UPDATE_SHIFT')") 
  @PostMapping("/shift")
  public ResponseEntity<ShiftEntity> create(@RequestBody ShiftDTO lobby) {
	    ShiftEntity result = shiftSer.create(lobby);
	   if(result == null)
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   return new ResponseEntity<ShiftEntity>(result, HttpStatus.ACCEPTED);
  }
  @PreAuthorize("hasAuthority('UPDATE_SHIFT')") 
  @PutMapping("/shift")
  public ResponseEntity<ShiftEntity> update(@RequestBody ShiftDTO lobby) {
	  ShiftEntity result = shiftSer.update(lobby);
	   if(result == null)
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   return new ResponseEntity<ShiftEntity>(result, HttpStatus.ACCEPTED);
  }
  @PreAuthorize("hasAuthority('UPDATE_SHIFT')") 
  @DeleteMapping("/shift/{id}")
  public  ResponseEntity<Object> deleteByid(@PathVariable("id") Long id) {
	   if(id == null)
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   shiftSer.delete(id);
	   return new ResponseEntity<>(HttpStatus.OK);
  }
}
