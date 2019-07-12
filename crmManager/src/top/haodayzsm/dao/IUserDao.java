package top.haodayzsm.dao;

import top.haodayzsm.pojo.User;

public interface IUserDao extends IBaseDao<User>{
	public User login(String username,String password);
}
