package top.haodayzsm.service;
import java.util.List;

import top.haodayzsm.pojo.User;

public interface IUserService {
	public User login(User user);
	public List findByAll();
	public boolean save(User user);
	public boolean updata(User user);
}
