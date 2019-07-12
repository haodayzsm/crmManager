package top.haodayzsm.web.impl;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.sf.json.JSONArray;
import top.haodayzsm.pojo.User;
import top.haodayzsm.service.IUserService;
import top.haodayzsm.utils.Utils;

@Controller("userAction")
@Scope(value="prototype")
public class UserAction extends BaseAction<User>{
	@Resource(name="userService")
	IUserService userService;
	public String login(){
		if(model==null){
			return LOGIN;
		}
		User user = userService.login(model);
		System.out.println(top.haodayzsm.utils.MD5Utils.md5(model.getPassword()));
		if(user==null){
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			System.out.println(user);
			return SUCCESS;
		}
	}
	public String logout(){
		Utils.getSession().setAttribute("user", null);
		System.out.println(Utils.getUser());
		return LOGIN;
	}
	public String list() throws IOException	{
		List list=userService.findByAll();
		String json=JSONArray.fromObject(list).toString();
		Utils.printJson(json);
		return NONE;
	}
}
