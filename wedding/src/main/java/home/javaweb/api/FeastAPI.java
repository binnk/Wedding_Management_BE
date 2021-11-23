package home.javaweb.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;
import home.javaweb.regime.entity.FeastRegime;
import home.javaweb.regime.entity.Regime;
import home.javaweb.repository.FeastRepository;
import home.javaweb.repository.LobbyRepository;
import home.javaweb.repository.ShiftRepository;
import home.javaweb.service.IFeastService;
import home.javaweb.service.ILobbyService;
import home.javaweb.service.IShiftService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class FeastAPI {
  @Autowired
  private IFeastService  feastser;
  @Autowired
  private LobbyRepository lobbyRepo;
  @Autowired
  private ShiftRepository shiftRepo;
  @Autowired
  private FeastRepository feastRepo;
  
  
  //some thing change
  @PreAuthorize("hasAuthority('READ_FEAST')") 
   @GetMapping(path = "/feast")
	public List<FeastDTO> weddingPage() {
		return feastser.findAll();
	}

  @PreAuthorize("hasAuthority('UPDATE_FEAST')") 
	@PostMapping("/feast")
	public ResponseEntity<FeastDTO> createFeast (@RequestBody FeastDTO feast ) throws Exception {
		FeastDTO result = null;
		result = feastser.save(feast);
		if(result != null) {
			return  new ResponseEntity<FeastDTO>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
   @PreAuthorize("hasAuthority('UPDATE_FEAST')") 
	@PutMapping("/feast")
	public ResponseEntity<FeastDTO> updateFeast (@RequestBody FeastDTO feast ) throws Exception {
		FeastDTO result = null;
		result = feastser.update(feast);
		if(result != null) {
			return  new ResponseEntity<FeastDTO>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
   
    @PreAuthorize("hasAuthority('UPDATE_FEAST')") 
	@DeleteMapping(path="feast/{id}")
	public void deleteFeast (@PathVariable("id") Long id ) {
		 feastser.deleteById(id);
	}
    @PreAuthorize("hasAuthority('UPDATE_FEAST')") 
    @PutMapping("/feast/check-exist")
    public Boolean isExist(@RequestBody FeastDTO feast) {
            return feastser.checkExist(feast);
    }
    
    @GetMapping(path = "/feast/{id}")
 	public ResponseEntity<Object> findById(@PathVariable("id") Long id) {

    	FeastEntity feast = feastRepo.findById(id).get();
    	return new ResponseEntity<>(feast, HttpStatus.OK);
 	}
    

}
