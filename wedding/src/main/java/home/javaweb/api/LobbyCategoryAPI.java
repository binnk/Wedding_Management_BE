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

import home.javaweb.entity.LobbyCategoryEntity;
import home.javaweb.service.impl.LobbyCategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LobbyCategoryAPI {
   @Autowired
   LobbyCategoryService lobbyCateSer;
   @GetMapping("/lobbycategory")
   public ResponseEntity<Object> getAll() {
	   List<LobbyCategoryEntity> list = lobbyCateSer.findAll();
	   return  new ResponseEntity<>(list, HttpStatus.OK);
   }
   @GetMapping("/lobbycategory/{id}")
   public ResponseEntity<Object> getOne(@PathVariable("id") Long id) {
	   if(id == null) return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   return new ResponseEntity<>(lobbyCateSer.getOne(id), HttpStatus.OK);
   }
   @PostMapping("/lobbycategory") 
   public ResponseEntity<Object> create(@RequestBody LobbyCategoryEntity lobbycate) {
	   return new ResponseEntity<>(lobbyCateSer.create(lobbycate), HttpStatus.ACCEPTED);
   }
   @PutMapping("/lobbycategory") 
   public ResponseEntity<Object> update(@RequestBody LobbyCategoryEntity lobbycate) {
	   return new ResponseEntity<>(lobbyCateSer.update(lobbycate), HttpStatus.ACCEPTED);
   }
   @DeleteMapping("/lobbycategory/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
	   if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   lobbyCateSer.Delete(id);
	   return new ResponseEntity<>( HttpStatus.OK);
   }
}
