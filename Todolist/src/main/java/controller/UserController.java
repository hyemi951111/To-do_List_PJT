package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.UserBean;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Resource(name = "userSession")
	private UserBean userSession;
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "join";
	}
	
	@PostMapping("/joinPro")
	public String joinpro(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		
	if(joinUserBean.isUserIdExist() == false) {
		return "join_fail";
	}
	
	userService.join(joinUserBean);
	
		return "join_done";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("loginBean") UserBean loginBean) {
		return "login";
	}
	
	//로그인하는 과정
	@PostMapping("/loginPro")
	public String loginpro(@ModelAttribute("loginBean") UserBean loginBean, Model model) {
		
		UserBean logBean = userService.login(loginBean);
		
		if(logBean != null && userSession.isUserLogin() == true) {
			loginBean.setUser_key(userSession.getUser_key());
			int user_key = loginBean.getUser_key();
			model.addAttribute("user_key", user_key);
			
			return "login_done";
		}
		
		return "login_error";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		//request.getSession 메서드에서 false를 가져와서 현재 세션의 존재 여부를 확인, 
		//세션이 존재한다면 반환하고, 존재하지 않으면 null을 반환함.
		HttpSession session = request.getSession(false);
		
		if(session != null) { //세션에 값이 있다면,
			session.removeAttribute("userSession"); //userSession 이름의 속성을 제거. 
		}
		return "logout_done";
	}
}
