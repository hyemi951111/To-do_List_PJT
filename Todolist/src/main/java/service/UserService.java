package service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.UserBean;
import dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Resource(name = "userSession")
	private UserBean userSession;
	
	public void join(UserBean joinUserBean) {
		userDao.join(joinUserBean);
	}
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_key = userDao.checkUserIdExist(user_id);
		
		if(user_key == null) {
			
			return true;
			
		} else {
			
			return false;
		}
		
	}
	
	public UserBean login(UserBean loginBean) {
		
		UserBean logBean = userDao.login(loginBean);
		if(logBean != null) {
			userSession.setUser_key(logBean.getUser_key());
			userSession.setUser_id(logBean.getUser_id());
			userSession.setUserLogin(true);
		}
		
		return logBean;
	}
}
