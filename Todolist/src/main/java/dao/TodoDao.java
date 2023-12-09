package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.TodoBean;
import mapper.TodoMapper;

@Repository
public class TodoDao {

	@Autowired
	private TodoMapper todoMapper;
	
	//todo-list 작성
	public void addTodo(TodoBean addTodoBean) {
		todoMapper.addTodo(addTodoBean);
	}
	
	//todo-list 조회
	public List<TodoBean> todoList(int user_key){
		List<TodoBean> todoList = todoMapper.todoList(user_key);
		
		return todoList;
	}
	
	//todo-list 수정
	public void modifyTodo(TodoBean todoModifyBean) {
		todoMapper.modifyTodo(todoModifyBean);
	}
	
	//todo-list 삭제
	public void deleteTodo(int todo_key) {
		todoMapper.deleteTodo(todo_key);
	}
	
	//todo_status에 따라 검색하는 메서드
	public List<TodoBean> statusSearch(TodoBean searchBean) {
		
		List<TodoBean> todoList = todoMapper.statusSearch(searchBean);
		
		return todoList;
	}
	
	//총 몇건인지 나타내는 메서드
	public int totalList(int user_key) {
		
		int totalNumber = todoMapper.totalList(user_key);
		
		return totalNumber;
	}
}
