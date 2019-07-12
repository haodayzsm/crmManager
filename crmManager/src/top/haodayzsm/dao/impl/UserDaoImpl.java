package top.haodayzsm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import top.haodayzsm.dao.*;
import top.haodayzsm.pojo.User;

@Repository(value="userDao")
@Scope(value="prototype")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{
	public User login(String username,String password){
		String hql="from User u where u.username=? and u.password=?";
		List<User> user=null;
		try{			
			user = (List<User>) this.getHibernateTemplate().find(hql,username,top.haodayzsm.utils.MD5Utils.md5(password));
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		if(user.size()!=0){
			return user.get(0);
		}else{
			return null;
		}
	}
}
