package top.haodayzsm.web.impl;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import top.haodayzsm.pojo.User;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	public final String ADD = "add";
	public final String LIST = "list";
	public final String HOME = "hoem";
	public final String LOGIN = "login";
	public T model;
	public BaseAction(){
		ParameterizedType Superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = Superclass.getActualTypeArguments();
		Class<T> clazz = (Class<T>) actualTypeArguments[0];
		try {
			model= clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

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
		System.out.println(json);
		print(json);
	}
	public static HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}

	public T getModel() {
		return model;
	}
	public void setModel(T model) {
		this.model = model;
	}
}
