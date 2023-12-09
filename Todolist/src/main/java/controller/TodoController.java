package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.TodoBean;
import beans.UserBean;
import service.TodoService;

@RequestMapping("/todo")
@Controller
public class TodoController {

	@Resource(name = "userSession")
	private UserBean userSession;
	
	@Autowired
	private TodoService todoService;
	
	//todo-list 메인페이지와 동시에, todo-list 목록 나오는 메서드
	//간단히 할수있다..!
	@GetMapping("/todolist")
	public String todolist(Model model, @ModelAttribute("todoModifyBean") TodoBean todoModifyBean, @ModelAttribute("searchBean") TodoBean searchBean,
			@RequestParam("user_key") int user_key) {
		
		//-님 반갑습니다를 출력하기 위한 사용자 아이디
		String user_id = userSession.getUser_id();
		model.addAttribute("user_id", user_id);
		
		//search에서 보내기 위해
		model.addAttribute("user_key", user_key);
		
		//작성한 todo-list 띄우는 메서드
		List<TodoBean> todoList = todoService.todoList(user_key);
		//jsp에서 출력하기 위해 모델에 담음.
		model.addAttribute("todoList", todoList);
		
		//총 몇건인지(+size로 편하게 구할수있음..)
		int totalNumber = todoService.totalList(user_key);
		model.addAttribute("totalNumber", totalNumber);
		
		return "todolist";
	}
	
	//todo-list 작성하는 메서드
	@PostMapping("/addTodo")
	public String addTodo(@ModelAttribute("addTodoBean") TodoBean addTodoBean, @RequestParam("user_key") int user_key, Model model) {
		
		addTodoBean.setUser_key(user_key);
		//todo-list 작성하는 메서드
		todoService.addTodo(addTodoBean);
		
		return "todoAdd_done";
	}
	
	//todo-list 수정하는 메서드
	@PostMapping("/todoList_modify")
	public String todoList_modify(@ModelAttribute("todoModifyBean") TodoBean todoModifyBean, @RequestParam("user_key") int user_key, Model model) {
		
		todoService.modifyTodo(todoModifyBean);
		
		model.addAttribute("user_key", user_key);
		
		return "todoModify_done";
	}
	
	//todo-list 삭제하는 메서드
	@GetMapping("/deleteTodo")
	public String deleteTodo(@RequestParam("todo_key") int todo_key, @RequestParam("user_key") int user_key, Model model) {

		todoService.deleteTodo(todo_key);
		
		model.addAttribute("user_key", user_key);
		
		return "todoDelete_done";
	}
	
	//todo_status에 따라 검색하는 메서드
	@PostMapping("/statusSearch")
	public String statusSearch(@ModelAttribute("searchBean") TodoBean searchBean, @ModelAttribute("todoModifyBean") TodoBean todoModifyBean, 
											 @RequestParam("user_id") String user_id,Model model, @RequestParam("user_key") int user_key) {
		
		//'모두'를 눌러 searchBean의 todo_status에 '모두'가 들어간다면,
		if("모두".equals(searchBean.getTodo_status())) {
			List<TodoBean> todoList = todoService.todoList(user_key); //전체 todo-list를 보여주는 메서드 호출함.
			model.addAttribute("todoList", todoList); //totallist.jsp에 출력해야되니까 model에 담음.
		}else if //그외에 다른것들을 눌러서 그 값들이 들어간다면,
		("진행중".equals(searchBean.getTodo_status()) || "완료".equals(searchBean.getTodo_status())) {

		searchBean.setUser_key(user_key);
		List<TodoBean> todoList = todoService.statusSearch(searchBean); //그 값들을 매개변수로 넣고 그 값들을 조건으로 해서 보여주는 메서드 호출함.
		model.addAttribute("todoList", todoList); }//totallist.jsp에 출력해야되니까 model에 담음. list 이름을 똑같이하여 조건이 어떻든 모두 출력되게 함.
		
		//-님 반갑습니다를 출력하기 위한 사용자 아이디
		model.addAttribute("user_id", user_id);
		
		user_key = searchBean.getUser_key();
		model.addAttribute("user_key", user_key);
		
		//총 몇건인지
		int totalNumber = todoService.totalList(user_key);
		model.addAttribute("totalNumber", totalNumber);
		
		return "todolist";
	}
	
}
