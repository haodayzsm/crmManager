package top.haodayzsm.web.Action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import top.haodayzsm.pojo.Customer;
import top.haodayzsm.service.ICustomerService;
import top.haodayzsm.utils.Utils;
import top.haodayzsm.web.impl.BaseAction;
@Component(value="customerAction")
@Scope(value="prototype")
public class CustomerAction extends BaseAction<Customer> {
	@Resource(name="customerService")
	ICustomerService customerService;
	public String save() throws IOException{
		Utils.print(customerService.save(model));
		return null;
	}
	public String updata() throws IOException{
		Utils.print(customerService.updata(model));
		return null;
	}
	public String delete() throws IOException{
		Utils.print(customerService.delete(model));
		return null;
	}
	public String list() throws IOException{
		List list = customerService.findByAll();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"payment","order","orderReturn"});
		String json=JSONArray.fromObject(list,jsonConfig).toString();
		Utils.printJson(json);
		return null;
	}
	public String combobox() throws IOException{
		Utils.printJson(customerService.combobox());
		return null;
	}
}	
