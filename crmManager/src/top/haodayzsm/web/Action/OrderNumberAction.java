package top.haodayzsm.web.Action;

import java.io.IOException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.haodayzsm.web.impl.BaseAction;
@Controller(value="orderNumberAction")
@Scope(value="prototype")
public class OrderNumberAction extends BaseAction {
	
	private String tab;
	public String execute() throws IOException{
		String hql="";
		this.print(tab+"2019050270001");
		return null;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	
}