package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.TodoBean;

public interface TodoMapper {

	//todo-list 작성
	@Insert("insert into todotable "
			+ "(todo_key, todo_status, todo_content, start_time, end_time, user_key) " 
			+ "VALUES "
			+ "(todo_seq.nextval, '진행중', #{todo_content}, sysdate, #{end_time, jdbcType=VARCHAR}, #{user_key})")
	public void addTodo(TodoBean addTodoBean);
	
	//todo-list 조회
	@Select("SELECT a.TODO_KEY, a.TODO_STATUS, a.TODO_CONTENT, to_char(a.start_time, 'YYYY-MM-DD') as start_time, to_char(a.end_time, 'YYYY-MM-DD') as end_time, b.user_key "
			+ "FROM todotable a "
			+ "INNER JOIN usertable b ON a.user_key = b.user_key "
			+ "where b.user_key = #{user_key} order by a.todo_key asc")
	public List<TodoBean> todoList(int user_key);
	
	//todo-list 수정
	@Update("update todotable set todo_status = #{todo_status}, todo_content = #{todo_content}, start_time = to_char(to_date(#{start_time}, 'YYYY-MM-DD'), 'YYYY-MM-DD'),  "
					+ "end_time = to_char(to_date(#{end_time}, 'YYYY-MM-DD'), 'YYYY-MM-DD') "
					+ "where todo_key = #{todo_key}")
	public void modifyTodo(TodoBean todoModifyBean);
	
	//todo-list 삭제
	@Delete("delete from todotable where todo_key = #{todo_key} ")
	public void deleteTodo(int todo_key);
	
	//todo_status에 따라 검색
	@Select("SELECT a.TODO_KEY, a.TODO_STATUS, a.TODO_CONTENT, to_char(a.start_time, 'YYYY-MM-DD') as start_time, to_char(a.end_time, 'YYYY-MM-DD') as end_time, b.user_key "
			+ "FROM todotable a "
			+ "INNER JOIN usertable b ON a.user_key = b.user_key "
			+ "where a.todo_status = #{todo_status} and b.user_key = #{user_key} order by a.todo_key asc")
	public List<TodoBean> statusSearch(TodoBean searchBean);
	
	//총 몇건인지 나타냄
	@Select("SELECT COUNT(*) FROM todotable where user_key = #{user_key} ")
	public int totalList(int user_key);
}
