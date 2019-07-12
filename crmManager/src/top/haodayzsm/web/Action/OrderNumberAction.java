package top.haodayzsm.web.Action;

import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import top.haodayzsm.utils.Utils;
@Controller(value="orderNumberAction")
@Scope(value="prototype")
public class OrderNumberAction extends ActionSupport {
	
	private String tab;
	public String execute() throws IOException{
		String hql="";
		Utils.print(tab+"2019050270001");
		return null;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	
}