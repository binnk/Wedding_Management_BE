package home.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import home.javaweb.entity.LobbyEntity;
import home.javaweb.service.ILobbyService;
@RequestMapping("/api")
@RestController
public class LobbyAPI {
   @Autowired
   private ILobbyService lobbySer;
   
   @GetMapping(path = "/lobby")
	public List<LobbyEntity> weddingPage() {
		return lobbySer.findAll();		
	}
}
