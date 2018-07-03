package exercise;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import exercise.User;
import exercise.UserRepository;

@Controller
@RequestMapping(path="/exercise")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/saveUser")
	public @ResponseBody ResponseEntity<String> addNewUser (@RequestBody User user){
		try {
			userRepository.save(user);
		}catch (DataAccessException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create new user");
		}		
		return ResponseEntity.status(HttpStatus.CREATED).body("New user created successfully");
	}
	
	@GetMapping(path="/getUser")
	public @ResponseBody Optional<User> getUser(@RequestParam(value ="email", required = false) String email,
			@RequestParam(value = "ipAddress", required = false) String ipAddress) {
		return userRepository.getUser(email, ipAddress);
		
	}
	
	@GetMapping(path="/getAllUsers")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
}
