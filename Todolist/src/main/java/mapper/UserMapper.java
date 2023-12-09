package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import beans.UserBean;

public interface UserMapper {

	@Select("select * from usertable where user_id = #{user_id} and user_pw = #{user_pw}")
	public UserBean login(UserBean loginBean);
	
	@Select("select user_key from usertable where user_id = #{user_id}")
	public String checkUserIdExist(String user_id);
	
	@Insert("insert into usertable (user_key, user_id, user_pw) "
			+ "values(USER_SEQ_TWO.nextval, #{user_id}, #{user_pw})")
	public void join(UserBean joinUserBean);
}


