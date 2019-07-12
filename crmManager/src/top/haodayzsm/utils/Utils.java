package top.haodayzsm.utils;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import top.haodayzsm.pojo.User;

public class Utils {
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	public static User getUser(){
		return (User) getSession().getAttribute("user");
	}
	public static HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	public static void print(String json) throws IOException{
		getResponse().getWriter().print(json);
	}
	public static void print(boolean json) throws IOException{
		getResponse().getWriter().print(json);
	}
	public static void printJson(String json) throws IOException{
		getResponse().setContentType("text/json;charset=utf-8");
		print(json);
	}
	public static HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
}
