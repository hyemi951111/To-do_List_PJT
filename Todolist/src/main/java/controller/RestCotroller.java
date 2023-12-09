package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import service.UserService;

@RestController
public class RestCotroller {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		
		boolean check = userService.checkUserIdExist(user_id);
		
		return check + ""; //String으로의 반환을 위해 빈 따옴표를 추가한다.
		
	}

}
