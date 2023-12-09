package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.TodoBean;
import beans.UserBean;
import dao.TodoDao;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;
	
	@Resource(name = "userSession")
	private UserBean userSession;
	
	//todo-list 작성
	public void addTodo(TodoBean addTodoBean) {
		todoDao.addTodo(addTodoBean);
	}
	
	//todo-list 조회
	public List<TodoBean> todoList(int user_key){
		
		List<TodoBean> todoList = todoDao.todoList(user_key);
		
		return todoList;
	}
	
	//todo-list 수정
	public void modifyTodo(TodoBean todoModifyBean) {
		todoDao.modifyTodo(todoModifyBean);
	}
	
	//todo-list 삭제
	public void deleteTodo(int todo_key) {
		todoDao.deleteTodo(todo_key);
	}
	
	//todo_status에 따라 검색하는 메서드
	public List<TodoBean> statusSearch(TodoBean searchBean) {
		
			List<TodoBean> todoList = todoDao.statusSearch(searchBean);
		
		return todoList;
		
	}
	
	//총 몇건인지 나타내는 메서드
		public int totalList(int user_key) {
			
			int totalNumber = todoDao.totalList(user_key);
			
			return totalNumber;
		}
}
