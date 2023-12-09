package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.UserBean;
import mapper.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public void join(UserBean joinUserBean) {
		userMapper.join(joinUserBean);
	}
	
	public UserBean login(UserBean loginBean) {
		
		UserBean logBean = userMapper.login(loginBean);
		
		return logBean;
	}
	
	public String checkUserIdExist(String user_id) {
		
		return userMapper.checkUserIdExist(user_id);
	}
}
