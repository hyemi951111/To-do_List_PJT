package beans;

public class TodoBean {

	private int todo_key; //구분자 pk
	private int user_key; //FK
	private String todo_status; //상태
	private String todo_content; //내용
	private String start_time; //시작시간
	private String end_time; //마감시간
	
	public int getUser_key() {
		return user_key;
	}
	public void setUser_key(int user_key) {
		this.user_key = user_key;
	}
	public int getTodo_key() {
		return todo_key;
	}
	public void setTodo_key(int todo_key) {
		this.todo_key = todo_key;
	}
	
	public String getTodo_status() {
		return todo_status;
	}
	public void setTodo_status(String todo_status) {
		this.todo_status = todo_status;
	}
	public String getTodo_content() {
		return todo_content;
	}
	public void setTodo_content(String todo_content) {
		this.todo_content = todo_content;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	
	
}
