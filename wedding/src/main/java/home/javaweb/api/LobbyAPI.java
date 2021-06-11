package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import home.javaweb.entity.LobbyEntity;
import home.javaweb.service.ILobbyService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LobbyAPI {
   @Autowired
    ILobbyService lobbySer;

   @GetMapping("/lobby")
	public List<LobbyEntity> lobbyList() {
		return lobbySer.findAll();
	}
   @GetMapping("/lobby/{id}")
   public ResponseEntity<LobbyDTO> lobby(@PathVariable("id") Long id){
	 LobbyDTO lobby =  lobbySer.getOne(id);
	   if(lobby == null) 
		   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   return  new ResponseEntity<LobbyDTO>(lobby, HttpStatus.OK);   
   }
   @PostMapping("/lobby")
   public ResponseEntity<LobbyEntity> create(@RequestBody LobbyDTO lobby) {
	   LobbyEntity result = lobbySer.create(lobby);
	   if(result == null)
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   return new ResponseEntity<LobbyEntity>(result, HttpStatus.ACCEPTED);
   }
   @PutMapping("/lobby")
   public ResponseEntity<LobbyEntity> update(@RequestBody LobbyDTO lobby) {
	   LobbyEntity result = lobbySer.update(lobby);
	   if(result == null)
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   return new ResponseEntity<LobbyEntity>(result, HttpStatus.ACCEPTED);
   }
   @DeleteMapping("/lobby/{id}")
   public  ResponseEntity<Object> deleteByid(@PathVariable("id") Long id) {
	   if(id == null)
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   lobbySer.Delete(id);
	   return new ResponseEntity<>(HttpStatus.OK);
   }
}
