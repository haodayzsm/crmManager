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
import top.haodayzsm.web.impl.BaseAction;
@Component(value="customerAction")
@Scope(value="prototype")
public class CustomerAction extends BaseAction<Customer> {
	@Resource(name="customerService")
	ICustomerService customerService;
	private Long id;
	public String save() throws IOException{
		this.print(customerService.save(model));
		return null;
	}
	public String updata() throws IOException{
		this.print(customerService.updata(model));
		return null;
	}
	public String delete() throws IOException{
		this.print(customerService.delete(id));
		return null;
	}
	public String inActivated() throws IOException{
		this.print(customerService.inActivated(model.getCustomer_id()));
		return NONE;
	}
	public String activation() throws IOException{
		this.print(customerService.activation(model.getCustomer_id()));
		return NONE;
	}
	public String list() throws IOException{
		List list = customerService.findByAll();
		this.printJson(JSONArray.fromObject(list).toString());
		return null;
	}
	public String combobox() throws IOException{
		this.printJson(customerService.combobox());
		return null;
	}
	public String activationAll() throws IOException{
		this.printJson(customerService.findAllactivation());
		return NONE;
	}
	public String inActivatedAll() throws IOException{
		this.printJson(customerService.findAllinActivated());
		return NONE;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}	
