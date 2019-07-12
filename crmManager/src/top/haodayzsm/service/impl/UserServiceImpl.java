package top.haodayzsm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.haodayzsm.dao.IUserDao;
import top.haodayzsm.pojo.User;
import top.haodayzsm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource(name="userDao")
	IUserDao userDao;
	public User login(User user) {
		return userDao.login(user.getUsername(),user.getPassword());
	}
	public List findByAll(){
		return userDao.findAll();
	}
	public boolean save(User user){
		userDao.save(user);
		return true;
	}
	@Override
	public boolean updata(User user) {
		userDao.updata(user);
		return true;
	}
}
