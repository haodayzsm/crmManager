package top.haodayzsm.web.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
	public String success(){
		System.out.println(156465);
		return SUCCESS;
	}
	public T getModel() {
		return model;
	}
	public void setModel(T model) {
		this.model = model;
	}

}
